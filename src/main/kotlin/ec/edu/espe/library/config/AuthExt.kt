package ec.edu.espe.library.config

import ec.edu.espe.library.entity.User
import org.springframework.security.core.Authentication

fun Authentication.toUser(): User {
    return principal as User
}