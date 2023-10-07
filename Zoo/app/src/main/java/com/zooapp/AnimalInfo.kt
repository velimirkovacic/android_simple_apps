package com.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle:Bundle = intent.extras!!
        val name = bundle.getString("ime")
        val desc = bundle.getString("opis")
        val profil = bundle.getInt("image")
        profilinfo.setImageResource(profil)
        nameinfo.text = name
        descinfo.text = desc
    }
}