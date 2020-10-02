package com.cassiolucianodasilva.movielist.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cassiolucianodasilva.data.util.Constants
import com.cassiolucianodasilva.domain.entity.MoviesItem
import com.cassiolucianodasilva.movielist.R
import com.cassiolucianodasilva.movielist.presentation.base.BaseAdapter
import com.cassiolucianodasilva.movielist.presentation.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_favorites, container, false)

    private var listFavoritesMovies = ArrayList<MoviesItem?>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(activity as MainActivity) {
            adapterFavorites =
                BaseAdapter(R.layout.item_movie, listFavoritesMovies) { viewAdapter, item ->
                    viewAdapter.cv_movie_title.text = item?.title
                    viewAdapter.cv_movie_release_date.text = item?.releaseDate
                   // viewAdapter.ib_star.setImageResource(R.drawable.ic_star)
                    Glide.with(this).load(Constants.IMAGE_URL + item?.posterPath)
                        .into(viewAdapter.cv_iv_movie_poster)
                    viewAdapter.setOnClickListener {
                        DetailActivity.startIntent(
                            requireContext(),
                            item
                        )
                    }
                }

            favorites_movies.adapter = adapterFavorites
            favorites_movies.layoutManager = LinearLayoutManager(context)

            moviesViewModel.updateListFavorites.observe(this, Observer {
                sw_layout_favorite.isRefreshing = false
                listFavoritesMovies.clear()
                listFavoritesMovies.addAll(it)
                this@FavoritesFragment.empty_list.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
                favorites_movies?.adapter?.notifyDataSetChanged()
            })
        }

        sw_layout_favorite.setOnRefreshListener {
            (activity as MainActivity).moviesViewModel.fetchMovies()
        }
    }

    companion object {
        fun newInstance() = FavoritesFragment()
    }

}
