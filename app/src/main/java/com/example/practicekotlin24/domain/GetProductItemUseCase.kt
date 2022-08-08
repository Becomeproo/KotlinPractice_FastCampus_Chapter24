package com.example.practicekotlin24.domain

import com.example.practicekotlin24.data.entity.product.ProductEntity
import com.example.practicekotlin24.data.repository.ProductRepository

internal class GetProductItemUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(productId: Long): ProductEntity? {
        return productRepository.getProductItem(productId)
    }
}