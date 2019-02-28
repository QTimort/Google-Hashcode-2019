package eu.epitech.hashcode_2019;

import com.google.common.collect.BiMap;
import eu.epitech.hashcode_2019.model.Image;

import java.util.*;

public class OpDictionnary {
    public static BiMap<String, Integer> tags = null; // <Tag, Tag_id>
    public static Map<Integer, Set<Integer>> tagImages = null; // <Tag_id, Set<Img_id>>
    public static Image[] images = null; // [Img_id]
    public static Set<Integer> vertImageIds = new HashSet<>();
    public static Set<Integer> horiImageIds = new HashSet<>();

    public static void factoryReset() {
        tags = null;
        tagImages = null;
        images = null;
        vertImageIds = new HashSet<>();
        horiImageIds = new HashSet<>();
    }

    public static int addTagOp(int imageId, String tag) {
        final int tagId;
        if (!tags.containsKey(tag)) {
            tagId = tags.size();
            tags.put(tag, tags.size());
        } else {
            tagId = tags.get(tag);
        }
        final Set<Integer> imgIds = tagImages.get(tagId);
        if (imgIds == null ) {
            final Set<Integer> imgIdList = new HashSet<>();
            imgIdList.add(imageId);
            tagImages.put(tagId, imgIdList);
        } else {
            imgIds.add(imageId);
        }
        return tagId;
    }

    public static int getTagOccurence(final int tagId) {
        return tagImages.get(tagId).size();
    }

    public static void removeImageId(int imageId) {
        final Image image = images[imageId];
        for (final int tagId : image.getTags()) {
            final Set<Integer> imageIds = tagImages.get(tagId);
            imageIds.remove(imageId);
        }
        vertImageIds.remove(imageId);
        horiImageIds.remove(imageId);
    }

    public static int getImageTagsPopularity(int imageId) {
        final Image image = images[imageId];
        int popularity = 0;
        for (int tagId : image.getTags()) {
            popularity += tagImages.get(tagId).size();
        }
        return popularity;
    }
}
