package dev.ky3he4ik.micro_9_2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class PublicServer {
    private val apiSchema = """
        {
          "servers": [
            {
              "name": "Information",
              "base_url": "/info",
              "auth": "АУФ (no auth)",
              "endpoints": [
                {
                  "url": "/",
                  "method": "GET",
                  "description": "info about this",
                  "params": "none",
                  "example": "/info/",
                  "example_payload": null
                },
                {
                  "url": "/api",
                  "method": "GET",
                  "description": "literally this",
                  "params": "none",
                  "example": "/info/api",
                  "example_payload": null
                },
                {
                  "url": "/health",
                  "method": "GET",
                  "description": "health info",
                  "params": "none",
                  "example": "/info/health",
                  "example_payload": null
                }
              ]
            },
            {
              "name": "Storage",
              "base_url": "/store",
              "auth": "SSO for all except /get",
              "endpoints": [
                {
                  "url": "/get_data",
                  "method": "GET",
                  "description": "get all data",
                  "params": "none",
                  "example": "/info/",
                  "example_payload": null
                },
                {
                  "url": "/get",
                  "method": "GET",
                  "description": "get by key",
                  "params": "key: int",
                  "example": "/store/get?key=123",
                  "example_payload": null
                },
                {
                  "url": "/set",
                  "method": "POST",
                  "description": "set key to value",
                  "params": "key: int, value: str",
                  "example": "/store/set",
                  "example_payload": "{\"key\":123,\"value\":\"asd\"}"
                },
                {
                  "url": "/remove",
                  "method": "POST",
                  "description": "remove key",
                  "params": "key: int",
                  "example": "/info/",
                  "example_payload": "{\"key\":123}"
                },
                {
                  "url": "/health",
                  "method": "GET",
                  "description": "health info",
                  "params": "none",
                  "example": "/info/health",
                  "example_payload": null
                }
              ]
            },
            {
              "name": "Common",
              "base_url": "/common",
              "auth": "no",
              "endpoints": [
                {
                  "url": "/health",
                  "method": "GET",
                  "description": "Get health status of both servers",
                  "params": "none",
                  "example": "/common/health",
                  "example_payload": null
                }
              ]
            }
          ]
        }
    """.trimIndent()

    @RequestMapping("/")
    fun info(): String =
        "{\"info\": \"There are 2 servers. One is key-value storage, the other is useless. Choose wisely\"}"

    @RequestMapping("/api")
    fun api(): String = apiSchema

    @RequestMapping("/health")
    fun health(): String = "{\"info\": \"ok\"}"
}

fun main(args: Array<String>) {
    runApplication<PublicServer>(*args)
}