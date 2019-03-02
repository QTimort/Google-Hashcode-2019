package eu.epitech.hashcode_2019;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import eu.epitech.hashcode_2019.model.Image;
import eu.epitech.hashcode_2019.model.Slide;
import lombok.Getter;

import java.util.*;

@Getter
public class InputData {
    //private final ListMultimap<Integer, String> tagMap;
    private final ListMultimap<Integer, Integer> tagImageMap;
    private final Map<Integer, Integer> imageTagMap;
    private final ListMultimap<Integer, Integer> nbTagsImage;
    private final List<Image> imageArray;
    private int tagCount = 0;
    // todo sort by number of tags

    public InputData(int nbImage) {
        //this.tagMap = ArrayListMultimap.create(nbImage, 1);
        this.tagImageMap = ArrayListMultimap.create(nbImage, 1);
        this.imageTagMap = new HashMap<>(nbImage, 2);
        this.imageArray = new ArrayList<>(nbImage);
        this.nbTagsImage = ArrayListMultimap.create();
    }

    public int addTag(int imageId, final String tag) {
        final int hashCode = tag.hashCode();
        //this.tagMap.put(hashCode, tag);
        this.imageTagMap.put(imageId, hashCode);
        this.tagImageMap.put(hashCode, imageId);
        ++this.tagCount;
        return hashCode;
    }

    public void fillNbsTagsImage() {
        this.imageArray.forEach(image -> {
            this.nbTagsImage.put(image.getTags().size(), image.getId());
        });
    }

    public int addImage(final Image image) {
        this.imageArray.add(image);
        return this.imageArray.size() - 1;
    }

    public void removeSlide(final Slide slide) {
        slide.getImageIds().forEach(this::removeImage);
    }

    public void removeImage(final int imageId) {
        final Image image = this.imageArray.get(imageId);
        //this.imageArray.remove(imageId);
        this.imageTagMap.remove(imageId);
        for (int tagId : image.getTags()) {
            this.tagImageMap.remove(tagId, imageId);
        }
        this.nbTagsImage.remove(image.getTags().size(), image.getId());
    }
}
