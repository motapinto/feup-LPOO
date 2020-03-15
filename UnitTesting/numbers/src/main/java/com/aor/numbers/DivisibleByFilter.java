package com.aor.numbers;

public class DivisibleByFilter implements IListFilter {
    private final int number;

    public DivisibleByFilter (int number) {
        this.number = number;
    }

    @Override
    public boolean accept(Integer num) {
        return num % this.number == 0;
    }
}
