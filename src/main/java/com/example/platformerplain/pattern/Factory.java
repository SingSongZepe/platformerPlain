package com.example.platformerplain.pattern;

/**
 * Factory Pattern
 * Used for creating objects, especially when multiple
 * objects with a common interface or base class need to be created.
 * @param <T> type of creating objects
 */
public interface Factory <T>{
    T create();
}
