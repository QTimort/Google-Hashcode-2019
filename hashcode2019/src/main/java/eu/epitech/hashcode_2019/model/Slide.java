package eu.epitech.hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slide {
    private List<Integer> imageIds;
}
