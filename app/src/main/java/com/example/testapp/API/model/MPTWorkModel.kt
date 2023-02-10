package com.example.mptworkpractice.API.model

import com.google.gson.annotations.SerializedName
import java.sql.Date

data class RoleUs(
    var idRole: Int,
    var nameRole: String
)

data class Account(
    val idAcc: Int,
    val email: String,
    val passwordAcc: String,
    val roleId: Int
)

data class GroupSt(
    val idGroup: Int,
    val nameGroup: String,
)

data class Cours(
    val idCours: Int,
    val nameCours: String,
)

data class Specialization(
    val idSpec: Int,
    val nameSpec: String,
)

data class Student(
    val idStudent: Int,
    val accId: Int,
    val nameSt: String,
    val lastName: String,
    val surname: String,
    val groupId: Int,
    val coursId: Int,
    val specId: Int
)

data class ResumeSt(
    val idRes: Int,
    val studentId: Int,
    val photo: String,
    val email: String,
    val dateBirthday: Date,
    val metro: String,
    val telephone: String,
    val purpose: String,
    val education: String,
    val personalQualities: String,
    val professionalSkills: String,
    val additionalInformation: String,
    val workExperience: Int
)

data class Document(
    val idDoc: Int,
    val nameDoc: String,
    val urlDoc: String,
)

data class ProfComp(
    val idProfComp: Int,
    val nameComp: String,
)

data class ProgramModule(
    val idPrMod: Int,
    val nameModul: String,
    val profCompId: Int,
)

data class StatusEnd(
    val idStatus: Int,
    val nameStatus: String,
)

data class Post(
    val idPost: Int,
    val namePost: String,
)

data class HeadOrganization(
    val idHeadOrg: Int,
    val nameHead: String,
    val lastName: String,
    val surname: String,
    val postId: Int,
    val photoURL: String
)

data class HeadTechnikum(
    val idHeadT: Int,
    val nameH: String,
    val lastName: String,
    val surname: String,
    val email: String,
    val numberphone: String,
    val postId: Int,
)

data class Estimation(
    val idEst: Int,
    val estimation: String,
)

data class BasePractic(
    val idBase: Int,
    val nameBase: String,
    val adress: String,
    val numberPhone: String,
    val email: String,
    val saitUrl: String,
    val photoUrl: String,
    val headOrgId: Int,
)

data class Practik(
    val idPractik: Int,
    val studentId: Int,
    val dateStart: Date,
    val dateEnd: Date,
    val statusId: Int,
    val basePractic: Int,
    val coursId: Int,
    val headOrgId: Int,
    val headTechId: Int,
    val estimationOrgId: Int,
    val estimationTechId: Int,
    val moduleId: Int,
)

data class PracticDocument(
    val idPrDock: Int,
    val practicId: Int,
    val documentId: Int
)

data class Diary(
    val idDiary: Int,
    val dateDiary: Date,
    val realizationTask: String
)

data class PracticDiary(
    val idPrDiary: Int,
    val practicId: Int,
    val diaryId: Int
)