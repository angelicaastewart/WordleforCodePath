package com.example.wordle

import FourLetterWordList.getRandomFourLetterWord
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    //val submit = findViewById<Button>(R.id.submitButton)


    //count the number of chances
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var ans = getRandomFourLetterWord()
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == ans[i]) {
                result += "O"
            }
            else if (guess[i] in ans) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
    var count = 0

    fun onTap(view: View){

        if(count == 0) {
            val guess1 = findViewById<EditText>(R.id.guess_1)
            val text1 = guess1.text.toString().uppercase()
            val answer1 = checkGuess(text1)
            findViewById<TextView>(R.id.answer_1).text = answer1



        } else
        if(count == 1) {
            val guess2 = findViewById<EditText>(R.id.guess_2)
            val text2 = guess2.text.toString().uppercase()
            val answer2 = checkGuess(text2)
            findViewById<TextView>(R.id.answer_2).text = answer2

        } else
        if(count > 2){
            view?.isEnabled = false
            val guess3 = findViewById<EditText>(R.id.guess_3)
            val text3 = guess3.text.toString().uppercase()
            val answer3 = checkGuess(text3)
            findViewById<TextView>(R.id.answer_3).text = answer3
            findViewById<TextView>(R.id.textView).text = ans
        }
        count ++
        }
}