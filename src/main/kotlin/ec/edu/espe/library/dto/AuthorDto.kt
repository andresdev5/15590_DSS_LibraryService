package ec.edu.espe.library.dto

import ec.edu.espe.library.entity.Author

data class AuthorDto(
    val id: Long,
    val firstname: String,
    val lastName: String,
)

fun AuthorDto.toEntity() = Author(
    id = id,
    firstname = firstname,
    lastname = lastName
)