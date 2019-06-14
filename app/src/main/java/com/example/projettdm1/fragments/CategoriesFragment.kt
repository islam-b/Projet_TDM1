package com.example.projettdm1.fragments

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projettdm1.DataSource
import com.example.projettdm1.adapters.CategoriesListAdapter
import com.example.projettdm1.R
import com.example.projettdm1.adapters.GridItemDecoration
import com.example.projettdm1.models.Categorie


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CategoriesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CategoriesFragment : Fragment() {



    // TODO: Rename and change types of parameters

    private var listener: CategoriesListAdapter.OnCategoryClickListener? = null

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
        var view = inflater.inflate(R.layout.fragment_categories, container, false)
        initCategories(view)
        return view
    }

    fun initCategories(view: View) {
        var recylclerview = view.findViewById<RecyclerView>(R.id.categories_grid)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        context?.let {
            recylclerview.addItemDecoration(GridItemDecoration(spacingInPixels, it))

            if (it.resources.configuration.screenLayout.and(Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE) {
                if (it.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    recylclerview.layoutManager = GridLayoutManager(it, 5)
                } else recylclerview.layoutManager = GridLayoutManager(it, 4)
            } else {
                if (it.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    recylclerview.layoutManager = GridLayoutManager(it, 4)
                } else recylclerview.layoutManager = GridLayoutManager(it, 2)
            }
        }

        listener?.let {
            val adapter = CategoriesListAdapter(DataSource.getCategories(),it)
            recylclerview.adapter = adapter
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    /*fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CategoriesListAdapter.OnCategoryClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " CategoriesListAdapter.OnCategoryClickListener")
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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CategoriesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
