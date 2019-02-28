package eu.epitech.hashcode_2019;

import com.google.common.collect.BiMap;
import eu.epitech.hashcode_2019.model.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dictionnary {
    public static BiMap<String, Integer> tags; // <Tag, Tag_id>
    public static Map<Integer, List<Integer>> tagImages; // <Tag_id, List<Img_id>>
    public static Image[] images; // [Img_id]

    public static int addTagOp(int imageId, String tag) {
        final int tagId;
        if (!tags.containsKey(tag)) {
            tagId = tags.size();
            tags.put(tag, tags.size());
        } else {
            tagId = tags.get(tag);
        }
        final List<Integer> imgIds = tagImages.get(tagId);
        if (imgIds == null ) {
            final List<Integer> imgIdList = new ArrayList<>();
            imgIdList.add(imageId);
            tagImages.put(tagId, imgIdList);
        } else {
            imgIds.add(imageId);
        }
        return tagId;
    }
}
