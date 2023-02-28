package com.example.bitfit_pt1

import android.content.Intent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exerciseAdapter = ExerciseAdapter(this, exercises)
        setContentView(R.layout.activity_main)

        exercisesRecyclerView = findViewById(R.id.exercises)
        exercisesRecyclerView.adapter = exerciseAdapter

        lifecycleScope.launch {
            (application as ExerciseApplication).db.exerciseDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplayExercise(
                        entity.exercise,
                        entity.weight,
                        entity.reps,
                        entity.sets
                    )
                }.also { mappedList ->
                    exercises.clear()
                    exercises.addAll(mappedList)
                    exerciseAdapter.notifyDataSetChanged()
                }
            }
        }

        exercisesRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            exercisesRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        val addExercise = findViewById<Button>(R.id.add_exercise_BTN)
        addExercise.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            this.startActivity(intent)
        }
    }
}