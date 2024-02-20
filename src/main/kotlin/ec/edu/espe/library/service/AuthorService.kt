package ec.edu.espe.library.service

import ec.edu.espe.library.dto.AuthorDto
import ec.edu.espe.library.dto.toEntity
import ec.edu.espe.library.entity.Author
import ec.edu.espe.library.repository.AuthorRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AuthorService (private val authorRepository: AuthorRepository) {
    fun getAuthors(): List<Author> {
        return authorRepository.findAll().toList();
    }

    fun getAuthor(id: Long): Optional<Author> {
        return authorRepository.findById(id);
    }

    fun saveAuthor(author: AuthorDto): Author {
        return authorRepository.save(author.toEntity());
    }
}