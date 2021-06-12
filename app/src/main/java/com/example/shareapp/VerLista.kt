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
    private var txtInsertProduct: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_lista)
        buttonInsertProduct = findViewById(R.id.buttonInsertProduct)
        buttonDeleteProduct = findViewById(R.id.buttonDeleteProduct)
        buttonShare = findViewById(R.id.buttonShare)
        txtInsertProduct = findViewById(R.id.txtInsertProduct)


        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {

        buttonInsertProduct.setOnClickListener {


            val product = txtInsertProduct!!.text.toString()
            val user = intent.extras?.getString("name_user")


            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteInsertProduct/" + product + "/" + user

            val  myResponse = run(url)

            Toast.makeText(context, myResponse.toString(), Toast.LENGTH_SHORT).show()

            val verLista = Intent(this, VerLista::class.java)
            startActivity(verLista)
        }

        buttonDeleteProduct.setOnClickListener {


            val product = txtInsertProduct!!.text.toString()
            val user = intent.extras?.getString("name_user")


            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteDeleteProduct/" + product + "/" + user

            val  myResponse = run(url)

            Toast.makeText(context, myResponse.toString(), Toast.LENGTH_SHORT).show()

            val verLista = Intent(this, VerLista::class.java)
            startActivity(verLista)
        }

        buttonShare.setOnClickListener {




            val verCompartirLista = Intent(this, CompartirLista::class.java)
            startActivity(verCompartirLista)
        }




    }

    val client = OkHttpClient()

    fun run(url: String)  {

        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.string())


            }
        })

    }






    }

