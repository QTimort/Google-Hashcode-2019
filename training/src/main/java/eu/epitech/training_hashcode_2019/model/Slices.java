package eu.epitech.training_hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Vector;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slices {
    private Vector<Slice> slices = new Vector<>();
}
