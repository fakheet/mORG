package rest

import tasks
import data.Task
import days
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.*
import taskPage

fun Application.tasksRest() {
    routing {
        get("/tasks") {
            call.respond(tasks.map { it })
        }

        get("/tasks/{id}") {
            val id = call.parameters["id"]?.toInt() ?: 0
            taskPage(call, id)
        }

        get("/tasks/{id}/status") {
            val id = call.parameters["id"]?.toInt() ?: 0
            call.respond(tasks[id].status)
        }

        get("/tasks/{id}/time") {
            val id = call.parameters["id"]?.toInt() ?: 0
            call.respond(tasks[id].time)
        }

        post("/tasks") {
//            val taskString = call.receive<String>()
//            val task = taskString.split(";;")
//            tasks.add(Task(task[1] , task[2], task[0], task[3]))
            call.respond(HttpStatusCode.Accepted)
        }

        delete("/tasks/{id}") {
            val id = call.parameters["id"]?.toInt() ?: 0
            days.forEach{
                if (it.link == tasks[id].parentLink) {
                    it.tasks.remove(tasks[id])
                }
            }
            tasks.removeAt(id)
            call.respond(HttpStatusCode.OK)
        }
    }
}