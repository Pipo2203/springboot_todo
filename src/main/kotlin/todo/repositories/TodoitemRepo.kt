package todo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import todo.entities.Todoitem

interface TodoitemRepo : JpaRepository<Todoitem, Long> {
}