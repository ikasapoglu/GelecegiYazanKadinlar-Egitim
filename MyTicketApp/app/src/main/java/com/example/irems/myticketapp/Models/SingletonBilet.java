package com.example.irems.myticketapp.Models;

public class SingletonBilet {

    private static SingletonBilet instance = null;

    public static SingletonBilet getInstance(){

        if(instance == null){
            instance = new SingletonBilet();
            return instance;
        }else {
            return instance;
        }
    }
}
