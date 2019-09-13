package com.unicen.garbage.data

import com.unicen.garbage.domain.entities.Recycling
import retrofit2.http.GET

interface KotlinGarbageService {
    @GET("/api/userrecyclings/total/")
    suspend fun getTotalRecycling(): Recycling
}