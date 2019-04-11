package com.example.projettdm1.fragments

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*

import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.view.menu.MenuBuilder
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm1.DataSource
import com.example.projettdm1.R
import com.example.projettdm1.adapters.LinearItemDecoration
import com.example.projettdm1.adapters.NewsListAdapter
import com.example.projettdm1.models.Categorie


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FilterNewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FilterNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FilterNewsFragment : Fragment(), PopupMenu.OnMenuItemClickListener {



    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnChipClickListener? = null
    private var mlistener: NewsListAdapter.OnNewsClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    var vi: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_filter_news, container, false)
        vi=view
        initMenu(view)
        initChips(view)
        initNewsList()
        return vi
    }

    fun initMenu(view: View) {
        var popupMenu = PopupMenu(context,view.findViewById(R.id.add_chip))
        for (i in 0 until DataSource.categoriesList.size) {
            popupMenu.menu.add(Menu.NONE,i,i,DataSource.categoriesList[i].Title)
        }
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.inflate(R.menu.category_menu)

        view.findViewById<ImageButton>(R.id.add_chip).setOnClickListener {
            popupMenu.show()
        }
    }
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        val category = DataSource.categoriesList[item!!.itemId]
        DataSource.addFilterContreint(item.itemId)
        listener?.onChipClick(category)
        updateNewsList()
        return true
    }

    fun initChips(view: View) {

        val firstCategory = DataSource.filterContreints[0]
        listener?.onChipClick(firstCategory)
    }

    override fun onResume() {
        updateNewsList()
        super.onResume()
    }

    fun updateNewsList() {
        var recylclerview = vi?.findViewById<RecyclerView>(R.id.filter_news_list)
        val l=mlistener
        l?.let {
            val adapter = NewsListAdapter(DataSource.filterNewsByCategories(),l)
            recylclerview?.adapter = adapter
        }
    }
    fun initNewsList() {
        var recylclerview = vi?.findViewById<RecyclerView>(R.id.filter_news_list)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        recylclerview?.addItemDecoration(LinearItemDecoration(spacingInPixels))
        recylclerview?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val l=mlistener
        l?.let {
            val adapter = NewsListAdapter(DataSource.filterNewsByCategories(),l)
                    recylclerview?.adapter = adapter
        }


    }

    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnChipClickListener) {
            listener = context
            if (context is NewsListAdapter.OnNewsClickListener) {
                mlistener = context
            } else {
                throw RuntimeException(context.toString() + " must implement OnNewsClickListener")
            }
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
    interface OnChipClickListener {
        // TODO: Update argument type and name
        fun onChipClick(category: Categorie)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FilterNewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilterNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
