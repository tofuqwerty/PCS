package com.github.github.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.github.api.RetrofitClient
import com.github.github.data.model.User
import com.github.github.data.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String){
        RetrofitClient.apiInstance
                .getSearchUsers(query)
                .enqueue(object : Callback<UserResponse>{
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                        if (response.isSuccessful){
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//                        Log.d("Failure", t.message)
                    }

                })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUsers
    }
}