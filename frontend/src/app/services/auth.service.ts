import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom, map, Observable } from 'rxjs';
import { jwtDecode } from 'jwt-decode';
import { Router } from '@angular/router';

import { AuthResponsePresenter, UserPresenter } from '../presenters';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    constructor(
        private http: HttpClient,
        private router: Router
    ) {}

    public isAuthenticated(): boolean {
        return !!localStorage.getItem('token');
    }

    public getCurrentUser(): UserPresenter | null {
        const token = localStorage.getItem('token');

        if (!token) {
            return null;
        }

        return this.parseToken(token);
    }

    public async login(username: string, password: string) : Promise<UserPresenter> {
        const response : Observable<UserPresenter> = this.http.post<AuthResponsePresenter>('http://localhost:8010/auth/login', { username, password })
            .pipe(map((response: AuthResponsePresenter) => {
                localStorage.setItem('token', response.token);
                return this.parseToken(response.token);
            }));

        return await lastValueFrom<UserPresenter>(response);
    }

    public async loginAndRedirect(username: string, password: string) {
        await this.login(username, password);
        await this.router.navigate(['/']);
    }

    public async logout() {
        localStorage.removeItem('token');
        await this.router.navigate(['/auth/login']);
    }

    private parseToken(token: string): UserPresenter {
        const decoded = jwtDecode(token);
        const user = (decoded as any)['data'];

        return {
            id: user.id,
            username: user.username,
            email: user.email,
            role: user.role
        };
    }
}
