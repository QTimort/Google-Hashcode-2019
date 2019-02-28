package eu.epitech.hashcode_2019;


import eu.epitech.hashcode_2019.model.Slide;

import java.util.List;

public class Validator {

    public static void Assert(boolean predicate) {
        Assert(predicate, "");
    }

    public static void Assert(boolean predicate, final String message) {
        if (!predicate)
            throw new RuntimeException("Assertion failed: " + message);
    }

    public void validate(List<Slide> solution) {
        Assert(true);
    }
}
