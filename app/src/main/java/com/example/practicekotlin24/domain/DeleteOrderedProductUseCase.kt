package com.example.practicekotlin24.domain

import com.example.practicekotlin24.data.repository.ProductRepository

class DeleteOrderedProductUseCase(
    private val productRepository: ProductRepository
): UseCase {

    suspend operator fun invoke() {
        return productRepository.deleteAll()
    }
}