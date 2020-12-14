package com.example.sqlite_example.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite_example.R
import com.example.sqlite_example.model.entities.Course
import com.example.sqlite_example.view_model.CourseListAdapter
import com.example.sqlite_example.view_model.CourseViewModel
import com.example.sqlite_example.view_model.UsersViewModel
import kotlinx.android.synthetic.main.fragment_course_list.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var viewModel:CourseViewModel

class CourseListFragment : Fragment(), CourseListAdapter.OnCourseClickListener {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var myadapter:CourseListAdapter
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

        viewModel = ViewModelProvider(requireActivity()).get(CourseViewModel::class.java)

        myadapter= CourseListAdapter(viewModel.courses,this)

        viewModel.courses.observe(viewLifecycleOwner, Observer { t->
            myadapter.notifyDataSetChanged()
            text_course.text="${t.size}"

        })


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recyclerView w tym miejscu może być dopiero wywoływany
        recyclerView = recyclerViewCourse.apply {
            this.layoutManager=myLayoutManager
            this.adapter=myadapter
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CourseListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCourseClick(position: Int, model: Course?) {
        viewModel.deleteCourse(model as Course)
    }
}