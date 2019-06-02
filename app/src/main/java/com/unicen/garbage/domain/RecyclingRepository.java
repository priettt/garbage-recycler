package com.unicen.garbage.domain;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.unicen.garbage.domain.entities.Recycling;
import com.unicen.garbage.domain.entities.User;

import java.util.ArrayList;

public abstract class RecyclingRepository {

    private static final String ACTUAL_SHARED_PREFERENCES = "com.unicen.garbage.ACTUAL_SHARED_PREFERENCES";
    private static final String USERNAME_SHARED_PREFERENCES = "com.unicen.garbage.USERNAME_SHARED_PREFERENCES";

    public static ArrayList<Recycling> getRecyclingHistory() {
        //TODO: Implement
        ArrayList<Recycling> aux = new ArrayList<>();
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        return aux;
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

    public static Recycling getTotalRecycling() {
        //TODO: implement
        return new Recycling("4", "1", "4", "1", "4", "1");
    }

    public static void createNewUser(Context context, User user) {
        SharedPreferences userSharedPreferences = context.getSharedPreferences(USERNAME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = userSharedPreferences.edit();
        editor.putString("Username", user.getUsername());
        editor.apply();
    }

    public static String getUser(Context context) {
        SharedPreferences userSharedPreferences = context.getSharedPreferences(USERNAME_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return userSharedPreferences.getString("Username", "");
    }

    public static void submitRecyclingToServer(Recycling recycling) {
        //TODO: implement
    }
}
