import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
    standalone: true,
    imports: [
        CommonModule,
        ReactiveFormsModule
    ],
    templateUrl: './login.component.html',
    styleUrl: './login.component.scss',
})
export class LoginComponent {
    form = new FormGroup({
        username: new FormControl(''),
        password: new FormControl('')
    });

    formErrors: string[] = []

    constructor(
        private authService: AuthService,
        private router: Router
    ) {}

    submit() {
        if (this.form.invalid) {
            return;
        }

        const username = this.form.get('username') != null ? this.form.get('username')!.value : null;
        const password = this.form.get('password') != null ? this.form.get('password')!.value : null;

        if (!username || !password) {
            return;
        }

        this.formErrors = [];

        this.authService.login(username, password)
            .catch(() => {
                this.formErrors.push('Credenciales invalidas');
                this.form.setErrors({
                    invalid: true
                });
                return [];
            })
            .then(() => {
                this.router.navigate(['/']);
            });
    }
}
