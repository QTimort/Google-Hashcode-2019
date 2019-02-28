package eu.epitech.hashcode_2019.solver;

import eu.epitech.hashcode_2019.OpDictionnary;
import eu.epitech.hashcode_2019.model.Slide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SolverImpl implements ISolver {

    private final List<Slide> mergedSlides = new ArrayList<>();
    private final List<Slide> HorSlides = new ArrayList<>();
    private final List<Slide> finalSlideshow = new ArrayList<>();


    public List<Slide> solve() {
        createMatchedSlideByPopularity();
        createHorSlides();
        ArrayList<Slide> tmp = new ArrayList<>(mergedSlides);
        tmp.addAll(HorSlides);
        createMatchedAllSlideByPopularity(tmp);
        return new ArrayList<>(finalSlideshow);
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

    private void createHorSlides() {
        for (final int imageId : OpDictionnary.horiImageIds) {
            Slide newSlide = new Slide();
            List<Integer> images = Arrays.asList(imageId);
            newSlide.setImageIds(images);
            OpDictionnary.removeImageId(imageId);
            HorSlides.add(newSlide);
        }
    }

    private void createMatchedAllSlideByPopularity(List<Slide> mergedSlidesWithHor) {
        Deque<Slide> slides = OpDictionnary.queueMySlides(mergedSlidesWithHor);
        while (!slides.isEmpty()) {
            if (slides.size() < 2)
                break;
            Slide newSlide = new Slide();
            Slide slideLast = slides.pollFirst();
            Slide slideFirst = slides.pollLast();

            finalSlideshow.add(slideFirst);
            finalSlideshow.add(slideLast);
        }
    }
}
