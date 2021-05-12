package com.romasks.cardholder.data.datasource.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.romasks.cardholder.data.datasource.db.dao.BarcodesDao
import com.romasks.cardholder.data.datasource.db.dao.CardsDao
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import com.romasks.cardholder.data.datasource.db.entities.Card

@Database(entities = [Barcode::class, Card::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val barcodesDao: BarcodesDao

    abstract val cardsDao: CardsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "card_holder_database"
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}