package ec.edu.espe.library.controller

import ec.edu.espe.library.dto.AuthorDto
import ec.edu.espe.library.entity.Author
import ec.edu.espe.library.service.AuthorService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api")
class AuthorsController (private val authorService: AuthorService) {
    @GetMapping("/authors")
    fun getAuthors(): List<Author> {
        return authorService.getAuthors()
    }

    @GetMapping("/authors/{id}")
    fun getAuthor(@PathVariable id: Long): Optional<Author> {
        return authorService.getAuthor(id)
    }

    @PostMapping("/authors")
    fun saveAuthor(@RequestBody author: AuthorDto): Author {
        return authorService.saveAuthor(author)
    }
}