package ec.edu.espe.library.dto

import ec.edu.espe.library.entity.Permission

data class PermissionDto(
    val id: Long? = null,
    val name: String,
    val description: String? = null
)

fun PermissionDto.toEntity() = Permission(
    id = id ?: 0,
    name = name,
    description = description ?: ""
)
