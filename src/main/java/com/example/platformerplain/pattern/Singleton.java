package com.example.platformerplain.pattern;

/**
 * Singleton Pattern
 * Used to ensure that a class has only one instance and provide a global access point.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton is doing something!");
    }
}
