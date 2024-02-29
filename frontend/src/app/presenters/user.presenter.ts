import { RolePresenter } from './role.presenter';

export interface UserPresenter {
    id?: number;
    username?: string;
    role?: RolePresenter;
    email?: string;
}
