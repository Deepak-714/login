package com.example.loginapp.API

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.R

class MoviesAdapter(private val results: List<Result>) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcvlayout,parent,false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        return holder.bind(results[position])
    }
}

class MoviesViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.movie_title)
    private val overview:TextView = itemView.findViewById(R.id.movie_overview)
    private val rating : TextView = itemView.findViewById(R.id.movie_rating)
    private val photo: ImageView =itemView.findViewById(R.id.movie_photo)

    fun bind(movie: Result) {
       // Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(photo)
        title.text = "Title: "+movie.original_title
        overview.text = movie.overview
        rating.text = "Rating : "+movie.vote_average
    }


}