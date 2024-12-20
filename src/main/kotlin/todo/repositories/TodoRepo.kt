package todo.repositories

import todo.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepo  : JpaRepository<Todo, Long>
