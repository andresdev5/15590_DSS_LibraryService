import { PermissionPresenter } from './permission.presenter';

export interface RolePresenter {
    id?: number;
    name?: string;
    description?: string;
    permissions?: PermissionPresenter[];
}
