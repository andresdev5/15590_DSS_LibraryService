package ec.edu.espe.library.dto

import ec.edu.espe.library.entity.Author

data class AuthorDto(
    val id: Long? = null,
    val firstname: String,
    val lastname: String,
    val pseudonym: String? = null
)

fun AuthorDto.toEntity() = Author(
    firstname = firstname,
    lastname = lastname,
    pseudonym = pseudonym
)