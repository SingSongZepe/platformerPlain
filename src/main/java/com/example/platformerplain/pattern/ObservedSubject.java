package com.example.platformerplain.pattern;

/**
 * Observed Subject in Observer Pattern
 */
public interface ObservedSubject {
    /**
     * add observer to list of observer
     * @param observer observer which added
     */
    void attach(Observer observer);
    /**
     * remove observer to list of observer
     * @param observer observer which removed
     */
    void detach(Observer observer);
    /**
     * notify observers when the value has been modified
     */
    void notifyObservers();
}
