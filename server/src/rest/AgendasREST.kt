package rest

import agendaPage
import agendas
import data.Agenda
import data.Day
import data.Task
import dayPage
import days
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun Application.agendasRest() {
    routing {
//        get("/agendas") {
//            call.respond(agendas.map { it })
//        }

        get("/agendas/{id}/days") {
            val id = call.parameters["id"]?.toInt() ?: 0
            agendaPage(call, id)
        }

        get("/agendas/{id}/days/{id2}") {
            val id = call.parameters["id"]?.toInt() ?: 0
            val id2 = call.parameters["id2"]?.toInt() ?: 0
            dayPage(call, agendas[id].days[id2]!!.id)
        }

        post("/agendas") {
            val start = call.receive<String>()
//            println("post: start: $start")
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
            val startDate = LocalDate.parse(start, formatter)

            agendas.add(Agenda(startDate))
            call.respond(HttpStatusCode.Accepted)
        }

        post("/agendas/{id}/days") {
            val id = call.parameters["id"]?.toInt() ?: 0
            val received = call.receive<String>().split(";;")
//            println("received: $received")
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-d")
            val dayDate = LocalDate.parse(received[0], formatter)
            agendas[id].days[received[1].toInt()] = Day(dayDate)
            days.add(agendas[id].days[received[1].toInt()]!!)

//            agendas[id].days[received[1].toInt()] = days.last()
            call.respond(HttpStatusCode.Accepted)
        }
    }
}
