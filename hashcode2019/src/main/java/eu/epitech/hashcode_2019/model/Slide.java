package eu.epitech.hashcode_2019.model;

import com.google.common.collect.BiMap;
import eu.epitech.hashcode_2019.OpDictionnary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slide {
    private List<Integer> imageIds;

    Set<Integer> getTagIds() {
        final Set<Integer> ids = new HashSet<>();
        imageIds.forEach(imgId -> {
            final Image image = OpDictionnary.images[imgId];
            for (int tagId : image.getTags()) {
                ids.add(tagId);
            }
        });
        return ids;
    }

    List<String> getTagStrings() {
        final Set<Integer> tagIds = getTagIds();

        final BiMap<Integer, String> inverse = OpDictionnary.tags.inverse();
        final List<String> tagStrings = new ArrayList<>(tagIds.size());
        for (int id : tagIds) {
            tagStrings.add(inverse.get(id));
        }
        return tagStrings;
    }
}
