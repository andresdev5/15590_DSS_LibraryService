import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { HttpClientModule, provideHttpClient, withInterceptors } from '@angular/common/http';

import { routes } from './app.routes';
import { CommonModule } from '@angular/common';
import { tokenInterceptor } from './interceptors/token.interceptor';


export const appConfig: ApplicationConfig = {
    providers: [
        provideRouter(routes),
        importProvidersFrom(HttpClientModule, CommonModule),
        provideHttpClient(
            withInterceptors([tokenInterceptor])
        )
    ],
};
