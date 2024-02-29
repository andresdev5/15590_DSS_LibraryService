import { Component, OnInit } from '@angular/core';
import { BookService } from '../../services/book.service';

@Component({
    standalone: true,
    imports: [],
    templateUrl: './home.component.html',
    styleUrl: './home.component.scss',
})
export class HomeComponent {
    books: any[] = [];

    constructor(
        private bookService: BookService
    ) {}

    ngOnInit() {
        this.bookService.getBooks().subscribe(books => {
            this.books = books;
        })
    }
}
