package com.romasks.cardholder.data.datasource.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

class Converters {

    companion object {
        @TypeConverter
        @JvmStatic
        fun fromBitmap(value: Bitmap?): String {
            val byteArray: ByteArray = ByteArrayOutputStream().let { stream ->
                value?.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.toByteArray()
            }
            return Base64.encodeToString(byteArray, Base64.DEFAULT)
        }

        @TypeConverter
        @JvmStatic
        fun toBitmap(value: String): Bitmap? = try {
            val encodeByte: ByteArray = Base64.decode(value, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
