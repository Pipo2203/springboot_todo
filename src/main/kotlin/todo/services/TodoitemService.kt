package todo.services

import todo.entities.Todoitem

interface TodoitemService {
    fun createTodoItem(todoId: Long, todoItem: Todoitem): Todoitem

    fun updateTodoItem(id: Long, todoItem: Todoitem): Todoitem

    fun deleteTodoItem(id: Long): Todoitem

}