package com.example.botond.forecastapp;

public interface MainMVP {
    interface view{
        void showMessage();
    }

    interface presenter{
        void forecastButtonClick();
    }
}
