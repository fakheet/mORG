class Caller {
    fun allTasks() {
        HTTPClient.get("/tasks") { }
    }

    fun allDays() {
        HTTPClient.get("/days") { }
    }

    fun addAgenda(start: String) {
        println("addAgenda, start: $start")
        HTTPClient.post("/agendas", start) {
            println("received: \"$it\"")
        }
    }

    fun addTaskToDay(taskString: String, dayID: String) {
        println(taskString)
//        HTTPClient.post("/tasks", taskString) { }
        HTTPClient.post("/days/$dayID/tasks", "$taskString;;/days/$dayID") { }
    }

    fun addDayToWeek(dayString: String, agendaID: String, dayID: String) {
//        println("dayString: $dayString")
//        println("agendaID: $agendaID")
//        println("dayID: $dayID")
        HTTPClient.post("/days", dayString) {}
        HTTPClient.post("/agendas/$agendaID/days", "$dayString;;$dayID") {}
    }

    fun delTask(dayID: String, taskID: String) {
        HTTPClient.delete("/days/$dayID/tasks/$taskID") {}
    }

    fun delStatus(dayID: String, taskID: String) {
        println("id: $taskID")
        HTTPClient.delete("/days/$dayID/tasks/$taskID/status") {}
    }

    fun addStatus(dayID: String, taskID: String) {
        HTTPClient.post("/days/$dayID/tasks/$taskID/status", "TODO") {}
    }

    fun chStatus(dayID: String, taskID: String) {
        HTTPClient.put("/days/$dayID/tasks/$taskID/status", "DONE") {}
    }

    fun chTime(dayID: String, taskID: String, newTime: String) {
        HTTPClient.put("/days/$dayID/tasks/$taskID/time", newTime) {}
    }
}