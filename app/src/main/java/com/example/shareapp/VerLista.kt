package com.example.shareapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class VerLista : AppCompatActivity() {


    private lateinit var  buttonInsertProduct: Button
    private lateinit var buttonDeleteProduct: Button
    private lateinit var buttonShare: Button
    private var inputUser: EditText? = null
    private var inputPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_lista)



        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {

    }







    }

