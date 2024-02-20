package ec.edu.espe.library.dto

import ec.edu.espe.library.entity.Author
import ec.edu.espe.library.entity.Book
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.ISBN

data class BookDto(
    val id: Long? = null,

    @NotNull
    @NotEmpty
    val title: String,

    @NotNull
    @NotEmpty
    val synopsis: String,

    @NotNull
    @NotEmpty
    val publisher: String,

    @ISBN
    val isbn: String,

    @Min(0)
    val year: Int,
    val authorId: Long
)

fun BookDto.toEntity() = Book(
    id = id ?: 0,
    title = title,
    synopsis = synopsis,
    publisher = publisher,
    isbn = isbn,
    year = year,
    author = Author(id = authorId)
)