package com.unicen.garbage.data;

import com.unicen.garbage.domain.entities.Recycling;
import com.unicen.garbage.domain.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GarbageService {
    @GET("/api/userrecyclings/{user}/")
    Call<List<Recycling>> getUserRecyclingHistory(@Path("user") String user);

    @GET("/api/userrecyclings/total/")
    Call<Recycling> getTotalRecycling();

    @POST("/api/personas/")
    Call<User> registerUser(@Body User user);
}

