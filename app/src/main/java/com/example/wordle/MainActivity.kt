package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.core.view.forEach
import com.example.wordle.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var words = listOf("among", "jiggs", "diner", "miner", "sussy", "dylan")
    var boardList = mutableListOf<TextView>()
    var wordToGuess = words[Random.nextInt(0, words.size)]
    var wordList = wordToGuess.toList()
    var playerWord = mutableListOf<String>()
    private lateinit var checkButton: Button
    private var round = 0
    private var counter = 0

    internal lateinit var lettersLayout: ConstraintLayout

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()


        lettersLayout = findViewById(R.id.lettersLayout)
        checkButton = findViewById(R.id.Check)

        lettersLayout.children.forEach { letterView ->
            if(letterView is TextView){
                letterView.setOnClickListener{
                    if(letterView.text == "Back"){
                        if(playerWord.size <1){
                            playerWord = mutableListOf<String>()


                        } else

                        playerWord.removeLast()

                    }
                    else
                    playerWord.add(letterView.text.toString().lowercase(Locale.getDefault()))
                    println(playerWord)
                    //Logic for displaying words

                   for (view in boardList){

                       boardList[counter].text = playerWord[counter]
                       println(playerWord)

                   }
                    counter += 1


                }
            }
        }

        checkButton.setOnClickListener{
            round += 1
            if(playerWord.toString() == wordList.toString()){
                println("lmao")
            }
            else
                println("wrong")
        }




        Log.d("burh", wordToGuess)
        println(wordList)
    }
private fun initBoard(){
    boardList.add(binding.a1)
    boardList.add(binding.a2)
    boardList.add(binding.a3)
    boardList.add(binding.a4)
    boardList.add(binding.a5)
    boardList.add(binding.b1)
    boardList.add(binding.b2)
    boardList.add(binding.b3)
    boardList.add(binding.b4)
    boardList.add(binding.b5)
    boardList.add(binding.c1)
    boardList.add(binding.c2)
    boardList.add(binding.c3)
    boardList.add(binding.c4)
    boardList.add(binding.c5)
    boardList.add(binding.d1)
    boardList.add(binding.d2)
    boardList.add(binding.d3)
    boardList.add(binding.d4)
    boardList.add(binding.d5)
    boardList.add(binding.e1)
    boardList.add(binding.e2)
    boardList.add(binding.e3)
    boardList.add(binding.e4)
    boardList.add(binding.e5)
    boardList.add(binding.f1)
    boardList.add(binding.f2)
    boardList.add(binding.f3)
    boardList.add(binding.f4)
    boardList.add(binding.f5)
}

}

