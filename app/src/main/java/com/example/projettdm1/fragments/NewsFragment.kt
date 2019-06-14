package com.example.projettdm1.fragments

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.projettdm1.DataSource
import com.example.projettdm1.R
import com.example.projettdm1.adapters.*
import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var listener: NewsListAdapter.OnNewsClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_news, container, false)
        initNews(view)
        return view
    }

    override fun onResume() {
        var recylclerview = activity?.findViewById<RecyclerView>(R.id.news_list)
        val l=listener
        l?.let {
            val adapter = NewsListAdapter(DataSource.getNews(),l)
            recylclerview?.adapter = adapter
        }
        super.onResume()
    }

    fun initNews(view: View) {
        var recylclerview = view.findViewById<RecyclerView>(R.id.news_list)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        context?.let {


            if (it.resources.configuration.screenLayout.and(Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {

                recylclerview.addItemDecoration(NewsItemLargeScreenDecoration(spacingInPixels, it))
                if (it.resources.configuration?.orientation== Configuration.ORIENTATION_LANDSCAPE) {
                    recylclerview.layoutManager = GridLayoutManager(context, 3)
                } else recylclerview.layoutManager = GridLayoutManager(context, 2)


            } else {
                recylclerview.addItemDecoration(LinearItemDecoration(spacingInPixels))
                recylclerview.layoutManager =
                    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            }

            val l = listener
            l?.let {
                val adapter = NewsListAdapter(DataSource.getNews(), l)
                recylclerview.adapter = adapter
            }
        }

    }

    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NewsListAdapter.OnNewsClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
   /* interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NewsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
