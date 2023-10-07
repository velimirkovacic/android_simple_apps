package com.zooapp

import java.lang.NullPointerException

class Animal {
    var name:String? = null
    var desc:String? = null
    var profil:Int? = null
    var ubica:Boolean = false

    constructor(ime:String, opis:String, slika:Int, ) {
        this.name = ime
        this.desc = opis
        this.profil = slika
    }
    constructor(ime:String, opis:String, slika:Int, ubica:Boolean) {
        this.name = ime
        this.desc = opis
        this.profil = slika
        this.ubica = ubica
    }
}