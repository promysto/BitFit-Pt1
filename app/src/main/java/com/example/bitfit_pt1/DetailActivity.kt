package com.example.bitfit_pt1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    //all textViews
    private lateinit var exerciseTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var repsTextView: TextView
    private lateinit var setsTextView: TextView

    //all editTexts
    private lateinit var exerciseInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var repsInput: EditText
    private lateinit var setsInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        exerciseInput = findViewById(R.id.exercise_input_EV)
        weightInput = findViewById(R.id.weight_input_EV)
        repsInput = findViewById(R.id.reps_input_EV)
        setsInput = findViewById(R.id.sets_input_EV)

        //now TVs
        exerciseTextView = findViewById(R.id.exercise_TV)
        weightTextView = findViewById(R.id.weight_TV)
        repsTextView = findViewById(R.id.reps_TV)
        setsTextView = findViewById(R.id.sets_TV)

        //button function
        val recordBtn = findViewById<Button>(R.id.recordBtn)
        recordBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                (application as ExerciseApplication).db.exerciseDao().insertAll(
                    ExerciseEntity(
                        exercise = exerciseInput.text.toString(),
                        weight = weightInput.text.toString().toFloat(),
                        reps = repsInput.text.toString().toInt(),
                        sets = setsInput.text.toString().toInt()
                    )
                )
            }
            finish()
        }
    }
}