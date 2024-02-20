package ec.edu.espe.library.dto

import ec.edu.espe.library.entity.Author
import ec.edu.espe.library.entity.Book

data class BookDto(
    val id: Long? = null,
    val title: String,
    val synopsis: String,
    val publisher: String,
    val year: Int,
    val authorId: Long
)

fun BookDto.toEntity() = Book(
    id = id ?: 0,
    title = title,
    synopsis = synopsis,
    publisher = publisher,
    year = year,
    author = Author(id = authorId)
)