package rest

import days
import data.Day
import data.Task
import dayPage
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.*
import io.ktor.util.url
import taskPage
import tasks
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun Application.daysRest() {
    routing {
        get("/days") {
            call.respond(days.map { it })
        }

        get("/days/{id}/tasks") {
            val id = call.parameters["id"]?.toInt() ?: 0
            dayPage(call, id)
        }

        get("/days/{id}/tasks/{id2}") {
            val id = call.parameters["id"]?.toInt() ?: 0
            val id2 = call.parameters["id2"]?.toInt() ?: 0
            println("id: $id, id2: $id2")
//            call.respondRedirect(days[id].tasks[id2].link)
//            call.respond(days[id].tasks[id2].link)
//            println(days[id].tasks[id2].description)
//            println(days[id].tasks[id2].id)
            taskPage(call, days[id].tasks[id2].link)
        }

        get("/days/{dayID}/tasks/{taskID}/status") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            call.respond(days[dayID].tasks[taskID].status)
        }

        get("/days/{dayID}/tasks/{taskID}/time") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            call.respond(days[dayID].tasks[taskID].time)
        }

        post("/days") {
            val dayString = call.receive<String>()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
            val dayDate = LocalDate.parse(dayString, formatter)
            days.add(Day(dayDate))
            call.respond(HttpStatusCode.Accepted)
        }

        post("/days/{id}/tasks") {
            val id = call.parameters["id"]?.toInt() ?: 0
            val taskString = call.receive<String>()
            val task = taskString.split(";;")
//            println(taskString)
//            println("task[3]: ${task[3]}")
            days[id].tasks.add(Task(task[1] , task[2], task[0], task[3]))
            tasks.add(days[id].tasks.last())
            call.respond(HttpStatusCode.Accepted)
        }

        post("/days/{dayID}/tasks/{taskID}/status") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            days[dayID].tasks[taskID].status = "TODO"
            call.respond(HttpStatusCode.OK)
        }

        put("/days/{dayID}/tasks/{taskID}/time") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            val newTime = call.receive<String>()
            days[dayID].tasks[taskID].time = newTime
            call.respond(HttpStatusCode.OK)
        }

        put("/days/{dayID}/tasks/{taskID}/status") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            days[dayID].tasks[taskID].status = "DONE"
            call.respond(HttpStatusCode.OK)
        }

        delete("/days/{id}/tasks/{id2}") {
            val id = call.parameters["id"]?.toInt() ?: 0
            val id2 = call.parameters["id2"]?.toInt() ?: 0
            days[id].tasks.removeAt(id2)
            call.respond(HttpStatusCode.OK)
        }

        delete("/days/{dayID}/tasks/{taskID}/status") {
            val dayID = call.parameters["dayID"]?.toInt() ?: 0
            val taskID = call.parameters["taskID"]?.toInt() ?: 0
            days[dayID].tasks[taskID].status = ""
            call.respond(HttpStatusCode.OK)
        }
    }
}
