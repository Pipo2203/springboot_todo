package todo.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.OneToMany
import jakarta.persistence.FetchType
import jakarta.persistence.CascadeType

@Entity
@Table(name = "todo")
class Todo (
    @Id
    @GeneratedValue
    val id: Long = 0,
    var title: String = "",

    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER, cascade = [CascadeType.REMOVE], orphanRemoval = true)
    var todoItems: MutableList<Todoitem> = mutableListOf()
){
    override fun toString(): String {
        return "Todo(id=$id, title$title, todItems)"
    }
}