package com.unicen.garbage.domain;

public interface RecyclingRepository {
    //TODO: implement with proper parameters and return types, calling the database and service classes
    void getTotalRecycling();       //asks for the total recycling from the server.
    void getRecyclingHistory();     //asks the server the recyclings history.
    void createNewUser();           //calls the server to create a new user.
    void saveRecyclings();          //saves the actual recyclings in the database.
}
