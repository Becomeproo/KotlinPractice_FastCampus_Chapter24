package com.example.practicekotlin24.domain

import com.example.practicekotlin24.data.entity.product.ProductEntity
import com.example.practicekotlin24.data.repository.ProductRepository

internal class GetOrderedProductListUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getLocalProductList()
    }
}