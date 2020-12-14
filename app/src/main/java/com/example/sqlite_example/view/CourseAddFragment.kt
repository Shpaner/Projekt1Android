package com.example.sqlite_example.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sqlite_example.R
import com.example.sqlite_example.view_model.CourseViewModel
import kotlinx.android.synthetic.main.fragment_course_add.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CourseAddFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: CourseViewModel

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

        viewModel= ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AddCourseButton.setOnClickListener { viewModel.addCourse(textName.text.toString()) }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CourseAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}