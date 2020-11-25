package com.A.SehirTanitim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_city_details.*


class SehirDetay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_details)

        var bundle = intent.extras
        imageView2.setImageResource(bundle!!.getInt("image"))
        textView2.text = bundle.getString("name")
        textView3.text = bundle.getString("description")
    }
}