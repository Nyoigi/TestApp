package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mptworkpractice.recyclerview.models.Practice
import com.example.testapp.databinding.FragmentMainBinding
import com.example.testapp.databinding.FragmentMainTeachBinding
import com.example.testapp.databinding.PostAdapterItemBinding
import com.example.testapp.recyclerview.PracticeAdapter
import com.example.testapp.recyclerview.StudentAdapter
import com.example.testapp.recyclerview.models.Student


class MainTeachFragment : Fragment() {
    private var binding: FragmentMainTeachBinding? = null

    private val studentList = listOf<Student>(
        Student(
            nameSt = "Иван", lastName = "Иванов", surname = "Иванович", group = "П50-2-20",
            cours = "3 курс"
        ),
        Student(
            nameSt = "Екатерина", lastName = "Солдатова", surname = "Алексеевна", group = "П50-6-20",
            cours = "3 курс"
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainTeachBinding
            .inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = StudentAdapter()
        adapter.studentList = studentList
        binding?.rvStud?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvStud?.adapter = adapter
    }
}