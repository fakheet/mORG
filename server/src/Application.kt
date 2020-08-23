import data.*
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.routing.*
import io.ktor.http.content.*
import io.ktor.jackson.jackson
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

val tasks = ArrayList<Task>()
val days = ArrayList<Day>()
val agendas = ArrayList<Agenda>()

val rootURI = "/api"
val host = "http://127.0.0.1:8081"

fun Application.module() {
    testInit()

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        static("js") {
            files("static")
        }
    }
}

var isInit = false
fun testInit() {
    if(!isInit) {
//        tasks.add(Task("task 0, day 0, week 0", "08:00", "TODO"))
//        tasks.add(Task("task 1, day 0, week 0", "10:00", "DONE"))
//        tasks.add(Task("task 2, day 1, week 0", "09:00", "TODO"))
//        tasks.add(Task("task 3, day 2, week 1", "11:00", "DONE"))

//        days.add(Day(LocalDate.now()))
//        days.add(Day(LocalDate.now()))
//        days.add(Day(LocalDate.now()))

//        days[0].addTask(tasks[0])
//        days[0].addTask(tasks[1])
//        days[1].addTask(tasks[2])
//        days[2].addTask(tasks[3])

        agendas.add(Agenda(LocalDate.of(2019, Month.JUNE, 3)))
        agendas.add(Agenda(LocalDate.of(2019, Month.JUNE, 10)))

//        agendas[0].days[0] = days[0]
//        agendas[0].days[1] = days[1]
//        agendas[1].days[0] = days[2]

        isInit=true
    }
}
