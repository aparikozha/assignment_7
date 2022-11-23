package com.example.assignment7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Call
import okhttp3.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)


        RestClient.getReqResApi.getUsers(1).enquque: Callback<ReqResData<List<User>>{
            override fun onResponse(
                call: Call <ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>){
                if (response.isSuccessful && response.body() is null){
                    recyclerView.adapter = UserAdapter(response.body()!!.data!!)



                }
            }
            )
        }
    }
}