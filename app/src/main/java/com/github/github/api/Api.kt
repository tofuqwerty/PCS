package com.github.github.api

import com.github.github.data.model.DetailUserResponse
import com.github.github.data.model.User
import com.github.github.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token f69b3df5ad9cbfc7286683ea4158ef364f26560e")
    fun getSearchUsers(
            @Query("q") query: String
    ):Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token f69b3df5ad9cbfc7286683ea4158ef364f26560e")
    fun getUserDetail(
            @Path("username") username : String
    ):Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token f69b3df5ad9cbfc7286683ea4158ef364f26560e")
    fun getFollowers(
            @Path("username") username: String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token f69b3df5ad9cbfc7286683ea4158ef364f26560e")
    fun getFollowing(
            @Path("username") username: String
    ):Call<ArrayList<User>>
}