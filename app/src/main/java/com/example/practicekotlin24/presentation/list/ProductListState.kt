package com.example.practicekotlin24.presentation.list

import com.example.practicekotlin24.data.entity.product.ProductEntity

sealed class ProductListState {

    object UnInitialized: ProductListState()

    object Loading: ProductListState()

    data class Success(
        val productList: List<ProductEntity>
    ): ProductListState()

    object Error: ProductListState()
}