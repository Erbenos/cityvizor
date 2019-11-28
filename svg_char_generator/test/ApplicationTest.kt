package cz.cityvizor.svg_char_generator

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }



            handleRequest( HttpMethod.Get, "/budget?year=2018" ).apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("<svg xmlns=\"http://www.w3.org/2000/svg\"><a></a></svg>", response.content)
            }
        }
    }
}
