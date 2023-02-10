package com.example.testapp

import com.example.testapp.recyclerview.PracticeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mptworkpractice.recyclerview.models.Practice
import com.example.testapp.API.client.MPTWorkClient.mptWorkService
import com.example.testapp.databinding.FragmentMainBinding
import com.example.testapp.databinding.PostAdapterItemBinding
import com.example.testapp.recyclerview.models.Student
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private var bindingAdapter: PostAdapterItemBinding? = null


    private fun getPr() {
        mptWorkService.getPractik()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ listOfPractic ->
                val dateStart = listOfPractic.first().dateStart
                val dateEnd = listOfPractic.first().dateEnd
                val statusId = listOfPractic.first().statusId
                val studentList = listOf<Practice>(
                Practice(
                    dateStart = dateStart.toString(), dateEnd = dateEnd.toString(),
                    status = statusId.toString(), namePractice = "Брль",
                    estimationTechnicalSchool = 5, estimationOrganization = 3
                )
                )
                val adapter = PracticeAdapter()
                adapter.practiceList = studentList
                binding?.rvPost?.layoutManager = LinearLayoutManager(requireContext())
                binding?.rvPost?.adapter = adapter
            }, {})
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding
            .inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getPr()
    }

    private fun initAdapter() {
//        val adapter = PracticeAdapter()
//        adapter.practiceList =pra
//        binding?.rvPost?.layoutManager = LinearLayoutManager(requireContext())
//        binding?.rvPost?.adapter = adapter
    }
}