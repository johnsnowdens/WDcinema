package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.network.url
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var requestQueue: RequestQueue

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.registrBtn.setOnClickListener {
            val i = Intent(this, RegistrateActivity::class.java)
            startActivity(i)
            finish()
        }
        requestQueue = Volley.newRequestQueue(this)

        binding.btn.setOnClickListener {
            val login = binding.Wdlogin.text.toString()
            val password = binding.WDpass.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Пустые поля", Toast.LENGTH_SHORT).show()
            }

            val request = JsonObjectRequest (
                Request.Method.POST,

                url.LOGIN_URL,

                JSONObject()
                    .put("email", login)
                    .put("password", password),

                Response.Listener<JSONObject> { response ->
                    Toast.makeText(this, "token = ${response["token"]}", Toast.LENGTH_SHORT).show()
                },

                Response.ErrorListener {
                    Toast.makeText(this, "Ошибка. Иди нахер", Toast.LENGTH_SHORT).show()
                    it.printStackTrace()
                }
            )

            requestQueue.add(request)
        }
    }
}