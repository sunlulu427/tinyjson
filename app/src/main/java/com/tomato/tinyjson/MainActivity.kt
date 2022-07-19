package com.tomato.tinyjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tomato.tinyjson.annotations.Description
import com.tomato.tinyjson.annotations.Serialized

class MainActivity : AppCompatActivity() {


    @Description("this is a test field", watchers = ["sunlulu.tomato"])
    @Serialized("Hello world")
    val a = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}