package com.mouscorp.mousvies.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.MainActivity
import com.mouscorp.mousvies.R
import com.mouscorp.mousvies.api.adapter.MovieDetailsRecyclerViewAdapter
import com.mouscorp.mousvies.api.adapter.MoviePopularRecyclerViewAdapter
import com.mouscorp.mousvies.api.adapter.MovieRecyclerViewAdapter
import com.mouscorp.mousvies.api.models.Movie
import com.mouscorp.mousvies.api.models.MovieDetails
import com.mouscorp.mousvies.api.models.SearchDiscoverResponse
import com.mouscorp.mousvies.api.service.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    lateinit var moviePopularRecyclerView : RecyclerView
    lateinit var moviePopularRecyclerViewAdapter : MoviePopularRecyclerViewAdapter
    lateinit var movieList : ArrayList<Movie>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/


        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieService : MovieService = retrofit.create(MovieService::class.java)
        val call : Call<SearchDiscoverResponse> = movieService.mostPopularMovies(MainActivity.SECRET_API_KEY)

        call.enqueue(
            object : Callback<SearchDiscoverResponse>{
                override fun onResponse(
                    call: Call<SearchDiscoverResponse>,
                    response: Response<SearchDiscoverResponse>
                ) {
                    if(!response.isSuccessful){
                        Toast.makeText(activity!!.applicationContext,response.code(),Toast.LENGTH_SHORT).show()
                        return;
                    }

                    moviePopularRecyclerView = root.findViewById(R.id.fragment_home_recycler)!!
                    val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    moviePopularRecyclerView.layoutManager = linearLayoutManager

                    val searchDiscoverResponse : SearchDiscoverResponse? = response.body()
                    checkNotNull(searchDiscoverResponse)
                    movieList = searchDiscoverResponse.results

                    Log.v("searchDiscoverResponse", searchDiscoverResponse.toString())

                    moviePopularRecyclerViewAdapter = MoviePopularRecyclerViewAdapter(
                        this@HomeFragment, movieList
                    )
                    moviePopularRecyclerView.adapter = moviePopularRecyclerViewAdapter
                }

                override fun onFailure(call: Call<SearchDiscoverResponse>, t: Throwable) {
                    Toast.makeText(activity!!.applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )


        return root
    }
}