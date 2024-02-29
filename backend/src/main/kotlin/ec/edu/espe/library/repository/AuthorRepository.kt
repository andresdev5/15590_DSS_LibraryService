package ec.edu.espe.library.repository

import ec.edu.espe.library.entity.Author
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository : CrudRepository<Author, Long> {}