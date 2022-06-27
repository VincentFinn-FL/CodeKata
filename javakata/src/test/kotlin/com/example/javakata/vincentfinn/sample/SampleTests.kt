package com.example.javakata.vincentfinn.sample

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class SampleTests {

    @Test
    fun `SampleTest`() {
        expectThat(Sample().greet()).isEqualTo("Hello World.")
    }
}