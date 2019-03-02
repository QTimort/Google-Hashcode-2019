package eu.epitech.hashcode_2019.model;

import lombok.Data;

import java.util.*;

@Data
public class Slide {
    private List<Integer> imageIds;

    public Slide(int imageId) {
        this.imageIds = Collections.singletonList(imageId);
    }

    public Slide(int a, int b) {
        this.imageIds = new ArrayList<>();
        this.imageIds.add(a);
        this.imageIds.add(b);
    }
}
