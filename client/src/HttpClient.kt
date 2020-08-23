import org.w3c.xhr.XMLHttpRequest

object HTTPClient{

    fun get(url:String, header: String =  "application/json",
            call: (String) -> Unit) {
        val xhttp = XMLHttpRequest()
        xhttp.open("GET", url, true)
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send()
    }

    fun post(url: String, body: String, header: String =  "application/json",
             call: (String) -> Unit) {
        val xhttp = XMLHttpRequest()
        xhttp.open("POST", url, true)
        xhttp.setRequestHeader("Content-Type", header)
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send(body)
    }

    fun put(url: String, body: String, header: String =  "application/json",
            call: (String) -> Unit) {
        val xhttp = XMLHttpRequest()
        xhttp.open("PUT", url, true)
        xhttp.setRequestHeader("Content-Type", header)
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send(body)
    }

    fun delete(url:String, header: String =  "application/json",
               call: (String) -> Unit) {
        val xhttp = XMLHttpRequest()
        xhttp.open("DELETE", url, true)
        xhttp.setRequestHeader("Accept", header)
        xhttp.onload = {
            call(xhttp.responseText)
        }
        xhttp.send()
    }
}