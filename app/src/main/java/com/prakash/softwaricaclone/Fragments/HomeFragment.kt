package com.prakash.softwaricaclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prakash.softwaricaclone.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prakash.SoftwaricaClone.R
import com.prakash.SoftwaricaClone.`object`.Student
import com.prakash.SoftwaricaClone.adapter.StudentAdapter
import com.prakash.SoftwaricaClone.model.student
import com.prakash.softwaricaclone.Adapter.StudentAdapter
import com.prakash.softwaricaclone.MainActivity
import com.prakash.softwaricaclone.model.Student

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private lateinit var lstStudent: ArrayList<MainActivity.student>
    private lateinit var recyclerView:RecyclerView
    private var param1 : String? =null
    private var param2 : String? = null


    override fun onCreate(  savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    companion object{
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.recyclerView)
        recyclerView.adapter?.notifyDataSetChanged()
        lstStudent= arrayListOf()
        //recyclerView.setHasFixedSize(true)
        val adapter= StudentAdapter(Student.lstStudent,requireContext())
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
    }
}