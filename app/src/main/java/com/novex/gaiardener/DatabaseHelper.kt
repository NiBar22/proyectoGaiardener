package com.novex.gaiardener

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.BufferedReader
import java.io.InputStreamReader

class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "BaseDeDatos.db"  // Nombre del archivo SQLite generado
        private const val DATABASE_VERSION = 1
        private const val SQL_FILE = "database.sql"  // Archivo SQL en assets/
    }

    override fun onCreate(db: SQLiteDatabase) {
        executeSQLScript(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS plantas") // Elimina la tabla si existe
        onCreate(db) // Vuelve a crear la base de datos con la nueva estructura
    }

    // Ejecuta el script SQL desde assets/
    private fun executeSQLScript(db: SQLiteDatabase) {
        try {
            context.assets.open(SQL_FILE).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).use { reader ->
                    val sqlQuery = StringBuilder()

                    reader.forEachLine { line ->
                        val trimmedLine = line.trim()
                        if (trimmedLine.isNotEmpty() && !trimmedLine.startsWith("--")) { // Ignorar comentarios y líneas vacías
                            sqlQuery.append(trimmedLine).append(" ")
                            if (trimmedLine.endsWith(";")) { // Ejecutar solo cuando se completa una sentencia
                                db.execSQL(sqlQuery.toString())
                                sqlQuery.setLength(0) // Limpiar el StringBuilder
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

