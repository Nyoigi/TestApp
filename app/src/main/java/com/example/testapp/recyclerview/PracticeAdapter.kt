package com.example.testapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mptworkpractice.recyclerview.models.Practice
import com.example.testapp.R
import com.example.testapp.databinding.PostAdapterItemBinding

class PracticeAdapter : RecyclerView.Adapter<PracticeAdapter.PracticeViewHolder>() {

    var practiceList = listOf<Practice>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeViewHolder {
        return PracticeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.post_adapter_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PracticeViewHolder, position: Int) {
        holder.bind(
            namePractice = practiceList[position].namePractice,
            dateStart = practiceList[position].dateStart,
            dateEnd = practiceList[position].dateEnd,
            status = practiceList[position].status,
            estimationOrganization = practiceList[position].estimationOrganization,
            estimationTechnicalSchool = practiceList[position].estimationTechnicalSchool
        )
    }

    override fun getItemCount(): Int {
        return practiceList.size
    }

    class PracticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            namePractice: String, dateStart: String, dateEnd: String,
            status: String, estimationOrganization: Int,
            estimationTechnicalSchool: Int
        ) {
            itemView.findViewById<TextView>(R.id.tvNameModule).text = namePractice
            itemView.findViewById<TextView>(R.id.tvdateStartModule).text = dateStart
            itemView.findViewById<TextView>(R.id.tvdateEndModule).text = dateEnd
            itemView.findViewById<TextView>(R.id.tvstatusPractice).text = status
            itemView.findViewById<TextView>(R.id.tvevaluationOfTheOrganization).text =
                estimationOrganization.toString()
            itemView.findViewById<TextView>(R.id.tvteacherEvaluation).text =
                estimationTechnicalSchool.toString()
        }
    }

    class NotesViewHolder(
        private val binding: PostAdapterItemBinding,
        private val noteClickImpl: PracticeClick?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pr: Practice) {
            with(binding) {
                tvNameModule.text = pr.namePractice
                tvdateStartModule.text = pr.dateStart
                tvdateEndModule.text = pr.dateEnd
                tvstatusPractice.text = pr.status
                tvevaluationOfTheOrganization.text =
                    pr.estimationOrganization.toString()
                tvteacherEvaluation.text =
                    pr.estimationTechnicalSchool.toString()
            }
        }

        fun setListeners(practice: Practice) {
            with(binding) {
                root.setOnClickListener {
                    noteClickImpl?.getPractice(pr = practice)
                }
            }
        }
    }

}

interface PracticeClick {
    fun  getPractice(pr: Practice)
}