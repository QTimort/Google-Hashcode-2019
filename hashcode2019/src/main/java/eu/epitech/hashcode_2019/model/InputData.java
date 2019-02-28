package eu.epitech.hashcode_2019.model;

import lombok.Data;

@Data

public class InputData {
    private int nbPhoto;
    private Image[] images;

    @Override
    public String toString() {
        // todo
        return ("");
    }

    public void allocImages() {
        this.images = new Image[this.nbPhoto];
    }
}
