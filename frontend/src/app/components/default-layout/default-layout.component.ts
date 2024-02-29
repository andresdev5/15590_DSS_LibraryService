import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
    standalone: true,
    imports: [RouterOutlet, CommonModule],
    templateUrl: './default-layout.component.html',
    styleUrl: './default-layout.component.scss',
})
export class DefaultLayoutComponent {
    constructor(
        private router: Router,
        private authService: AuthService
    ) {}

    isLoggedIn() {
        return this.authService.isAuthenticated();
    }

    async logout() {
        await this.authService.logout();
    }
}
