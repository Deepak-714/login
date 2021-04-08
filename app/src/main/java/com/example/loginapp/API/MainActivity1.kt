package com.example.loginapp.API

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity1:AppCompatActivity() {
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rcv)

        val request = ServiceBuilder.buildService(EndPoint::class.java)
        val call = request.getMovies(getString(R.string.api_key))
        val rcv=findViewById<RecyclerView>(R.id.rcv)
        val progress_bar=findViewById<ProgressBar>(R.id.progressBar2)

        call.enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                Toast.makeText(this@MainActivity1,"In a RESPONSE",LENGTH_LONG).show()
                if (response.isSuccessful){

                    // Toast.makeText(this@MainActivity,"In a RESPONSE",LENGTH_LONG).show()

                    progress_bar.visibility = View.GONE
                    rcv.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity1)
                        adapter = MoviesAdapter(response.body()!!.results)
                    }
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(this@MainActivity1, "${t.message}", Toast.LENGTH_SHORT).show()

            }
        })
    }
}