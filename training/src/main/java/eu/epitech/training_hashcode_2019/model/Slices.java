package eu.epitech.training_hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Vector;

@Data
@AllArgsConstructor
public class Slices {
    private final Vector<Slice> slices;
}
