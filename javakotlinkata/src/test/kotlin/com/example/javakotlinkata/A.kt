package com.example.javakotlinkata

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.fail
import java.nio.charset.StandardCharsets
import java.nio.file.Files.readString
import java.nio.file.Paths

object A {

    private val objectMapper: ObjectMapper = ObjectMapper()

    fun resource(resourcePath: String): String {
        return try {
            readString(Paths.get("src/test/resources/$resourcePath"), StandardCharsets.UTF_8)
        } catch (e: Exception) {
            throw RuntimeException("Failed to find resourcePath")
        }
    }

    fun <T> deserializedJsonResource(resourcePath: String, typeReference: TypeReference<T>): T {
        val jsonResource = resource(resourcePath)
        return deserializedJsonObject(jsonResource, typeReference)!!
    }

    fun <T> deserializedJsonObject(json: String, typeReference: TypeReference<T>?): T? {
        var result: T? = null
        try {
            result = objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(
                    json,
                    typeReference
                )
        } catch (e: JsonProcessingException) {
            fail("Unable to deserialize json")
            e.printStackTrace()
        }
        return result
    }

    @kotlin.Throws(JsonProcessingException::class)
    fun serializedObject(`object`: Object): String {
        return objectMapper.writeValueAsString(`object`)
    }
}