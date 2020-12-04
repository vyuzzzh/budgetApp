package com.vyuzzzh.budgetapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {
    private var fragmentClick: MoviesDetailsClick? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movies_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.back_button)?.setOnClickListener {
            fragmentClick?.backToMoviesList()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MoviesDetailsClick) {
            fragmentClick = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClick = null
    }

    companion object {
        fun newInstance(): FragmentMoviesDetails {
            return FragmentMoviesDetails()
        }
    }

    interface MoviesDetailsClick {
        fun backToMoviesList()
    }
}