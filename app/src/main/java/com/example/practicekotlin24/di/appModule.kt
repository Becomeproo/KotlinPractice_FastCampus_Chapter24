package com.example.practicekotlin24.di

import com.example.practicekotlin24.data.db.provideDB
import com.example.practicekotlin24.data.db.provideToDoDao
import com.example.practicekotlin24.data.network.buildOkHttpClient
import com.example.practicekotlin24.data.network.provideGsonConverterFactory
import com.example.practicekotlin24.data.network.provideProductApiService
import com.example.practicekotlin24.data.network.provideProductRetrofit
import com.example.practicekotlin24.data.preference.PreferenceManager
import com.example.practicekotlin24.data.repository.DefaultProductRepository
import com.example.practicekotlin24.data.repository.ProductRepository
import com.example.practicekotlin24.domain.*
import com.example.practicekotlin24.domain.GetOrderedProductListUseCase
import com.example.practicekotlin24.domain.GetProductItemUseCase
import com.example.practicekotlin24.domain.GetProductListUseCase
import com.example.practicekotlin24.domain.OrderProductItemUseCase
import com.example.practicekotlin24.presentation.detail.ProductDetailViewModel
import com.example.practicekotlin24.presentation.list.ProductListViewModel
import com.example.practicekotlin24.presentation.main.MainViewModel
import com.example.practicekotlin24.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ViewModels
    viewModel { MainViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProfileViewModel(get(), get(), get()) }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

    // Coroutines Dispatcher
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    // UseCases
    factory { GetProductItemUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }
    factory { GetOrderedProductListUseCase(get()) }
    factory { DeleteOrderedProductUseCase(get()) }

    // Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }

    single { buildOkHttpClient() }

    single { provideProductRetrofit(get(), get()) }

    single { provideProductApiService(get()) }

    single { PreferenceManager(androidContext()) }

    // Room
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }

}