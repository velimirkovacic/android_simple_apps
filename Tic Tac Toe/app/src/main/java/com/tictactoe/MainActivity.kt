package com.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view:View) {
        val gumb = view as Button
        var id = 0
        when (gumb.id) {
            button01.id -> id = 1
            button02.id -> id = 2
            button10.id -> id = 3
            button11.id -> id = 4
            button12.id -> id = 5
            button20.id -> id = 6
            button21.id -> id = 7
            button22.id -> id = 8
        }
        //Toast.makeText(this, "(${id / 3}, ${id % 3})", Toast.LENGTH_SHORT).show()

        potez(id, gumb)
        provjera()
    }

    var player:Int = 1
    var polje = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)

    fun potez(id:Int, gumb:Button) {

        if(player == 1) {
            gumb.text = "✕"
            gumb.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.player1, null))
            player = 0
            polje[id] = 1
        } else {
            gumb.text = "◯"
            gumb.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.player2, null))
            player = 1
            polje[id] = 2
        }

        gumb.isEnabled = false
    }


    fun onemogucenje() {
        button00.isEnabled = false
        button01.isEnabled = false
        button02.isEnabled = false
        button10.isEnabled = false
        button11.isEnabled = false
        button12.isEnabled = false
        button20.isEnabled = false
        button21.isEnabled = false
        button22.isEnabled = false
    }

    fun provjera() {
        for(p in 1..2) {
            for(i in 0..2) {
                var sum1 = 0
                var sum2 = 0
                for(j in 0..2) {
                    if(polje[i*3 + j] == p) sum1++
                    if(polje[j*3 + i] == p) sum2++
                }
                if(sum1 == 3 || sum2 == 3) {
                    Toast.makeText(this, "${p} pobjedio", Toast.LENGTH_SHORT).show()
                    onemogucenje()

                }
            }
            var sum3 = 0
            var sum4 = 0
            for(i in 0..2) {
                if(polje[i*3+i] == p) sum3++
                if(polje[i*3 + (2-i)] == p) sum4++
            }
            if(sum3 == 3 || sum4 == 3) {
                Toast.makeText(this, "${p} pobjedio", Toast.LENGTH_SHORT).show()
                onemogucenje()
            }

        }
    }

    fun resetClick(view:View) {
        for(i in 0..8) {
            polje[i] = 0
        }
        player = 1

        button00.text = ""
        button01.text = ""
        button02.text = ""
        button10.text = ""
        button11.text = ""
        button12.text = ""
        button20.text = ""
        button21.text = ""
        button22.text = ""

        button00.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button01.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button02.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button10.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button11.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button12.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button20.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button21.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))
        button22.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.white, null))

        button00.isEnabled = true
        button01.isEnabled = true
        button02.isEnabled = true
        button10.isEnabled = true
        button11.isEnabled = true
        button12.isEnabled = true
        button20.isEnabled = true
        button21.isEnabled = true
        button22.isEnabled = true
    }
}