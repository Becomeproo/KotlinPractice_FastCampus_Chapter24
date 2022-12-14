package com.example.practicekotlin24.presentation.detail

import com.example.practicekotlin24.data.entity.product.ProductEntity

sealed class ProductDetailState {

    object Uninitialized : ProductDetailState()

    object Loading : ProductDetailState()

    data class Success(
        val productEntity: ProductEntity
    ) : ProductDetailState()

    object Order : ProductDetailState()

    object Error : ProductDetailState()
}