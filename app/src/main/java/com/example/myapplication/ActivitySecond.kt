package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {
    val str = mutableListOf(DataStrings("Texyyyy","TextTEST","TextTEST","TextTEST"))
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recTV:RecyclerView = findViewById(R.id.recTV)



        recTV.layoutManager = LinearLayoutManager(this)
        recTV.adapter = Adapter(str)
    }
}