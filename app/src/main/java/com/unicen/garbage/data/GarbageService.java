package com.unicen.garbage.data;

import com.unicen.garbage.domain.entities.Recycling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GarbageService {
    @GET("users/{user}/repos")
    Call<List<Recycling>> getUserRecyclingHistory(@Path("user") String user);
}

