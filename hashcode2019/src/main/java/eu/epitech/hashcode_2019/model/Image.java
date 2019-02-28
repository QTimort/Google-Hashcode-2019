package eu.epitech.hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private boolean isHorizontal;
    private int nbTag;
    private String[] tags;

    public void allocTags() {
        tags = new String[this.nbTag];
    }
}
