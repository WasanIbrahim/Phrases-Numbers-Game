package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class NumbersGame : AppCompatActivity() {

    var message = ArrayList<String>()
    lateinit var submit: Button //submit button
    lateinit var textEnter: TextView //the guessing field

    private var answer = 0 //then set it to random
    private var guesses = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_game)

        submit = findViewById(R.id.submit)
        textEnter = findViewById(R.id.textEnter)
        answer = Random.nextInt(10)

        submit.setOnClickListener {
            val myRV = findViewById<RecyclerView>(R.id.rvMain)
            myRV.adapter = RecyclerViewAdapter(message)
            myRV.layoutManager = LinearLayoutManager(this) // main activity
            checkMessage()
            println("the correct answer is $answer")
            textEnter.text = null
        }
    }
    fun checkMessage() {
        val msg = textEnter.text.toString()
        println("here is the message $msg")
        if (msg.isNotEmpty()) {
            if (guesses < 3) {
                if (msg.toInt() == answer) {
                    submit.isEnabled = false
                    submit.isClickable = false
                    textEnter.isEnabled = false
                    textEnter.isClickable = false

                    message.add(" correct answer: $msg")
                    println("correct guess")
                } else {
                    guesses++
                    message.add(
                        "wrong guess, you guessed $msg " +
                                "you have guessed  $guesses/3"
                    )
                    println("wrong guess")

                }
                if (guesses == 3) {
                    submit.isEnabled = false
                    submit.isClickable = false
                    textEnter.isEnabled = false
                    textEnter.isClickable = false
                    message.add("Game over. the correct answer is $answer")
                    println("Game over")
                }
            }

        }
    }


    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NumbersGame -> {
                val intent = Intent(this, NumbersGame::class.java)
                startActivity(intent)
            }
            R.id.GuessThePhrase -> {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.myMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}