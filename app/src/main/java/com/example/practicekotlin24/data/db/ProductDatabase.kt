package com.example.practicekotlin24.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practicekotlin24.data.db.dao.ProductDao
import com.example.practicekotlin24.data.entity.product.ProductEntity
import com.example.practicekotlin24.utility.DateConverter

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class ProductDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "ProductDatabase.db"
    }

    abstract fun productDao(): ProductDao
}