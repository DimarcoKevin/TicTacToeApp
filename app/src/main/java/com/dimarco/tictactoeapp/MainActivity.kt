package com.dimarco.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.dimarco.tictactoeapp.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellId = 0

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

    var activePlayer = 0

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()


    fun playGame(cellId: Int, buttonSelected: Button) {

        if (activePlayer == 0) {
            buttonSelected.text = "O"
            buttonSelected.setBackgroundResource(R.color.Blue)
            activePlayer = 1
        } else {
            buttonSelected.text = "X"
            buttonSelected.setBackgroundResource(R.color.Red)
            activePlayer = 0
        }
    }
}
