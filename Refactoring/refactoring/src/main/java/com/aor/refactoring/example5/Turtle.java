package com.aor.refactoring.example5;

public class Turtle {

    private Position position;

    public Turtle(int row, int column, char direction) {
        this.position = new Position(row, column, direction);
    }

    public int getRow() {
        return position.getRow();
    }

    public int getColumn() {
        return position.getColumn();
    }

    public char getDirection() {
        return position.getDirection();
    }

    public Position getPosition() { return position; }

    public void execute(Command command) {
        command.execute();
    }
}
