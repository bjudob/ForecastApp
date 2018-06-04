package com.example.botond.forecastapp;

public interface MainMVP {
    interface view{
        void showToast(String message);
    }

    interface presenter{
        void forecastButtonClick();
    }
}
