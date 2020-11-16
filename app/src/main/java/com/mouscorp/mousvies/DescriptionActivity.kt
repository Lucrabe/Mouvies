package com.mouscorp.mousvies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.api.adapter.MovieDetailsAdapter
import com.mouscorp.mousvies.api.models.MovieDetails
import com.mouscorp.mousvies.api.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DescriptionActivity : AppCompatActivity() {

    lateinit var movieDetailsRecyclerView : RecyclerView
    lateinit var movieDetailsRecyclerViewAdapter : MovieDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details)

        val intent : Intent = getIntent()
        val id:Int = intent.getIntExtra("MovieId", 1)


        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieService : MovieService = retrofit.create(MovieService::class.java)

        val call : Call<MovieDetails> = movieService.movieDetails(id, MainActivity.SECRET_API_KEY)

        call.enqueue(
            object : Callback<MovieDetails> {
                override fun onResponse(
                    call: Call<MovieDetails>,
                    response: Response<MovieDetails>
                ) {
                    if(!response.isSuccessful){
                        Toast.makeText(applicationContext,response.code(), Toast.LENGTH_SHORT).show()
                        return;
                    }

                    movieDetailsRecyclerView = findViewById(R.id.fragment_details_recycler)!!
                    val linearLayoutManager = LinearLayoutManager(this@DescriptionActivity, LinearLayoutManager.VERTICAL, false)
                    movieDetailsRecyclerView.layoutManager = linearLayoutManager

                    val movieDetails : MovieDetails? = response.body()
                    checkNotNull(movieDetails)

                    Log.v("searchDiscoverResponse", movieDetails.toString())

                    movieDetailsRecyclerViewAdapter = MovieDetailsAdapter(
                        this@DescriptionActivity, movieDetails
                    )
                    movieDetailsRecyclerView.adapter = movieDetailsRecyclerViewAdapter
                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )

    }

}