package com.example.practicekotlin24.data.db

import android.content.Context
import androidx.room.Room


internal fun provideDB(context: Context): ProductDatabase =
    Room.databaseBuilder(context, ProductDatabase::class.java, ProductDatabase.DB_NAME).build()

internal fun provideToDoDao(database: ProductDatabase) = database.productDao()