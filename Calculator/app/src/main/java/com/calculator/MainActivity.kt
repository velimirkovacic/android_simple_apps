package com.calculator

import android.media.JetPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ekran.text = ""
    }

    enum class operacija{
        ZBR, ODUZ, MNOZ, DJELJ, POSTO, NISTA
    }

    var broj:Float = 0.0f
    var brojPos:Boolean = false

    var rez:Float = 0.0f
    var rezPos:Boolean = false

    var trOp = operacija.NISTA
    var divz:Boolean = false
    var eq:Boolean = false

    fun onButtonAC(view:View) {
        brojPos = false
        rezPos = false
        ekran.text = ""
    }

    fun onButtonMatOp(view:View) {
        if(brojPos) {
            ekran.text = ""
            val gumb = view as Button

            if(!rezPos) {
                rez = broj
                rezPos = true
                brojPos = false
            } else {
                primjeniOp(view)
            }

            when(gumb.id) {
                bplus.id -> trOp = operacija.ZBR
                bminus.id -> trOp = operacija.ODUZ
                bputa.id -> trOp = operacija.MNOZ
                bdjelj.id -> trOp = operacija.DJELJ
                bposto.id -> trOp = operacija.POSTO
                else -> trOp = operacija.NISTA
            }

        }
    }

    fun divzero(view: View) {
        onButtonAC(view)
        ekran.text = "DIV/0"
        divz = true
    }

    fun primjeniOp(view: View) {
        when(trOp) {
            operacija.POSTO -> rez *= broj / 100.0f
            operacija.DJELJ -> {
                if(broj != 0.0f) {
                    rez /= broj
                } else divzero(view)
            }
            operacija.MNOZ -> rez *= broj
            operacija.ODUZ -> rez -= broj
            operacija.ZBR -> rez += broj
        }

        trOp = operacija.NISTA
    }

    fun onButtonEq(view:View) {
        if(rezPos && brojPos) {
            eq = true
            brojPos = false
            primjeniOp(view)
            if(!divz) ekran.text = rez.toString()
        }
    }


    fun onButtonNum(view:View) {
        val gumb = view as Button

        if(divz) {
            divz = false
            ekran.text = ""
        }

        var ekrbr:String = ekran.text.toString()

        if(gumb.id == bplusminus.id && (brojPos || eq)) {
            if (ekrbr[0] == '-') ekrbr = ekrbr.substring(1)
            else ekrbr = "-$ekrbr"
        } else if(eq) {
            rezPos = false

        }
        eq = false


        if(ekrbr.length < 8) {
            when (gumb.id) {
                b0.id -> {
                    if (ekrbr != "0") ekrbr += "0"
                }
                b1.id -> ekrbr += "1"
                b2.id -> ekrbr += "2"
                b3.id -> ekrbr += "3"
                b4.id -> ekrbr += "4"
                b5.id -> ekrbr += "5"
                b6.id -> ekrbr += "6"
                b7.id -> ekrbr += "7"
                b8.id -> ekrbr += "8"
                b9.id -> ekrbr += "9"
                btocka.id -> {
                    if(!ekrbr.contains('.')) ekrbr += '.'
                }
            }

        }


        ekran.text = ekrbr
        if(ekrbr.isNotEmpty()) {
            broj = ekrbr.toFloat()
            brojPos = true
        }
    }
}