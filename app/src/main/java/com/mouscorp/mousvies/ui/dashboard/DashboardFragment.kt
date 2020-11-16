package com.mouscorp.mousvies.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mouscorp.mousvies.MainActivity
import com.mouscorp.mousvies.R
import com.mouscorp.mousvies.api.adapter.MovieRecyclerViewAdapter
import com.mouscorp.mousvies.api.models.Movie
import com.mouscorp.mousvies.api.models.SearchDiscoverResponse
import com.mouscorp.mousvies.api.service.MovieService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
import retrofit2.Response

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var movieSearchDiscoverRecyclerView : RecyclerView
    lateinit var movieRecyclerViewAdapter : MovieRecyclerViewAdapter
    lateinit var movieList : ArrayList<Movie>
    lateinit var movieSearchDiscoverRecyclerView2 : RecyclerView
    lateinit var movieRecyclerViewAdapter2 : MovieRecyclerViewAdapter
    lateinit var movieList2 : ArrayList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_genre, container, false)

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl(MovieService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieService : MovieService = retrofit.create(MovieService::class.java)
        val call : Call<SearchDiscoverResponse> = movieService.genreMovies(MainActivity.SECRET_API_KEY, "28")
        val call2 : Call<SearchDiscoverResponse> = movieService.genreMovies(MainActivity.SECRET_API_KEY, "18")
        val call3 : Call<SearchDiscoverResponse> = movieService.genreMovies(MainActivity.SECRET_API_KEY, "14")

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

                    movieSearchDiscoverRecyclerView = root.findViewById(R.id.activity_main_recycler)!!
                    val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    movieSearchDiscoverRecyclerView.layoutManager = linearLayoutManager

                    val searchDiscoverResponse : SearchDiscoverResponse? = response.body()
                    checkNotNull(searchDiscoverResponse)
                    movieList = searchDiscoverResponse.results

                    Log.v("searchDiscoverResponse", searchDiscoverResponse.toString())

                    movieRecyclerViewAdapter = MovieRecyclerViewAdapter(
                        this@DashboardFragment, movieList
                    )
                    movieSearchDiscoverRecyclerView.adapter = movieRecyclerViewAdapter
                }

                override fun onFailure(call: Call<SearchDiscoverResponse>, t: Throwable) {
                    Toast.makeText(activity!!.applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )

        call2.enqueue(
            object : Callback<SearchDiscoverResponse>{
                override fun onResponse(
                    call: Call<SearchDiscoverResponse>,
                    response: Response<SearchDiscoverResponse>
                ) {
                    if(!response.isSuccessful){
                        Toast.makeText(activity!!.applicationContext,response.code(),Toast.LENGTH_SHORT).show()
                        return;
                    }

                    movieSearchDiscoverRecyclerView2 = root.findViewById(R.id.activity_main_recycler_2)!!
                    val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    movieSearchDiscoverRecyclerView2.layoutManager = linearLayoutManager

                    val searchDiscoverResponse2 : SearchDiscoverResponse? = response.body()
                    checkNotNull(searchDiscoverResponse2)
                    movieList2 = searchDiscoverResponse2.results

                    Log.v("searchDiscoverResponse", searchDiscoverResponse2.toString())

                    movieRecyclerViewAdapter2 = MovieRecyclerViewAdapter(
                        this@DashboardFragment, movieList2
                    )
                    movieSearchDiscoverRecyclerView2.adapter = movieRecyclerViewAdapter2
                }

                override fun onFailure(call: Call<SearchDiscoverResponse>, t: Throwable) {
                    Toast.makeText(activity!!.applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )

        /*  val textView: TextView = root.findViewById(R.id.text_dashboard)
          dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
              textView.text = it
          }) */
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}