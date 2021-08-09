package com.example.ejemplo_1.api

import com.example.ejemplo_1.model.ResultPersonaje
import retrofit2.Call
import retrofit2.http.GET

interface ApiPersonajeService {

    @GET("character")
    fun getPersonajes() : Call<ResultPersonaje>
}