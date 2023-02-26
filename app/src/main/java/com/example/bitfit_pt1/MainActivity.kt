package com.example.bitfit_pt1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "MainActivity/"

class MainActivity : AppCompatActivity() {

    private val exercises = mutableListOf<DisplayExercise>()
    private lateinit var exercisesRecyclerView: RecyclerView
    private lateinit var add_exercise: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exerciseAdapter = ExerciseAdapter(this, exercises)
        setContentView(R.layout.activity_main)

        exercisesRecyclerView = findViewById(R.id.exercises)
        exercisesRecyclerView.adapter = exerciseAdapter

        exercisesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            exercisesRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            (application as ExerciseApplication).db.exerciseDao().deleteAll()
            (application as ExerciseApplication).db.exerciseDao()
                .insertAll(exercises.map {
                    ExerciseEntity(
                        exercise = it.exercise,
                        weight = it.weight,
                        reps = it.reps,
                        sets = it.sets
                    )
                })
        }
        add_exercise = findViewById(R.id.add_exercise_BTN)
        add_exercise.setOnClickListener {

        }
    }
}