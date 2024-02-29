package ec.edu.espe.library.controller

import ec.edu.espe.library.dto.BookDto
import ec.edu.espe.library.entity.Book
import ec.edu.espe.library.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BooksController(private val bookService: BookService) {
    @GetMapping("/books")
    fun getBooks(): List<Book> {
        return bookService.getBooks()
    }

    @GetMapping("/books/{id}")
    fun getBook(@PathVariable id: Long): Book {
        return bookService.getBook(id)
    }

    @PostMapping("/admin/books")
    fun saveBook(@RequestBody book: BookDto): Book {
        return bookService.saveBook(book)
    }
}