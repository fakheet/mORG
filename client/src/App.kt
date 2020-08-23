import org.w3c.dom.*
import org.w3c.dom.events.EventListener
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        val handler = Caller()
        val regMain = Regex("http://127\\.0\\.0\\.1:8082/agendas/?")
        val regAgenda = Regex("http://127\\.0\\.0\\.1:8082/agendas/[0-9]+/days/?")
        val regDay = Regex("http://127\\.0\\.0\\.1:8082/agendas/[0-9]+/days/[0-9]+/?")
        val regDayTask = Regex("http://127\\.0\\.0\\.1:8082/days/[0-9]+/tasks/[0-9]+/?")
        val regTask = Regex("http://127\\.0\\.0\\.1:8082/tasks/\\d+/?")


        println(window.document.URL)
        when {
            window.document.URL.matches(regMain) -> {
                println("matched regMain")
                val start = document.getElementById("start") as HTMLInputElement
                val newAgenda = document.getElementById("addAgenda") as HTMLButtonElement
                val allTasks  = document.getElementById("allTasks") as HTMLButtonElement
                val allDays = document.getElementById("allDays") as HTMLButtonElement

                newAgenda.addEventListener("click", EventListener {
                    println(start.value)
                    handler.addAgenda(start.value)
                })

                allTasks.addEventListener("click", EventListener {
                    handler.allTasks()
                })

                allDays.addEventListener("click", EventListener {
                    handler.allDays()
                })
            }

            window.document.URL.matches(regAgenda) -> {
                println("matched regAgenda")
                val elements = document.getElementsByTagName("button")
                val buttons = Array(elements.length) { elements[it] as HTMLButtonElement}
                val agendaID = document.getElementById("agendaID") as HTMLLabelElement
                val start = document.getElementById("label") as HTMLLabelElement
                val startDate = start.textContent!!.split("-")
                agendaID.hidden = true
                start.hidden = true

                buttons.forEach {
                    val buttonID = it.id

//                    println("startDate: ${startDate[2]}")
//                    println("buttonID: $buttonID")

                    val day = startDate[2].toInt() + buttonID.toInt()
//                    println("day: $day")
                    val newDate = startDate.toMutableList()
                    newDate[2] = day.toString()
                    val date = newDate.joinToString("-")

//                    println("changed date: $date")
                    it.addEventListener("click", EventListener {
//                        println("clicked $buttonID")
                        handler.addDayToWeek(date, agendaID.textContent!!, buttonID)
                    })
                }
            }

            window.document.URL.matches(regDay) -> {
                println("matched regDay")
                val status = document.getElementById("status") as HTMLInputElement
                val description = document.getElementById("description") as HTMLInputElement
                val time = document.getElementById("time") as HTMLInputElement
                val button = document.getElementById("addTask") as HTMLButtonElement
                val dayID = document.getElementById("dayID") as HTMLLabelElement
                dayID.hidden = true
                val dayIdText = dayID.textContent as String

                button.addEventListener("click", EventListener {
                    handler.addTaskToDay("${status.value};;${description.value};;${time.value}", dayIdText)
                })
            }

            window.document.URL.matches(regTask) || window.document.URL.matches(regDayTask) -> {
                println("matched regTask")
                val addStatus = document.getElementById("addStatus") as HTMLButtonElement
                val chStatus = document.getElementById("chStatus") as HTMLButtonElement
                val delStatus = document.getElementById("delStatus") as HTMLButtonElement
                val chTime = document.getElementById("chTime") as HTMLButtonElement
                val delTask = document.getElementById("delTask") as HTMLButtonElement
                val newTime = document.getElementById("newTime") as HTMLInputElement

                addStatus.addEventListener("click", EventListener {
                    val r = Regex("\\d+")
                    val m = r.findAll(window.location.pathname).toList()
                    handler.addStatus(m[0].groupValues[0], m[1].groupValues[0])
                })

                chStatus.addEventListener("click", EventListener {
                    val r = Regex("\\d+")
                    val m = r.findAll(window.location.pathname).toList()
                    handler.chStatus(m[0].groupValues[0], m[1].groupValues[0])
                })

                chTime.addEventListener("click", EventListener {
                    val r = Regex("\\d+")
                    val m = r.findAll(window.location.pathname).toList()
                    handler.chTime(m[0].groupValues[0], m[1].groupValues[0], newTime.value)
                    // not how it should be!
                })

                // works ahead
                delStatus.addEventListener("click", EventListener {
                    println("delStatus")
                    val r = Regex("\\d+")
                    val m = r.findAll(window.location.pathname).toList()
                    handler.delStatus(m[0].groupValues[0], m[1].groupValues[0])
//                    println(m[0].groupValues[0])
//                    println(window.location.pathname)
                })

                delTask.addEventListener("click", EventListener {
                    val r = Regex("\\d+")
                    val m = r.findAll(window.location.pathname).toList()
                    handler.delTask(m[0].groupValues[0], m[1].groupValues[0])
                })
            }
        }
        "OK"
    }
}