package data

var taskIdCounter = 0

class Task(var description: String,
           var time: String,
           var status: String,
           var parentLink: String)
{
    val id = taskIdCounter++
    val link = "/tasks/$id"
}