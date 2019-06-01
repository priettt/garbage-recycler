package com.unicen.garbage.domain;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.unicen.garbage.domain.entities.Recycling;

import java.util.ArrayList;

public abstract class RecyclingRepository {

    private static final String SHARED_PREFERENCES = "com.unicen.garbage.SHARED_PREFERENCES";

    //TODO: implement with proper parameters and return types, calling the database and service classes
    abstract void getTotalRecycling();       //asks for the total recycling from the server.

    public static ArrayList<Recycling> getRecyclingHistory() {
        //asks the server the recyclings history.
        ArrayList<Recycling> aux = new ArrayList<>();
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        aux.add(new Recycling("hola", "hola", "hola", "hola", "hola", "hola"));
        return aux;
    }

    abstract void createNewUser();           //calls the server to create a new user.

    public static void saveRecyclingInPreferences(Context context, Recycling recycling) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(recycling);
        editor.putString("Recycling", json);
        editor.apply();
    }

    public static Recycling getRecyclingFromPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Recycling", "");
        if (json != null && !json.isEmpty()) {
            return gson.fromJson(json, Recycling.class);
        }
        return null;
    }
}
