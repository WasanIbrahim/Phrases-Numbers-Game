package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbersGame = findViewById<Button>(R.id.NumbersButton)
        val PhrasesGame = findViewById<Button>(R.id.PhrasesButton)


        numbersGame.setOnClickListener{
            val intent = Intent(this, NumbersGame::class.java)
            startActivity(intent)
        }
        PhrasesGame.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
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
        }
        return super.onOptionsItemSelected(item)
    }
}