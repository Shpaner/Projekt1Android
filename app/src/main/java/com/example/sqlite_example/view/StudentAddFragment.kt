package com.example.sqlite_example.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.sqlite_example.R
import com.example.sqlite_example.view_model.UsersViewModel
import kotlinx.android.synthetic.main.fragment_course_add.*
import kotlinx.android.synthetic.main.fragment_student_add.*



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StudentAddFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: UsersViewModel

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

        viewModel=ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AddCourseBtn.setOnClickListener {
            if(textName.text.toString()!=""&&textLastName.text.toString()!=""&&textName.text.toString()!="Name"&&textLastName.text.toString()!="LastName")
            {
                viewModel.addStudent(textName.text.toString(), textLastName.text.toString())
            }
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StudentAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}








//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
//class StudentAddFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    private lateinit var viewModel: UsersViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        viewModel=ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)
//
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_add, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        AddCourseButton.setOnClickListener {
//            if(textName.text.toString() != "" && textLastName.text.toString() != ""
//                && textName.text.toString() != "Name" &&textLastName.text.toString() != "LastName") {
//                viewModel.addStudent(textName.text.toString(), textLastName.text.toString())
//            }
//        }
//    }
//
//    companion object {
//
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            StudentAddFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}