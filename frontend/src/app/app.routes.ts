import { Routes } from '@angular/router';
import { DefaultLayoutComponent } from './components/default-layout/default-layout.component';
import { AdminLayoutComponent } from './components/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin/components/admin-dashboard/admin-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { authRoutingGuard } from './services/auth-routing.guard';

export const routes: Routes = [
    {
        path: 'auth',
        component: DefaultLayoutComponent,
        children: [
            {
                path: 'login',
                component: LoginComponent,
            },
        ],
    },
    {
        path: '',
        component: DefaultLayoutComponent,
        canActivate: [authRoutingGuard],
        children: [
            {
                path: '',
                component: HomeComponent,
            },
        ],
    },
    {
        path: 'admin',
        component: AdminLayoutComponent,
        children: [
            {
                path: '',
                component: AdminDashboardComponent,
            },
        ],
    },
];
