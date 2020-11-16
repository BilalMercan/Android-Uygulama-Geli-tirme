package com.a.loginapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class MainActivity : AppCompatActivity() {


    lateinit var kayitad: EditText
    lateinit var kayitsoyad: EditText
    lateinit var kayityas: EditText
    lateinit var kayiteposta: EditText
    lateinit var kayitsifre: EditText
    lateinit var kayitsifretekrar: EditText
    lateinit var button2:Button

    var mina:Int = 17
    var maxa:Int = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        kayitad = findViewById(R.id.kayitad)
        kayitsoyad = findViewById(R.id.kayitsoyad)
        kayityas = findViewById(R.id.kayityas)
        kayiteposta = findViewById(R.id.kayiteposta)
        kayitsifre = findViewById(R.id.kayitsifre)
        kayitsifretekrar = findViewById(R.id.kayitsifretekrar)
        button2 = findViewById(R.id.button2)


        button2.setOnClickListener {
            control()
            bilgiteyit()
        }


    }

    fun control() {

        if ( kayitsoyad.text.toString() == "" && kayitad.text.toString() == "" && kayiteposta.text.toString() == "" && kayityas.text.toString() == "" && kayitsifretekrar.text.toString() == "" && kayitsifre.text.toString() == "" ){

            showToast("Bilgilerinizin tamamını eksiksiz olarak giriniz.")
        }


    }



    private fun emailcontrol(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun bilgiteyit(): Boolean {
        if (kayitad.text.toString() == "") {
            kayitad.error = "Lütfen Adınızı giriniz"
            return false
        }

        if (kayitad.length() <2) {
            kayitad.error = "Lütfen Adınızı tam giriniz."
            return false
        }

        if (kayitsoyad.text.toString() == "") {
            kayitsoyad.error = "Lütfen Soyadınızı giriniz."
            return false
        }

        if (kayitsoyad.length()<2) {
            kayitsoyad.error = "Lütfen Soyadınızı tam giriniz."
            return false
        }

        if (kayiteposta.text.toString() == "") {
            kayiteposta.error = "Lütfen email adresinizi giriniz."
            return false
        }
        if (kayitsifre.text.toString() == "") {
            kayitsifre.error = "Lütfen şifrenizi giriniz."
            return false
        }

        if (kayityas.text.toString() == "")
        {
            kayityas.error = "Lütfen yaşınızı giriniz."
            return false
        }


        if (kayityas.text.toString()  == mina.toString() )
        {
            kayityas.error = "Lütfen yaşınızı gerçek giriniz."
            return false
        }


        if (kayityas.text.toString()  == maxa.toString())
        {
            kayityas.error = "Lütfen yaşınızı doğru giriniz."
            return false
        }


        if (kayitsifre.length() <5) {
            kayitsifre.error = "Lütfen daha uzun karakterli şifre giriniz"
            return false
        }

        if (kayitsifre.text.toString() == "") {
            kayitsifre.error = "Şifrenizi giriniz."
            return false
        }

        if (kayitsifretekrar.text.toString() == "") {
            kayitsifretekrar.error = "Şifrenizi tekrar giriniz."
            return false
        }

        if (emailcontrol(kayiteposta.text.toString())) {
            kayiteposta.error = "Geçerli email adresi giriniz."
            return false
        }

        if (kayitsifre.text.toString() != kayitsifretekrar.text.toString()) {
            kayitsifretekrar.error = "Şifreler uyuşmuyor."
            return false
        }
        return true
    }


    fun Context.showToast (text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, duration).show()
    }
}



