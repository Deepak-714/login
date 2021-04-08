package com.example.loginapp.API

import retrofit.http.GET
import retrofit.http.Query

interface EndPoint {
    @GET("/3/movie/popular")
    fun getMovies(@Query("api_key") key: String): retrofit2.Call<PopularMovies>

}