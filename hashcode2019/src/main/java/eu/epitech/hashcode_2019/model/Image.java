package eu.epitech.hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private boolean isHorizontal;
    private int id;
    private List<Integer> tags;
}
