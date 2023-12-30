package com.example.projectshopping.notification;

import com.example.projectshopping.model.entities.product.Observable;

public interface Observer {

    void update(Observable observable);

}