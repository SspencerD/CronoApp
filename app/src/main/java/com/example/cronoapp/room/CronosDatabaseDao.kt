package com.example.cronoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cronoapp.model.Cronos
import kotlinx.coroutines.flow.Flow


// Interface , donde se definen los metodos como un repositorio
// Interface -> Repositorio -> ViewModel -> View

@Dao // Data Access Observer

interface CronosDatabaseDao {
    //CRUD
    @Query("SELECT * FROM cronos")
    fun getCronos(): Flow<List<Cronos>>

    @Query("SELECT * FROM cronos WHERE id = :id")
    fun getCronosById(id:Long):Flow<Cronos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cronos: Cronos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(cronos: Cronos)

    @Delete
    suspend fun delete(cronos: Cronos)


}