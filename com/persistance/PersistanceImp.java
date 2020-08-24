package com.persistance;

public class PersistanceImp implements Persistance {
    private String dataFile;

    public PersistanceImp(String fileName) {
        dataFile = fileName;
    }

    @Override
    public void save(String data) {

    }

    @Override
    public String load() {
        return "";
    }
}