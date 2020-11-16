package com.mouscorp.mousvies.api.service

import com.mouscorp.mousvies.MainActivity
import com.mouscorp.mousvies.api.models.Genre
import com.mouscorp.mousvies.api.models.MovieDetails
import com.mouscorp.mousvies.api.models.SearchDiscoverResponse
import com.mouscorp.mousvies.api.models.SerieDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    companion object{
        val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("search/movie?language=fr-FR")
    fun searchMovie(@Query("api_key") api_key : String, @Query("query") query : String) : Call<SearchDiscoverResponse>

    @GET("search/tv?language=fr-FR")
    fun searchSerie(@Query("api_key") api_key : String, @Query("query") query : String) : Call<SearchDiscoverResponse>

    @GET("discover/movie?language=fr-FR")
    fun discoverMovies(@Query("api_key") api_key : String, @Query("sort_by") sortBy : String) : Call<SearchDiscoverResponse>

    @GET("tv/{tv_id}?language=fr-FR")
    fun serieDetails(@Query("api_key") api_key: String, @Path("tv_id") tv_id : Int) : Call<SerieDetails>

    @GET("movie/{movie_id}?language=fr-FR")
    fun movieDetails(@Query("api_key") api_key: String, @Path("movie_id") movie_id : Int) : Call<MovieDetails>

    @GET("movie/popular?language=fr-FR")
    fun mostPopularMovies(@Query("api_key") api_key: String) : Call<SearchDiscoverResponse>

    @GET("genre/movie/list?language=fr-FR")
    fun allGenres(@Query("api_key") api_key: String) : Call<List<Genre>>

    @GET("discover/movie?language=fr-FR")
    fun genreMovies(@Query("api_key") api_key : String, @Query("with_genres") with_genres : String) : Call<SearchDiscoverResponse>

    /*fun actionMovies() : Call<SearchDiscoverResponse>{
        return genreMovies(MainActivity.SECRET_API_KEY, "28")
    }*/
}