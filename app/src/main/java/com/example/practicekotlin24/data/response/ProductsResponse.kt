package com.example.practicekotlin24.data.response

data class ProductsResponse(
    val items: List<ProductResponse>,
    val count: Int
)
