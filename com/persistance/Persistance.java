package com.persistance;

public interface Persistance {

    boolean save(Object object);

    Object load();
}