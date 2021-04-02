package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.myapplication.databinding.ActivityRegistrateBinding
import com.example.myapplication.network.url
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.lang.Exception

class RegistrateActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistrateBinding
    lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestQueue = Volley.newRequestQueue(this)

        binding.registrBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val lastName = binding.lastEt.text.toString()
            val email = binding.emailEt.text.toString()
            val password = binding.passEt.text.toString()
            val repit_pass = binding.repitPassEt.toString()

            if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || repit_pass.isEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Не правильный Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener }

            val requestJson = JSONObject()
                .put ("firstName",name)
                .put ("lastName",lastName)
                .put ("email",email)
                .put ("password",password)

            val request = JsonObjectRequest(
                Request.Method.POST,
                url.REGISTER_URL,
                requestJson,

                { response ->
                    Toast.makeText(this, "token -${response["token"]}", Toast.LENGTH_SHORT).show()
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    error.printStackTrace()
                }
            )

            requestQueue.add(request)
        }

        binding.backTologin.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)

            finish()
        }



    }
}


