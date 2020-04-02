package com.aor.refactoring.example5;

public class RotateRight implements Command {

    private Position position;

    public RotateRight(Position position) {
        this.position = position;
    }

    public void execute() {
        position.rotateRight();
    }
}
