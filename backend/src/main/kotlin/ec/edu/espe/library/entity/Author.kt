package ec.edu.espe.library.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var firstname: String = "",
    var lastname: String = "",
    var pseudonym: String? = null,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
)