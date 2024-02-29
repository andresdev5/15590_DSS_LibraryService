import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BookPresenter } from '../presenters/book.presenter';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
    constructor(
        private http: HttpClient
    ) {}

    private baseUrl = 'http://localhost:8010/api/books';

    public getBooks(): Observable<BookPresenter[]> {
        return this.http.get<BookPresenter[]>(this.baseUrl);
    }

    public getBook(id: string): Observable<BookPresenter> {
        return this.http.get(`${this.baseUrl}/${id}`);
    }
}
