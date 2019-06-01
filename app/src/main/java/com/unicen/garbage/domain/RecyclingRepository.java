package com.unicen.garbage.domain;

import com.unicen.garbage.domain.entities.Recycling;

import java.util.ArrayList;

public abstract class RecyclingRepository {
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

    abstract void saveRecyclings();          //saves the actual recyclings in the database.
}
