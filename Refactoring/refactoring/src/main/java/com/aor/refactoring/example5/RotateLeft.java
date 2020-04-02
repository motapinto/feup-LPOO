package com.aor.refactoring.example5;

public class RotateLeft implements Command {

    private Position position;

    public RotateLeft(Position position) {
        this.position = position;
    }

    public void execute() {
        position.rotateLeft();
    }
}
