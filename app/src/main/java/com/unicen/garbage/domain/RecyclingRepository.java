package com.unicen.garbage.domain;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.unicen.garbage.data.GarbageService;
import com.unicen.garbage.data.GarbageServiceGenerator;
import com.unicen.garbage.domain.entities.Recycling;
import com.unicen.garbage.domain.entities.User;

import java.util.List;

import retrofit2.Call;

public class RecyclingRepository {

    private static final String ACTUAL_SHARED_PREFERENCES = "com.unicen.garbage.ACTUAL_SHARED_PREFERENCES";
    private static final String USERNAME_SHARED_PREFERENCES = "com.unicen.garbage.USERNAME_SHARED_PREFERENCES";

    public static Call<List<Recycling>> getRecyclingHistory(Context context) {
        return GarbageServiceGenerator.createService(GarbageService.class).getUserRecyclingHistory(getUserFromPreferences(context));
    }

    public static void saveRecyclingInPreferences(Context context, Recycling recycling) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ACTUAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(recycling);
        editor.putString("Recycling", json);
        editor.apply();
    }

    public static Recycling getRecyclingFromPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ACTUAL_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Recycling", "");
        if (json != null && !json.isEmpty()) {
            return gson.fromJson(json, Recycling.class);
        }
        return null;
    }

    public static Call<Recycling> getTotalRecycling() {
        return GarbageServiceGenerator.createService(GarbageService.class).getTotalRecycling();
    }

    public static Call<User> saveUserInServer(User user) {
        return GarbageServiceGenerator.createService(GarbageService.class).registerUser(user);
    }

    public static void saveUserInPreferences(User user, Context context) {
        SharedPreferences userSharedPreferences = context.getSharedPreferences(USERNAME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userSharedPreferences.edit();
        editor.putString("Username", user.getUsername());
        editor.apply();
    }

    public static String getUserFromPreferences(Context context) {
        SharedPreferences userSharedPreferences = context.getSharedPreferences(USERNAME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return userSharedPreferences.getString("Username", "");
    }

    public static void submitRecyclingToServer(Recycling recycling) {
        //TODO: implement
    }
}
