package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {

    lateinit var extbutton: Button
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var button: Button
    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        extbutton = findViewById(R.id.extbutton)
        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)


        extbutton.setOnClickListener { moveTaskToBack(true)
           android.os.Process.killProcess(android.os.Process.myPid())
           System.exit(1)
           }

            }
        }






