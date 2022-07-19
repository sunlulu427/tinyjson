package com.tomato.tinyjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tomato.tinyjson.annotations.Serialized

class MainActivity : AppCompatActivity() {


    @Serialized("Hello world")
    val a = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}