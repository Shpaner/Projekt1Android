
package com.example.sqlite_example.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_example.R
import com.example.sqlite_example.model.entities.Student
import com.example.sqlite_example.view_model.StudentListAdapter
import com.example.sqlite_example.view_model.UsersViewModel
import kotlinx.android.synthetic.main.fragment_student_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var viewModel:UsersViewModel

class StudentListFragment : Fragment(), StudentListAdapter.OnStudDelClickListener,StudentListAdapter.OnStudEditClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var myadapter:StudentListAdapter
    private lateinit var myLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
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
        myLayoutManager=LinearLayoutManager(context)

        viewModel=ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)

        myadapter=StudentListAdapter(viewModel.students,this,this)

        viewModel.students.observe(viewLifecycleOwner, Observer { t->
            myadapter.notifyDataSetChanged()
            text_student.text="${t.size}"

        })


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recyclerView w tym miejscu może być dopiero wywoływany
        recyclerView=recyclerViewStudents.apply {
           this.layoutManager=myLayoutManager
            this.adapter=myadapter
        }

    }

    companion object {
        // TODO: Rename and change types and number of parameters

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDelStudClick(position: Int, model: Student?) {
        viewModel.deleteStudent(model as Student)
    }

    override fun onEditStudClick(position: Int, model: Student?) {


    }
}