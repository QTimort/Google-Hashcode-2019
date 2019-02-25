package eu.epitech.training_hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ingredient {
    Mushroom('M'),
    Tomato('T');

    private final char character;

    public static Ingredient valueOf(final char c) {
        for (Ingredient value : Ingredient.values()) {
            if (value.character == c) {
                return (value);
            }
        }
        throw new RuntimeException("Invalid ingredient: \'" + c + "\'");
    }

    @Override
    public String toString() {
        return Character.toString(this.character);
    }
}

