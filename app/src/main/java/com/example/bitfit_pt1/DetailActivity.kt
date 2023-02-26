package com.example.bitfit_pt1

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    /*all textViews
    private lateinit var exerciseTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var repsTextView: TextView
    private lateinit var setsTextView: TextView*/

    //all editTexts
    private lateinit var exerciseEditText: TextView
    private lateinit var weightEditText: TextView
    private lateinit var repsEditText: TextView
    private lateinit var setsEditText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        exerciseEditText = findViewById(R.id.exercise_input_EV)
        weightEditText = findViewById(R.id.weight_input_EV)
        repsEditText = findViewById(R.id.reps_input_EV)
        setsEditText = findViewById(R.id.sets_input_EV)

        // TODO: Get the extra from the Intent
        val displayExercise = intent.getSerializableExtra(EXERCISE_EXTRA) as DisplayExercise

        // TODO: Set the title, byline, and abstract information from the article
        exerciseEditText.text = displayExercise.exercise
        weightEditText.text = displayExercise.weight.toString()
        repsEditText.text = displayExercise.reps.toString()
        setsEditText.text = displayExercise.sets.toString()
    }
}