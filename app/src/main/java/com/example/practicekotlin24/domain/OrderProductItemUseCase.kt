package com.example.practicekotlin24.domain

import com.example.practicekotlin24.data.entity.product.ProductEntity
import com.example.practicekotlin24.data.repository.ProductRepository

internal class OrderProductItemUseCase (
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(productEntity: ProductEntity): Long {
        return productRepository.insertProductItem(productEntity)
    }
}
