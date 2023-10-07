package com.mojadob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun button2Event(view: View) {
        try {
            val godinaRodenja = unosDobi.text.toString().toInt()
            val starost = Calendar.getInstance().get(Calendar.YEAR) - godinaRodenja
            textDob.text = starost.toString()
        } catch (ex:Exception) {}
    }
}