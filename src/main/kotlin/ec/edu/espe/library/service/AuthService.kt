package ec.edu.espe.library.service

import ec.edu.espe.library.config.toUser
import ec.edu.espe.library.dto.AuthCredentialsDto
import ec.edu.espe.library.dto.AuthResponseDto
import ec.edu.espe.library.entity.User
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.server.ResponseStatusException
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AuthService(
    private val userService: UserService,
    private val tokenService: TokenService) {

    @Transactional
    fun login(credentials: AuthCredentialsDto): AuthResponseDto {
        val user = userService.findByUsername(credentials.username)

        if (user == null || !checkBcrypt(credentials.password, user.password)) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials")
        }

        val token = tokenService.createToken(user)
        return AuthResponseDto(token)
    }

    fun hasPermission(permission: String): Boolean {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val user = authentication.toUser()
        return user.role.permissions.any { it.name.lowercase().trim() == permission.lowercase().trim() }
    }

    fun hasPermission(permission: String, userId: Long): Boolean {
        val userOptional: Optional<User> = userService.findById(userId)

        if (userOptional.isEmpty) {
            return false
        }

        val user = userOptional.get()
        return user.role.permissions.any { it.name.lowercase().trim() == permission.lowercase().trim() }
    }

    fun hasPermission(permission: String, user: User) : Boolean {
        return user.role.permissions.any { it.name.lowercase().trim() == permission.lowercase().trim() }
    }

    fun hashBcrypt(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    private fun checkBcrypt(input: String, hash: String): Boolean {
        return BCrypt.checkpw(input, hash)
    }
}