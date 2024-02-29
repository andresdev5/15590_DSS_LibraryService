package ec.edu.espe.library.controller

import ec.edu.espe.library.dto.AuthCredentialsDto
import ec.edu.espe.library.dto.AuthResponseDto
import ec.edu.espe.library.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService) {
    @PostMapping("/auth/login")
    fun login(@RequestBody credentials: AuthCredentialsDto): AuthResponseDto {
        return authService.login(credentials)
    }
}