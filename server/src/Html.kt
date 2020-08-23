import data.Agenda
import io.ktor.application.*
import io.ktor.html.respondHtml
import io.ktor.routing.*
import kotlinx.html.*

val weekDays = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")

fun Application.html(){
    routing {
        get("/agendas") {
            call.respondHtml {
                head {
                    title { +"Morg" }
                    script {
                        type = "text/javascript"
                        src = "../../js/kotlin.js"
                    }
                    script {
                        type = "text/javascript"
                        src = "../../js/client.js"
                    }
                }
                body {
                    p {+"Выберите неделю"}
                    for((id, agenda) in agendas.withIndex()){
                        div {
                            a("/agendas/$id/days") {
                                +"${agenda.start}"
                            }
                        }
                    }
                    p {
                        form {
                            input {
                                id = "start"
                                attributes["type"]= "text"
                            }
                        }
                        button {
                            id = "addAgenda"
                            +"Добавить неделю"
                        }
                    }
                    p {
                        button {
                            id = "allTasks"
                            +"Все задачи"
                        }
                    }
                    p {
                        button {
                            id = "allDays"
                            +"Все дни"
                        }
                    }
                }
            }
        }
    }
}

suspend fun taskPage(call: ApplicationCall, taskLink: String) {
    val t = tasks.find { s -> s.link == taskLink }
    call.respondHtml {
        head {
            title { +t!!.description }
            script {
                type = "text/javascript"
                src = "/js/kotlin.js"
            }
            script {
                type = "text/javascript"
                src = "/js/client.js"
            }
        }
        body {
            p {
                +"${t!!.status}: ${t.description} до ${t.time}"
            }
            p {
                button {
                    id = "addStatus"
                    +"TODO"
                }
                button {
                    id = "chStatus"
                    +"DONE "
                }
                button {
                    id = "delStatus"
                    +"Удалить статус"
                }
            }
            p {
                form {
                    +"Изменить время: "
                    input {
                        id = "newTime"
                        attributes["type"]= "text"
                    }
                }
                button {
                    id = "chTime"
                    +"Изменить время"
                }
            }
            p {
                button {
                    id = "chTask"
                    +"Изменить задачу"
                }
            }
            p {
                button {
                    id = "delTask"
                    +"Удалить задачу"
                }
            }
        }
    }
}

suspend fun dayPage(call: ApplicationCall, dayID: Int) {
//    println("dayID: $dayID")
//    days.forEach{
//        println(it.date)
//    }
    val day = days[dayID]
    call.respondHtml {
        head {
            title { +"${day.date.dayOfWeek}, ${day.date.dayOfMonth} ${day.date.month}" }
            script {
                type = "text/javascript"
                src = "/js/kotlin.js"
            }
            script {
                type = "text/javascript"
                src = "/js/client.js"
            }
        }
        body {
            var i = 0
            for (task in day.tasks) {
                p {
                    +"${task.status}: "
                    a("/days/$dayID/tasks/${i++}") {
                        +task.description
                    }
                    +" до ${task.time}"
                }
            }
            p {
                label { +"Новая задача:" }
                form {
                    +"Статус: "
                    input {
                        id = "status"
                        attributes["type"]= "text"
                    }
                }
                form {
                    +"Описание: "
                    input {
                        id = "description"
                        attributes["type"]= "text"
                    }
                }
                form {
                    +"Время: "
                    input {
                        id = "time"
                        attributes["type"]= "text"
                    }
                }
                button {
                    id = "addTask"
                    +"Добавить задачу"
                }
                label {
//                    attributes["visible"] = "false"
//                    attributes["display"] = "none"
//                    attributes["visibility"] = "hidden"
                    id = "dayID"
                    +"$dayID"
                }
            }
        }
    }
}

suspend fun agendaPage(call: ApplicationCall, agendaID: Int) {
    val agenda = agendas[agendaID]
    call.respondHtml {
        head {
            title { +"Неделя ${agenda.id}" }
            script {
                type = "text/javascript"
                src = "../../js/kotlin.js"
            }
            script {
                type = "text/javascript"
                src = "../../js/client.js"
            }
        }
        body {
            table {
                attributes["border"] = "0"
                attributes["table-layout"] = "fixed"
                caption { +"${agenda.id+1} неделя:" }
                tbody {
                    tr {
                        for (day in 0..6) {
                            th {
                                attributes["width"] = "110"
                                if (agenda.days[day] == null) {
                                    button {
                                        id = "$day"
                                        +"Добавить день"
                                    }
                                } else {
                                    a("/agendas/$agendaID/days/$day") {
                                        +weekDays[day]
                                    }
                                }
                            }
                        }
                    }
                    for (task in 0..10) {
                        tr {
                            for (day in 0..6) {
                                if (agenda.days[day] != null && task < agenda.days[day]!!.tasks.size
                                    && agenda.days[day]!!.tasks.size != 0) {
                                    th {
//                                        a("${agenda.days[day]!!.link}/tasks/$task") {
                                        a("${agenda.days[day]!!.link}/tasks/$task") {
                                            +"Задача №${task+1}"
                                        }
                                    }
                                } else {
                                    th { +" "}
                                }
                            }
                        }
                    }
                }
                label {
                    id = "label"
                    +"${agenda.start}"
                }
                label {
                    id = "agendaID"
                    +"${agenda.id}"
                }
            }
        }
    }
}

suspend fun taskPage(call: ApplicationCall, taskID: Int) {
    val t = tasks[taskID]
    call.respondHtml {
        head {
            title { +t.description }
            script {
                type = "text/javascript"
                src = "/js/kotlin.js"
            }
            script {
                type = "text/javascript"
                src = "/js/client.js"
            }
        }
        body {
            p {
                +"${t.status}: ${t.description} до ${t.time}"
            }
            p {
                button {
                    id = "delStatus"
                    +"Удалить статус"
                }
            }
//            p {
//                button {
//                    id = "addTime"
//                    +"Добавить время"
//                }
//            }
            p {
                button {
                    id = "chTask"
                    +"Изменить задачу"
                }
            }
            p {
                button {
                    id = "delTask"
                    +"Удалить задачу"
                }
            }
        }
    }
}
