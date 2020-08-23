package data

import java.time.LocalDate

var dayIdCounter = 0

class Day(var date: LocalDate) {
    val id = dayIdCounter++
    val link = "/days/$id"
    var tasks = mutableListOf<Task>()

    fun addTask(t: Task) {
        tasks.add(t)
    }

    fun removeTask(t: Task) {
        tasks.remove(t)
    }
}