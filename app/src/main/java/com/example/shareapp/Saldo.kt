package com.example.shareapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException

class Saldo : AppCompatActivity() {


    private var editSaldo: EditText? = null
    private lateinit var buttonAddSaldo: Button
    private lateinit var buttonAtras: Button
    private var textSALDO: TextView? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_saldo)

        buttonAtras = findViewById(R.id.buttonAtras)
        buttonAddSaldo = findViewById(R.id.buttonAddSaldo)
        editSaldo = findViewById(R.id.editSaldo)
        textSALDO = findViewById(R.id.textSALDO)



        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {

        buttonAddSaldo.setOnClickListener {


            val saldo = editSaldo!!.text.toString()
            var user = intent.getStringExtra("name_user")


            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteUpdateAmount/" + saldo + "/" + user

            val  myResponse = run(url)

            Toast.makeText(context, myResponse.toString(), Toast.LENGTH_SHORT).show()

        }

        buttonAtras.setOnClickListener {

            val verLista = Intent(this, VerLista::class.java)
            var user = intent.getStringExtra("name_user")
            verLista.putExtra("name_user", user)
            startActivity(verLista)

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