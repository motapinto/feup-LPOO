package com.aor.refactoring.example5;

public class MoveForward implements Command {

    private Position position;

    public MoveForward(Position position) {
        this.position = position;
    }

    public void execute() {
        position.moveForward();
    }
}
