package com.example.testapp.API.service

import com.example.mptworkpractice.API.model.*
import io.reactivex.rxjava3.core.Single
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MPTWorkService {
    @GET("RoleUs")
    fun getRole(): Single<List<RoleUs>>

    @GET("Accounts")
    fun getAccount(): Single<List<Account>>
    @GET("Accounts")
    fun getAccountList(@Query("email") email: String): Call<List<Account>>
    @GET("Accounts/{id}")
    suspend fun getAccountID(@Path(value = "id") id: Int)
    : Call<Account>

    @POST("Accounts")
    fun login(
        @Field(value = "email") email: String,
        @Field(value = "password") password: String,
        @Field(value = "roleId") roleId: Int
    )
//    fun getAccountID(id: RowId): Single<List<Account>>

    @GET("GroupSts")
    fun getGroups(): Single<List<GroupSt>>

    @GET("Cours")
    fun getCours(): Single<List<Cours>>

    @GET("Specializations")
    fun getSpecialization(): Single<List<Specialization>>

    @GET("Students")
    fun getStudent(): Single<List<Student>>

    @GET("ResumeSts")
    fun getResumeSt(): Single<List<ResumeSt>>

    @GET("Documents")
    fun getDocument(): Single<List<Document>>

    @GET("ProfComps")
    fun getProfComp(): Single<List<ProfComp>>

    @GET("ProgramModules")
    fun getProgramModule(): Single<List<ProgramModule>>

    @GET("StatusEnds")
    fun getStatusEnd(): Single<List<StatusEnd>>

    @GET("Posts")
    fun getPost(): Single<List<Post>>

    @GET("HeadOrganizations")
    fun getHeadOrganization(): Single<List<HeadOrganization>>

    @GET("HeadTechikums")
    fun getHeadTechnikum(): Single<List<HeadTechnikum>>

    @GET("Estimations")
    fun getEstimation(): Single<List<Estimation>>

    @GET("BasePraktics")
    fun getBasePractic(): Single<List<BasePractic>>

    @GET("Practiks")
    fun getPractik(): Single<List<Practik>>

    @GET("PracticDocuments")
    fun getPracticDocument(): Single<List<PracticDocument>>

    @GET("Diaries")
    fun getDiary(): Single<List<Diary>>

    @GET("PracticDiaries")
    fun getPracticDiary(): Single<List<PracticDiary>>
}