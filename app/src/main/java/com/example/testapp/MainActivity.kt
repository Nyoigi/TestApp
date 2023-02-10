package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mptworkpractice.utils.navigateToFragment
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val apiUrl: String = "http://192.168.177.131:3000/api/Accounts"

    private var client: OkHttpClient? = null
    private var request: Request? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            supportFragmentManager.navigateToFragment(fragment = LoginFragment())

        client = OkHttpClient()
        request = Request.Builder().url(apiUrl).build()

        client?.newCall(request!!)?.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("APIERR", e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("APIRESULT", response.body.string())
            }
        })

    }
}