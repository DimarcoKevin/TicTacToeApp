package com.dimarco.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TableRow
import androidx.core.view.isVisible
import com.dimarco.tictactoeapp.R.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val winningCombinations: Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(3, 6, 9),
        intArrayOf(1, 5, 9),
        intArrayOf(3, 5, 7)
    )

    // initializing variable to tell whose turn it is and variable to count number of turns
    private var activePlayer = 0
    private var counter = 0

    // initalizing arraylists for chosen buttons
    private var player0 = ArrayList<Int>()
    private var player1 = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }

    fun restart(view: View) {
        // setting player 0 as starting player and resetting counter
        activePlayer = 0
        counter = 0

        // clearing the tiles owned by each player
        player0.clear()
        player1.clear()

        // hiding the reset button
        resetButton.visibility = View.INVISIBLE
        resetButton.isEnabled = false

        // hiding the winning notice
        label.text = ""

        // clearing all choices from previous game
        button1.text = ""
        button1.isEnabled = true
        button1.setBackgroundResource(R.color.tile)
        button2.text = ""
        button2.isEnabled = true
        button2.setBackgroundResource(R.color.tile)
        button3.text = ""
        button3.isEnabled = true
        button3.setBackgroundResource(R.color.tile)
        button4.text = ""
        button4.isEnabled = true
        button4.setBackgroundResource(R.color.tile)
        button5.text = ""
        button5.isEnabled = true
        button5.setBackgroundResource(R.color.tile)
        button6.text = ""
        button6.isEnabled = true
        button6.setBackgroundResource(R.color.tile)
        button7.text = ""
        button7.isEnabled = true
        button7.setBackgroundResource(R.color.tile)
        button8.text = ""
        button8.isEnabled = true
        button8.setBackgroundResource(R.color.tile)
        button9.text = ""
        button9.isEnabled = true
        button9.setBackgroundResource(R.color.tile)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellId = 0

        // finding which button was selected
        when (buttonSelected.id) {
            id.button1 -> cellId = 1
            id.button2 -> cellId = 2
            id.button3 -> cellId = 3
            id.button4 -> cellId = 4
            id.button5 -> cellId = 5
            id.button6 -> cellId = 6
            id.button7 -> cellId = 7
            id.button8 -> cellId = 8
            id.button9 -> cellId = 9
        }
        // Log.d("cellId:", cellId.toString())
        playGame(cellId, buttonSelected)
    }

    private fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 0) {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.Blue)
            player0.add(cellId)
            if (checkWinner(player0, activePlayer) == 0) {
                gameOver('O')
                showResetButton()
            } else {
                activePlayer = 1
                counter ++
            }

        } else {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.Red)
            player1.add(cellId)
            if (checkWinner(player1, activePlayer) == 1) {
                gameOver('X')
                showResetButton()
            } else {
                activePlayer = 0
                counter ++
            }
        }

        if (counter == 9) {
            label.text = "It's a draw!"
            showResetButton()
        }

        buttonSelected.isEnabled = false
    }

    private fun checkWinner(selected: ArrayList<Int>, player: Int): Int{
        for (combo in winningCombinations) {
            if (selected.contains(combo[0]) && selected.contains(combo[1]) && selected.contains(combo[2])) {
                return player
            }
        }
        return -1
    }

    private fun gameOver(player: Char) {
        label.text = "You win! Congrats player: $player"
    }

    private fun showResetButton() {
        resetButton.visibility = View.VISIBLE
        resetButton.isEnabled = true
        resetButton.text = "RESET"
    }
}
