package com.mouscorp.mouvies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mouvies.api.models.Movie
import com.mouscorp.mouvies.api.adapter.MovieRecyclerViewAdapter
import com.mouscorp.mouvies.api.service.MovieService
import com.mouscorp.mouvies.api.models.SearchDiscoverResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var movieSearchDiscoverRecyclerView : RecyclerView
    lateinit var movieRecyclerViewAdapter : MovieRecyclerViewAdapter
    lateinit var movieList : ArrayList<Movie>

    companion object {
        const val SECRET_API_KEY = "c4e28b5de3a34ac158059130ce07705d"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieService : MovieService = retrofit.create(MovieService::class.java)
        val call : Call<SearchDiscoverResponse> = movieService.mostPopularMovies(SECRET_API_KEY)

        movieSearchDiscoverRecyclerView = findViewById(R.id.activity_main_recycler)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        movieSearchDiscoverRecyclerView.layoutManager = linearLayoutManager

        call.enqueue(
            object : Callback<SearchDiscoverResponse>{
                override fun onResponse(
                    call: Call<SearchDiscoverResponse>,
                    response: Response<SearchDiscoverResponse>
                ) {
                    if(!response.isSuccessful){
                        Toast.makeText(applicationContext,response.code(),Toast.LENGTH_SHORT).show()
                        return;
                    }

                    val searchDiscoverResponse : SearchDiscoverResponse? = response.body()
                    checkNotNull(searchDiscoverResponse)
                    movieList = searchDiscoverResponse.results

                    Log.v("searchDiscoverResponse", searchDiscoverResponse.toString())

                    movieRecyclerViewAdapter = MovieRecyclerViewAdapter(
                        this@MainActivity, movieList
                    )
                    movieSearchDiscoverRecyclerView.adapter = movieRecyclerViewAdapter
                }

                override fun onFailure(call: Call<SearchDiscoverResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}