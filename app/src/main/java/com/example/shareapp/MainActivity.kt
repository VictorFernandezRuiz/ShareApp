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
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {

    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button
    private var inputUser: EditText? = null
    private var inputPassword: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)

        inputUser =  findViewById(R.id.txtUserName)
        inputPassword =  findViewById(R.id.editTextPassword)

        setOnClickListeners(this)
    }

    private fun setOnClickListeners(context: Context) {
        buttonLogin.setOnClickListener {

          //  val loginEndpoint = URL("http://localhost:8080/apiz-0.0.1-SNAPSHOT/ExecuteLogin/victor/ilerna")
          //  setOnClickListeners(this)
          //  val myConnection: HttpURLConnection = loginEndpoint.openConnection() as HttpURLConnection
          //  if (myConnection.getResponseCode() == 200) {
          //      Toast.makeText(context, "Login'...", Toast.LENGTH_SHORT).show()
          //  } else {
          //      Toast.makeText(context, "ERROR'...", Toast.LENGTH_SHORT).show()

            val user = inputUser!!.text.toString()

            val password = inputPassword!!.text.toString()

            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteLogin/" + user + "/" + password

            val  myResponse = run(url)

            Toast.makeText(context, myResponse.toString(), Toast.LENGTH_SHORT).show()

            val verLista = Intent(this, VerLista::class.java)
            verLista.putExtra("name_user", user)
            startActivity(verLista)
            }

        buttonRegister.setOnClickListener {
            val connection: HttpURLConnection? = null


            val user = inputUser!!.text.toString()
            val password = inputPassword!!.text.toString()
            val url = "http://10.0.2.2:8080/apiz-0.0.1-SNAPSHOT/ExecuteInsertUser/" + user + "/" + password

            val  myResponse = run(url)

            Toast.makeText(context, myResponse.toString(), Toast.LENGTH_SHORT).show()


            val verLista = Intent(this, VerLista::class.java)
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