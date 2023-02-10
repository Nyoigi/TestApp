package com.example.mptworkpractice.recyclerview.models

data class Practice(
    val namePractice: String, val dateStart: String, val dateEnd: String,
    val status: String, val estimationOrganization: Int,
    val estimationTechnicalSchool: Int
)