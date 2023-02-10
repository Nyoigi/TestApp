package com.example.testapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mptworkpractice.recyclerview.models.Practice
import com.example.testapp.R
import com.example.testapp.databinding.PostAdapterItemBinding
import com.example.testapp.databinding.StudentListAdapterBinding
import com.example.testapp.recyclerview.models.Student

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

//    var binding: StudentListAdapterBinding? = null
//
//    var studentList = listOf<Student>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        return StudentViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.student_list_adapter, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
//        holder.bind(
//            nameSt = studentList[position].nameSt,
//            group = studentList[position].group,
//            cours = studentList[position].cours
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return studentList.size
//    }
//
//    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(
//            nameSt: String,
//            group: String,
//            cours: String
//        ) {
//            itemView.findViewById<TextView>(R.id.tvNameLastnameSurnameSt).text = nameSt
//            itemView.findViewById<TextView>(R.id.tvGroup).text = group
//            itemView.findViewById<TextView>(R.id.tvCours).text = cours
//        }
//    }
//}

    var binding: StudentListAdapterBinding? = null
    var studentList = listOf<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.student_list_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(
            nameSt = studentList[position].nameSt + " " + studentList[position].lastName
            + " " + studentList[position].surname,
            group = studentList[position].group,
            cours = studentList[position].cours
        )
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            nameSt: String,
            group: String,
            cours: String
        ) {
            itemView.findViewById<TextView>(R.id.tvNameLastnameSurnameSt).text = nameSt
            itemView.findViewById<TextView>(R.id.tvGroup).text = group
            itemView.findViewById<TextView>(R.id.tvCours).text = cours
        }
    }

    class NotesViewHolder(
        private val binding: StudentListAdapterBinding,
        private val noteClickImpl: StudentClick?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(st: Student) {
            with(binding) {
                tvNameLastnameSurnameSt.text =st.nameSt
                tvGroup.text = st.group
                tvCours.text = st.cours
            }
        }
    }
}

interface StudentClick {
    fun  getStudent(st: Student)
}

