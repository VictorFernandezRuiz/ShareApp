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

class CompartirLista : AppCompatActivity() {


    private lateinit var buttonShareList: Button
    private var txtShareUser: EditText? = null
    private lateinit var buttonAtras: Button

    val user = intent.extras?.getString("name_user")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_lista)

        buttonShareList = findViewById(R.id.buttonShareList)
        txtShareUser = findViewById(R.id.txtShareUser)
        buttonAtras = findViewById(R.id.buttonAtras)




        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {

        buttonShareList.setOnClickListener {


            val userShare = txtShareUser!!.text.toString()
            val user = intent.extras?.getString("name_user")


            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteShareList/" + user + "/" + userShare

            val  myResponse = run(url)

            Toast.makeText(context, "Se ha convertido la lista con" + userShare.toString(), Toast.LENGTH_SHORT).show()


        }
        buttonAtras.setOnClickListener {

            val verLista = Intent(this, VerLista::class.java)
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
