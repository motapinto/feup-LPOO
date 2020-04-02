package com.aor.refactoring.example5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, 'N');
        Command left = new RotateLeft(turtle.getPosition());

        left.execute(); assertEquals('W', turtle.getDirection());
        left.execute(); assertEquals('S', turtle.getDirection());
        left.execute(); assertEquals('E', turtle.getDirection());
        left.execute(); assertEquals('N', turtle.getDirection());

        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, 'N');
        Command right = new RotateRight(turtle.getPosition());

        right.execute(); assertEquals('E', turtle.getDirection());
        right.execute(); assertEquals('S', turtle.getDirection());
        right.execute(); assertEquals('W', turtle.getDirection());
        right.execute(); assertEquals('N', turtle.getDirection());

        assertEquals(5, turtle.getRow());
        assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtle = new Turtle(5, 5, 'N');
        Command forward = new MoveForward(turtle.getPosition());

        forward.execute();
        assertEquals(4, turtle.getRow());
        assertEquals(5, turtle.getColumn());

        turtle = new Turtle(5, 5, 'W');
        forward = new MoveForward(turtle.getPosition());

        forward.execute();
        assertEquals(5, turtle.getRow());
        assertEquals(4, turtle.getColumn());

        turtle = new Turtle(5, 5, 'S');
        forward = new MoveForward(turtle.getPosition());

        forward.execute();
        assertEquals(6, turtle.getRow());
        assertEquals(5, turtle.getColumn());

        turtle = new Turtle(5, 5, 'E');
        forward = new MoveForward(turtle.getPosition());

        forward.execute();
        assertEquals(5, turtle.getRow());
        assertEquals(6, turtle.getColumn());
    }

}