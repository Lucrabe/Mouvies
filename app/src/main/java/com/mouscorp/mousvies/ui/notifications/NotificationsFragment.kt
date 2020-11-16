package com.mouscorp.mousvies.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
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
import com.mouscorp.mousvies.api.adapter.MovieRecyclerViewAdapter
import com.mouscorp.mousvies.api.adapter.MovieSearchRecyclerViewAdapter
import com.mouscorp.mousvies.api.models.Movie
import com.mouscorp.mousvies.api.models.MovieDetails
import com.mouscorp.mousvies.api.models.SearchDiscoverResponse
import com.mouscorp.mousvies.api.service.MovieService
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    lateinit var movieSearchRecyclerView : RecyclerView
    lateinit var movieSearchRecyclerViewAdapter: MovieSearchRecyclerViewAdapter
    lateinit var movieList : ArrayList<Movie>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        var _searchBar : SearchView = root.findViewById(R.id.searchBar)

      /*  val textView: TextView = root.findViewById(R.id.text)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        }) */
        _searchBar.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {

                    val textLastSearch : TextView = root.findViewById(R.id.search_textView)
                    val searchLayout : LinearLayout = root.findViewById(R.id.search_layout)

                    textLastSearch.visibility = View.INVISIBLE
                    searchLayout.visibility = LinearLayout.GONE

                    val retrofit : Retrofit = Retrofit.Builder()
                        .baseUrl(MovieService.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val movieService : MovieService = retrofit.create(MovieService::class.java)

                    val call : Call<SearchDiscoverResponse> = movieService.searchMovie(MainActivity.SECRET_API_KEY, query.toString() )

                    call.enqueue(
                        object : Callback<SearchDiscoverResponse> {
                            override fun onResponse(
                                call: Call<SearchDiscoverResponse>,
                                response: Response<SearchDiscoverResponse>
                            ) {
                                if(!response.isSuccessful){
                                    Toast.makeText(activity!!.applicationContext,response.code(), Toast.LENGTH_SHORT).show()
                                    return;
                                }

                                movieSearchRecyclerView = root.findViewById(R.id.fragment_search_recycler)!!
                                val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                                movieSearchRecyclerView.layoutManager = linearLayoutManager

                                val searchDiscoverResponse : SearchDiscoverResponse? = response.body()
                                checkNotNull(searchDiscoverResponse)
                                movieList = searchDiscoverResponse.results

                                Log.v("searchDiscoverResponse", searchDiscoverResponse.toString())

                                movieSearchRecyclerViewAdapter = MovieSearchRecyclerViewAdapter(
                                    this@NotificationsFragment, movieList
                                )
                                movieSearchRecyclerView.adapter = movieSearchRecyclerViewAdapter
                            }

                            override fun onFailure(call: Call<SearchDiscoverResponse>, t: Throwable) {
                                Toast.makeText(activity!!.applicationContext, t.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    //Log.v("Affichage : " , newText.toString())
                    return false
                }
            }
        )
        return root
    }
}