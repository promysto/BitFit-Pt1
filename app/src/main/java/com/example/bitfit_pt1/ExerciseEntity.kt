package com.example.bitfit_pt1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "Exercise") val exercise: String?,
    @ColumnInfo(name = "weight") val weight: Float?,
    @ColumnInfo(name = "reps") val reps: Int?,
    @ColumnInfo(name = "sets") val sets: Int?
)