package com.example.bitfit_pt1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val EXERCISE_EXTRA = "EXERCISE_EXTRA"
private const val TAG = "ExerciseAdapter"

class ExerciseAdapter(private val context: Context, private val displayExercises: List<DisplayExercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_exercise, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = displayExercises[position]
        holder.bind(article)
    }

    override fun getItemCount() = displayExercises.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val exerciseTextView = itemView.findViewById<TextView>(R.id.exercise_input_EV)
        private val weightTextView = itemView.findViewById<TextView>(R.id.weight_input_EV)
        private val repsTextView = itemView.findViewById<TextView>(R.id.reps_input_EV)
        private val setsTextView = itemView.findViewById<TextView>(R.id.sets_input_EV)


        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(displayExercise: DisplayExercise) {
            exerciseTextView.text = displayExercise.exercise
            weightTextView.text = displayExercise.weight.toString()
            repsTextView.text = displayExercise.reps.toString()
            setsTextView.text = displayExercise.sets.toString()
        }
        override fun onClick(v: View?) {
            // Get selected exercise
            val exercise = displayExercises[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected exercise
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXERCISE_EXTRA, exercise)
            context.startActivity(intent)
        }
    }
}