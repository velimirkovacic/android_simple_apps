package com.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var animallist = ArrayList<Animal>()
    var adapter:AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        animallist.add(Animal("Babon", "Live in forest", R.drawable.baboon))
        animallist.add(Animal("Bulldog", "Angery", R.drawable.bulldog, true))
        animallist.add(Animal("Panda", "S kineskim karakteristikama", R.drawable.panda))
        animallist.add(Animal("Zebra", "Madagascar 2", R.drawable.zebra))
        animallist.add(Animal("Bijeli-tigar", "Opasan", R.drawable.white_tiger, true))


        adapter = AnimalsAdapter(this, animallist)
        list.adapter = adapter

    }

    fun delete(position: Int) {
        animallist.removeAt(position)
        adapter!!.notifyDataSetChanged()
    }

    fun add(position: Int) {
        animallist.add(animallist[position])
        delete(position)
    }

    inner class AnimalsAdapter:BaseAdapter {

        var listanimal = ArrayList<Animal>()
        var context:Context? = null

        constructor(context: Context, lista:ArrayList<Animal>):super() {
            this.listanimal = lista
            this.context = context
        }


        override fun getCount(): Int {
            return listanimal.size
        }

        override fun getItem(position: Int): Any {
            return listanimal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listanimal[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflator.inflate(R.layout.animal_ticket, null)
            if(animal.ubica) {
                view = inflator.inflate(R.layout.animal_ubica_ticket, null)
            }
            view.desc.text = animal.desc
            view.nameinfo.text = animal.name
            view.profil.setImageResource(animal.profil!!)
            view.profil.setOnClickListener {
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("ime", animal.name)
                intent.putExtra("opis", animal.desc)
                intent.putExtra("image", animal.profil)
                context!!.startActivity(intent)
                add(position)
            }


            return view
            }
        }

    }
