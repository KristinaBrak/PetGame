package com.server.input;

public class InputHandlerImp implements InputHandler {
    private String input;

    public InputHandlerImp(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }

}