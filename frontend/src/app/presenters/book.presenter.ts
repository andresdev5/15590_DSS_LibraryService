import { AuthorPresenter } from './author.presenter';

export interface BookPresenter {
    id?: string;
    title?: string;
    synopsis?: string;
    publisher?: string;
    isbn?: string;
    year?: number;
    author?: AuthorPresenter;
}
