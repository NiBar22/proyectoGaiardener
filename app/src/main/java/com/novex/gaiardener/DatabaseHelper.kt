package com.novex.gaiardener

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream

class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "BaseDeDatos.sqlite"  // Asegúrate de que el nombre coincida con tu archivo
        private const val DATABASE_VERSION = 1
        private val DATABASE_PATH = "/data/data/com.novex.gaiardener/databases/"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // No creamos la base aquí porque ya la copiamos desde assets
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Puedes manejar actualizaciones si cambias la estructura de la base de datos
    }

    // Verifica si la base de datos ya está copiada en la ruta interna
    fun checkAndCopyDatabase() {
        val dbFile = File(DATABASE_PATH + DATABASE_NAME)
        if (!dbFile.exists()) {
            copyDatabase()
        }
    }

    // Copia la base de datos desde assets a la ruta interna de la app
    private fun copyDatabase() {
        try {
            val inputStream = context.assets.open(DATABASE_NAME)
            val outFileName = DATABASE_PATH + DATABASE_NAME
            val databaseFolder = File(DATABASE_PATH)
            if (!databaseFolder.exists()) {
                databaseFolder.mkdirs()
            }
            val outputStream = FileOutputStream(outFileName)
            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }
            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Abre la base de datos en modo solo lectura
    fun openDatabase(): SQLiteDatabase {
        return SQLiteDatabase.openDatabase(DATABASE_PATH + DATABASE_NAME, null, SQLiteDatabase.OPEN_READONLY)
    }
}
