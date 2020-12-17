package com.a.androidkamera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {
    val REQUESTCODE_CAMERA = 1
    var imageArray=ArrayList<ByteArray>()
    private var adapter: GridViewAdapter? = null
    lateinit var Kamera: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Kamera = findViewById(R.id.Kamerabuton)

        Kamerabuton.setOnClickListener {
            if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                val permission = arrayOf(
                    android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
                requestPermissions(permission, REQUESTCODE_CAMERA)
            } else
                takePhotoFromCamera()
        }

    }

    private fun takePhotoFromCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUESTCODE_CAMERA)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUESTCODE_CAMERA)
        {
            val imageBitmap = intent?.extras!!.get("data") as Bitmap
            val bytes = ByteArrayOutputStream()
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
            imageArray.add(bytes.toByteArray())
            bytes.close()
        }

        adapter = GridViewAdapter(this, imageArray)
        GridView.adapter = adapter
    }

}
