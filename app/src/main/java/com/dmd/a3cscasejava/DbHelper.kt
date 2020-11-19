package com.dmd.a3cscasejava

import Pokemon
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import retrofit2.http.Url
import java.lang.Exception

class DbHelper(val context: Context){
    private lateinit var database: SQLiteDatabase


    companion object {
        private val DATABASE_NAME = "SQLITE_DATABASE"//database adı
        private val POKEMONS_TABLE_NAME = "Pokemons"//database adı
        private val POKEMON_ID = "ID"
        private val POKEMON_NAME = "Name"
        private val POKEMON_URL = "Url"
    }

    fun isSuccessToCreateOrOpenDb() : Boolean{
        return try {
            database = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null)
            true
        } catch (ignored: Exception){
            false
        }
    }

    fun insertIntoDb(pokemonEntity: Pokemon) : Boolean{
        val pokemonName = pokemonEntity.name
        val pokemonUrl = pokemonEntity.url



        val bindArgs = ArrayList<String>()
        bindArgs.add(pokemonName)
        bindArgs.add(pokemonUrl)
        if (database.isOpen){
            //ID generated from autoincrement
            database.execSQL("INSERT INTO $POKEMONS_TABLE_NAME($POKEMON_NAME, $POKEMON_URL)  VALUES (?, ?)", arrayOf(bindArgs))

        } else {
            return false
        }
        return false
    }

    fun databaseClose(): Boolean {
        return try {
            database.close()
            true
        } catch (ignored: Exception) {
            false
        }
    }

    fun delete(id: Int){
        try {
            database.execSQL("CREATE TABLE IF NOT EXISTS $POKEMONS_TABLE_NAME ($POKEMON_ID INTEGER PRIMARY KEY AUTOINCREMENT, $POKEMON_NAME TEXT, $POKEMON_URL TEXT)")
        } catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun delete(name: String){

    }

    fun delete(url: Url){

    }
}