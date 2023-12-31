package com.example.projectshopping.model.entities.order;

import com.example.projectshopping.notification.Observer;

import java.util.HashSet;
import java.util.Set;

public interface Observable {

    Set<Observer> registeredObservers = new HashSet<Observer>();

    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers();

}