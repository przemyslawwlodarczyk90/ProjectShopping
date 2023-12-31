package com.example.projectshopping.notification;

import com.example.projectshopping.model.entities.order.Observable;

public interface Observer {

    void update(Observable observable);

}