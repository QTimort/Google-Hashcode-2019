package eu.epitech.hashcode_2019;

import eu.epitech.hashcode_2019.model.InputData;

public class Validator {
    private final InputData inputData;

    public Validator(InputData inputData) {
        this.inputData = inputData;
    }

    public static void Assert(boolean predicate) {
        Assert(predicate, "");
    }

    public static void Assert(boolean predicate, final String message) {
        if (!predicate)
            throw new RuntimeException("Assertion failed: " + message);
    }

    public void validate(Object solution) {
        Assert(true);
    }
}
