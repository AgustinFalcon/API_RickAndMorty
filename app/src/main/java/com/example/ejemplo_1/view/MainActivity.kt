package com.example.ejemplo_1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplo_1.adapter.PersonajeAdapter
import com.example.ejemplo_1.api.ApiPersonajeService
import com.example.ejemplo_1.databinding.ActivityMainBinding
import com.example.ejemplo_1.model.ResultPersonaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){

    private lateinit var binding : ActivityMainBinding
    private lateinit var apiService: ApiPersonajeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.rvPersonaje.layoutManager = LinearLayoutManager(this)
        apiService = retrofit.create<ApiPersonajeService>(ApiPersonajeService::class.java)
        obtenerPersonajes()
    }

    private fun obtenerPersonajes() {
        apiService.getPersonajes().enqueue(object: Callback<ResultPersonaje>{

            override fun onResponse(
                call: Call<ResultPersonaje>,
                response: Response<ResultPersonaje>
            ) {
                val listaPersonajes = response.body()!!.results
                binding.rvPersonaje.adapter = PersonajeAdapter(listaPersonajes)
            }

            override fun onFailure(call: Call<ResultPersonaje>, t: Throwable) {
                //Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()
            }

        })
    }

}