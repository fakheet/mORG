package data

import java.time.LocalDate

var agendaIdCounter = 0

class Agenda(val start: LocalDate) {
    val id = agendaIdCounter++
    val link = "/days/$id"
    var days = arrayOfNulls<Day>(7)

    fun initWeek() {
        for (i in 0..6) {
//            days[0] = Day()
        }
    }
}