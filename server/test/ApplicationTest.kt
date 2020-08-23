package ea

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import module
import data.*
//import dto.*
//import rest.boardsRest
//import rest.gamesRest
//import rest.playersRest

class ApplicationTest {
//    @Test
//    fun testPlayers(){
//        withTestApplication({
//            module()
//            playersRest()
//            gamesRest()
//        }) {
//            handleRequest(HttpMethod.Get, "/api/players").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val players = jacksonObjectMapper()
//                    .readValue<ArrayList<PlayerDTO>>(response.content ?: "")
//                assertEquals(4, players.size)
//            }
//
//            handleRequest(HttpMethod.Post, "/api/players"){
//                setBody(jacksonObjectMapper().writeValueAsString(Player("Howard")))
//                addHeader("Content-Type", "application/json")
//                addHeader("Accept", "application/json")
//            }.apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//
//            handleRequest(HttpMethod.Get, "/api/players").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val players = jacksonObjectMapper()
//                    .readValue<ArrayList<PlayerDTO>>(response.content ?: "")
//                assertEquals(5, players.size)
//                assertEquals("Howard", players.last().name)
//            }
//        }
//    }
//
//    @Test
//    fun testGames(){
//        withTestApplication({
//            module()
//            playersRest()
//            gamesRest()
//        }) {
//            handleRequest(HttpMethod.Get, "/api/games").apply {
//                val games = jacksonObjectMapper().readValue<ArrayList<GameDTO>>(response.content?:"")
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals(2, games.size)
//            }
//            val gamersJSON = handleRequest(HttpMethod.Get, "/api/players").response.content?:""
//            val gamers = jacksonObjectMapper().readValue<ArrayList<PlayerDTO>>(gamersJSON).map { Player(it.name) }
//
//            handleRequest(HttpMethod.Post, "/api/games"){
//                setBody(jacksonObjectMapper().writeValueAsString(Game(gamers[2], gamers[3])))
//                addHeader("Content-Type", "application/json")
//                addHeader("Accept", "application/json")
//            }.apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//
//            handleRequest(HttpMethod.Get, "/api/games").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val games = jacksonObjectMapper().readValue<ArrayList<GameDTO>>(response.content?:"")
//                assertEquals(3, games.size)
//                assertEquals(gamers[2].name, games.last().player1.name)
//            }
//        }
//    }
//
//    @Test
//    fun testBoards(){
//        withTestApplication({
//            module()
//            playersRest()
//            gamesRest()
//            boardsRest()
//        }) {
//            handleRequest(HttpMethod.Get, "/boards").apply {
//                val boards = jacksonObjectMapper().readValue<ArrayList<BoardDTO>>(response.content?:"")
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals(2, boards.size)
//                for (i in 0 until boards.size) {
//                    assertEquals(i, boards[i].boardId)
//                }
//            }
//
//            handleRequest(HttpMethod.Post, "/boards"){
//                setBody(jacksonObjectMapper().writeValueAsString(Board(Game(Player("1"), Player("2")))))
//                addHeader("Content-Type", "application/json")
//                addHeader("Accept", "application/json")
//            }.apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//
//            handleRequest(HttpMethod.Get, "/boards").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val boards = jacksonObjectMapper().readValue<ArrayList<BoardDTO>>(response.content?:"")
//                assertEquals(3, boards.size)
//            }
//
//            handleRequest(HttpMethod.Delete, "/boards/2")
//
//            handleRequest(HttpMethod.Get, "/boards").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val boards = jacksonObjectMapper().readValue<ArrayList<BoardDTO>>(response.content?:"")
//                assertEquals(2, boards.size)
//            }
//
//            val games: ArrayList<GameDTO>
//            handleRequest(HttpMethod.Get, "/api/games").apply {
//                games = jacksonObjectMapper().readValue(response.content?:"")
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//            val game = Game(Player(games[0].player1.name), Player(games[0].player2.name))
//
//            handleRequest(HttpMethod.Put, "/boards/1") {
//                setBody(jacksonObjectMapper().writeValueAsString(Board(game)))
//                addHeader("Content-Type", "application/json")
//                addHeader("Accept", "application/json")
//            }.apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//
//            handleRequest(HttpMethod.Get, "/boards").apply {
//                val boards = jacksonObjectMapper().readValue<ArrayList<BoardDTO>>(response.content?:"")
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals(boards[1].game.player1.name, "Sheldon")
//                assertEquals(boards[1].game.player2.name, "Leonard")
//            }
//        }
//    }
//
//    @Test
//    fun testGameSteps() {
//        withTestApplication({
//            module()
//            playersRest()
//            gamesRest()
//        }) {
//            val game = jacksonObjectMapper().readValue<ArrayList<GameDTO>>(
//                handleRequest(HttpMethod.Get, "/api/games").response.content ?: ""
//            )[0]
//
//            handleRequest(HttpMethod.Post, "/api/games/0/steps"){
//                setBody(jacksonObjectMapper().writeValueAsString(StepDTO(game.player2, 17, 'P', "HELP")))
//                addHeader("Content-Type", "application/json")
//                addHeader("Accept", "application/json")
//            }.apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//            }
//
//            handleRequest(HttpMethod.Get, "/api/games").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                val games = jacksonObjectMapper().readValue<ArrayList<GameDTO>>(response.content?:"")[0]
//                assertEquals(3, games.steps.size)
//            }
//
//        }
//    }
}
