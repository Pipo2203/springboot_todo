package todo.services.impl

import org.springframework.stereotype.Service
import todo.entities.Todo
import todo.exceptions.NotFoundException
import todo.repositories.TodoRepo
import todo.services.TodoService

@Service
class TodoServiceImpl(val todoRepo: TodoRepo) : TodoService {
    override fun createTodo(todo: Todo): Todo {
        return todoRepo.saveAndFlush(todo)
    }

    override fun getTodo(id: Long): Todo {
        return todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
    }

    override fun getTodoList(): List<Todo> {
        return todoRepo.findAll()
    }

    override fun updateTodo(id: Long, todo: Todo): Todo {
        val existingTodo = todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        existingTodo.title = todo.title
        return todoRepo.saveAndFlush(existingTodo)
    }

    override fun deleteTodo(id: Long): Todo {
        val existingTodo = todoRepo.findById(id).orElseThrow {
            NotFoundException("No Todo with id $id")
        }
        todoRepo.delete(existingTodo)
        return existingTodo
    }
}


