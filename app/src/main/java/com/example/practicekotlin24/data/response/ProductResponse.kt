package com.example.practicekotlin24.data.response

import com.example.practicekotlin24.data.entity.product.ProductEntity
import java.util.*

data class ProductResponse(
    val id: String,
    val createdAt: Long,
    val productName: String,
    val productPrice: String,
    val productImage: String,
    val productType: String,
    val productIntroduct: String
) {

    fun toEntity(): ProductEntity =
        ProductEntity(
            id = id.toLong(),
            createdAt = Date(createdAt),
            productName = productName,
            productPrice = productPrice.toDouble().toInt(),
            productImage = productImage,
            productType = productType,
            productIntroduct = productIntroduct
        )
}
