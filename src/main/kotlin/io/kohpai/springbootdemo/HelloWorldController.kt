package io.kohpai.springbootdemo

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(private val om: ObjectMapper) {
    @GetMapping(path = ["/helloworld"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun sayHelloAsText() = "Hello World!"

    @GetMapping(path = ["/helloworld"], produces = [MediaType.TEXT_HTML_VALUE])
    fun sayHelloAsHtml() =
        """
            <html>
            <body>
            <h1>Hello World!</h1>
            </body>
            </html>
        """.trimIndent()

    @GetMapping(path = ["/helloworld"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sayHelloAsJson(): String {
        val objectNode = om.createObjectNode()
        objectNode.put("message", "Hello World!")

        return objectNode.toString()
    }
}