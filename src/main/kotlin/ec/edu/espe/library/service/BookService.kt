package ec.edu.espe.library.service

import ec.edu.espe.library.dto.BookDto
import ec.edu.espe.library.dto.toEntity
import ec.edu.espe.library.entity.Book
import ec.edu.espe.library.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val authorService: AuthorService) {
    fun getBooks(): List<Book> {
        return bookRepository.findAll().toList();
    }

    fun getBook(id: Long): Book {
        return bookRepository.findById(id).get();
    }

    fun saveBook(dto: BookDto): Book {
        val author = authorService.getAuthor(dto.authorId);
        val book = dto.toEntity();

        if (author.isEmpty) {
            throw ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND, "Author not found");
        }

        return bookRepository.save(book);
    }
}