package edu.uw.viewpager

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import edu.uw.viewpager.SearchFragment

class MainActivity : AppCompatActivity(), MovieListFragment.OnMovieSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //respond to search button clicking
    fun handleSearchClick(v: View) {
        val search = SearchFragment.newInstance()

        val fragment = MovieListFragment.newInstance()

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment, MOVIE_LIST_FRAGMENT_TAG)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onMovieSelected(movie: Movie) {
        val fragment = DetailFragment.newInstance(movie)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment, MOVIE_DETAIL_FRAGMENT_TAG)
        ft.addToBackStack(null) //remember for the back button
        ft.commit()
    }

    companion object {

        private val TAG = "MainActivity"
        val MOVIE_LIST_FRAGMENT_TAG = "MoviesListFragment"
        val MOVIE_DETAIL_FRAGMENT_TAG = "DetailFragment"
    }
}
