package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.indexOf
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.*
import com.example.wordle.R.color.*
import com.example.wordle.databinding.ActivityMainBinding
import java.util.*
import java.util.Date.from
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var words = listOf("among", "jiggs", "diner", "miner", "sussy", "dylan", "anger", "today", "allow", "abhor", "whack", "words", "brand" )
    var boardList = mutableListOf<TextView>()
    var wordToGuess = words[Random.nextInt(0, words.size)]
    var wordList = wordToGuess.toList()
    var playerWord = mutableListOf<String>()
    private lateinit var checkButton: Button
    private var round = true
    private var counter = 0
    private var roundNumber = 0
    private var playerWordIndex = 0
    private var answerSubmitted = false
    var beenChecked = false
    var lastCounterVal = counter
    var test = 0

    internal lateinit var ngButton: Button
    internal lateinit var lettersLayout: ConstraintLayout
    internal lateinit var message: TextView

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
        ngButton = findViewById(R.id.newGame)
        lettersLayout = findViewById(R.id.lettersLayout)
        checkButton = findViewById(R.id.Check)
        message = findViewById(R.id.gameMessage)
        message.isInvisible = true

        lettersLayout.children.forEach { letterView ->
            if(roundNumber < 6) {
                if (letterView is TextView) {
                    letterView.setOnClickListener {
                        round = true
                        if (letterView.text == "Back") {
                            if (playerWord.size < 1) {
                                playerWord = mutableListOf<String>()
                            } else {

                                playerWord.removeLast()
                                counter -= 1
                                playerWordIndex -= 1
                                boardList[counter].text = ""
                                if (counter == 0) {
                                    boardList[counter].text = ""
                                }
                            }
                        } else if (counter % 5 == 0 && (round != true || playerWordIndex != 0)) {
                            playerWord = playerWord

                        } else {
                            playerWord.add(
                                letterView.text.toString().lowercase(Locale.getDefault())
                            )

                            println(playerWord)
                            //Logic for displaying words

                            for (letter in playerWord) {

                                boardList[counter].text = playerWord[playerWordIndex]


                            }
                            playerWordIndex += 1
                            counter += 1
                        }


                    }
                }
            }

        }

        ngButton.setOnClickListener{
            resetGame()
        }

        checkButton.setOnClickListener {
            if (playerWord.size < 5) {
                playerWord = playerWord
            } else {
                test = 0
                lastCounterVal = counter
                roundNumber += 1
                var index = 0


                for (letter in playerWord) {
                    index = 0 + test
                    for (char in wordList) {
                        if (index >= 4) {
                            index = 4
                        }
                        if (letter == wordList[index].toString()) {

                            boardList[counter - 5].setBackgroundColor(
                                getResources().getColor(
                                    green
                                )
                            )
                            beenChecked = true


                            println("letter found")

                        } else if (letter == char.toString()) {

                            boardList[counter - 5].setBackgroundColor(
                                getResources().getColor(
                                    yellow
                                )
                            )


                        } else {

                            println("letter not found")
                        }


                    }

                    test += 1
                    counter += 1
                    beenChecked = false
                }


                if (playerWord.toString() == wordList.toString()) {
                    message.text = "You Won! The word was ${wordToGuess}"
                    message.isInvisible = false
                    println("you win")
                    lettersLayout.isGone = true
                } else if (roundNumber == 6) {
                    lettersLayout.isGone = true
                    message.text = "You Lost! the word was ${wordToGuess}"
                    message.isInvisible = false
                    println("you lose")
                }

                round = false
                playerWordIndex = 0
                playerWord = mutableListOf<String>()

                answerSubmitted = true

                counter = lastCounterVal


            }


            answerSubmitted = false
            Log.d("burh", wordToGuess)
            println(wordList)
        }
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

    private fun resetGame(){
        for(tile in boardList){
            message.isInvisible = true
            tile.text = ""
            tile.setBackgroundColor(getResources().getColor(white))
            wordToGuess = words[Random.nextInt(0, words.size)]
            wordList = wordToGuess.toList()
            lettersLayout.isGone = false
            counter = 0
            roundNumber = 0
            answerSubmitted = false
            beenChecked = false
            test = 0
        }
    }

}







