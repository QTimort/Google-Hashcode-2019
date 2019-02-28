package eu.epitech.hashcode_2019.solver;

import eu.epitech.hashcode_2019.OpDictionnary;
import eu.epitech.hashcode_2019.model.Slide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolverImpl implements ISolver {

    private final List<Slide> mergedSlides = new ArrayList<>();

    public List<Slide> solve() {
        createMatchedSlideByPopularity();
        return new ArrayList<>(mergedSlides);
    }

    private void createMatchedSlideByPopularity() {
        while (!OpDictionnary.imagesByPopularity.isEmpty()) {
            if (OpDictionnary.imagesByPopularity.size() < 2)
                break;
            Slide newSlide = new Slide();
            int imageLast = OpDictionnary.imagesByPopularity.pollFirst();
            int imageFirst = OpDictionnary.imagesByPopularity.pollLast();

            List<Integer> images = Arrays.asList(imageFirst, imageLast);
            newSlide.setImageIds(images);
            OpDictionnary.removeImageId(imageFirst);
            OpDictionnary.removeImageId(imageLast);
            mergedSlides.add(newSlide);
        }
    }
}
