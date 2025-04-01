package com.example.dietplan_formativeassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //this is where all of our buttons and text views are declared
        val editTextTime = findViewById<EditText>(R.id.typeTimeOfday)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val foodSuggestionTextView = findViewById<TextView>(R.id.foodSuggestionTextView)

        //in this part of the code , the function of our suggest button is programmed, simply is reads the users input and displays the corresponnding value.
        //for this we use if statements for the various inputs that relate to its corresponding output
        //the outputs are responses to the users input regarding the time of day they have chosen
        suggestButton.setOnClickListener {
            val timeChosen = editTextTime.text.toString().trim().lowercase()

            if (timeChosen == "morning") {
                foodSuggestionTextView.text = "eggs on toast with coffee"
            } else if (timeChosen == "late morning") {
                foodSuggestionTextView.text = "oats in yogurt with fruits"
            } else if (timeChosen == "afternoon") {
                foodSuggestionTextView.text = "grilled chicken wrap and smoothie"
            } else if (timeChosen == "late afternoon") {
                foodSuggestionTextView.text = "pasta salad and glass of water"
            } else if (timeChosen == "night") {
                foodSuggestionTextView.text = "steak and vegetables"
            } else if (timeChosen == "late night") {
                foodSuggestionTextView.text = "hummus dip with pita bread"
            } else {
                foodSuggestionTextView.text = "please enter a valid time of day" // this last line is when a user misspells or inputs an invalid time of day
                //this piece of code was done by me, as i have previous programming experience, although i would not say it was difficult
                //i say this due to the idea that the code stays the same and is a simple example of else if statements
                //if one suggestion is picked, the following output response in the code displays, if not, the else if function executes and will display its following output
            }
            //this code represents our reset button which clears foodSuggestionTextView after
            resetButton.setOnClickListener {
                editTextTime.text.clear()
                foodSuggestionTextView.text = " "
                //this line of code for my reset button was taken from a live session from my IMAD lesson that i took down with a pen and paper from my lecturer Zahra
            }
        }

    }


}





