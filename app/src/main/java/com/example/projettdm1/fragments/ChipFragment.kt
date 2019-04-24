package com.example.projettdm1.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm1.DataSource
import com.example.projettdm1.LocaleHelper
import com.example.projettdm1.R
import com.example.projettdm1.adapters.LinearItemDecoration
import com.example.projettdm1.adapters.NewsListAdapter
import com.example.projettdm1.models.Categorie
import com.google.android.material.chip.Chip


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private var ARG_PARAM1:Categorie? = null


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ChipFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ChipFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ChipFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Categorie? = null
    private var listener: OnCloseListener? = null
    private var mlistener: NewsListAdapter.OnNewsClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = ARG_PARAM1

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_chip, container, false)
        if(LocaleHelper.lang=="ar") view.findViewById<Chip>(R.id.cat_chip).text = param1?.Title_ar
        else view.findViewById<Chip>(R.id.cat_chip).text = param1?.Title

        view.findViewById<Chip>(R.id.cat_chip).setOnCloseIconClickListener {
            val cat=param1
            cat?.let {
                listener?.onClose(this,cat)
                updateNewsList()
            }

        }

        return view
    }
    fun updateNewsList() {
        var recylclerview = activity?.findViewById<RecyclerView>(R.id.filter_news_list)
        val l=mlistener
        l?.let {
            val adapter = NewsListAdapter(DataSource.filterNewsByCategories(),l)
            recylclerview?.adapter = adapter
        }

    }

    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCloseListener) {
            listener = context
            if (context is NewsListAdapter.OnNewsClickListener) {
                mlistener = context
            } else {
                throw RuntimeException(context.toString() + " must implement OnNewsClickListener")
            }
        } else {
            throw RuntimeException(context.toString() + " must implement OnCloseLIstener")
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
    interface OnCloseListener {
        // TODO: Update argument type and name
        fun onClose(chip: Fragment, categorie: Categorie)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChipFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Categorie) =
            ChipFragment().apply {
                arguments = Bundle().apply {
                    ARG_PARAM1 = param1
                }
            }
    }
}
