package com.example.peopleinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayData()
    }
    fun displayData(){
        var peopleD = ArrayList<People>()
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p1))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p2))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p3))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p4))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p5))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p6))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p7))
        peopleD.add(People("Emerald Rose" , "I am studying towards application development with Kotlin." , "00988899" , R.drawable.p8))


        var adapter = PeopleAdapter(peopleD , this@MainActivity)
        var persons = findViewById<RecyclerView>(R.id.people_recyclerView)
        persons.layoutManager = GridLayoutManager(this@MainActivity , 2)
        persons.adapter = adapter
    }
}