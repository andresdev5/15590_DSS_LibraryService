package ec.edu.espe.library.dto

data class RoleDto(
    val id: Long? = null,
    val name: String,
    val description: String? = null,
    val permissions: List<PermissionDto> = emptyList()
)

fun RoleDto.toEntity() = ec.edu.espe.library.entity.Role(
    id = id ?: 0,
    name = name,
    description = description ?: "",
    permissions = emptyList()
)