package com.example.javakotlinkata.trainingdemo.moviebuster.catalog

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CatalogTest {

    private val catalogService: CatalogService = LocalCatalogService()
    private val catalog = Catalog(catalogService)

    @Nested
    inner class GetAllMovies {

        @Test
        fun `should return all movies added to the catalog`() {

        }

    }

}