package com.example.bitfit_pt1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercise_table")
    fun getAll(): Flow<List<ExerciseEntity>>

    @Insert
    fun insertAll(articles: ExerciseEntity)

    @Query("DELETE FROM exercise_table")
    fun deleteAll()
}