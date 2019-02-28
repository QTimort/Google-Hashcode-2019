package eu.epitech.hashcode_2019.model;

import com.google.common.collect.BiMap;
import eu.epitech.hashcode_2019.OpDictionnary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private boolean isHorizontal;
    private int id;
    private int[] tags;

    List<String> getTagStrings() {
        final BiMap<Integer, String> inverse = OpDictionnary.tags.inverse();
        final List<String> tagStrings = new ArrayList<>(tags.length);
        for (int id : tags) {
            tagStrings.add(inverse.get(id));
        }
        return tagStrings;
    }
}
