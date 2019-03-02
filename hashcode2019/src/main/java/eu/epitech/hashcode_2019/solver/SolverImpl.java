package eu.epitech.hashcode_2019.solver;

import eu.epitech.hashcode_2019.InputData;
import eu.epitech.hashcode_2019.model.Image;
import eu.epitech.hashcode_2019.model.Slide;

import java.util.ArrayList;
import java.util.List;

public class SolverImpl implements ISolver {
    private int totalScore = 0;

    public int getNextVertical(InputData inputData, final Slide slide) {
        // todo
        return 0;
    }

    public int getNextHorizontal(InputData inputData, final Slide slide) {
        final List<Integer> tags = new ArrayList<>();
        slide.getImageIds().forEach(imageId -> {
            final Image image = inputData.getImageArray().get(imageId);
            tags.addAll(image.getTags());
        });

        final List<Integer> imageIds = new ArrayList<>();
        for (int i = 0; i < tags.size(); ++i) {
            imageIds.addAll(inputData.getTagImageMap().get(tags.get(i)));
        }
        int best = 0;
        int nextImg = -1;
        final int target = tags.size() / 2;
        for (int i = 0; i < imageIds.size(); ++i) {
            final int imageIdIt = imageIds.get(i);
            final Image imageIt = inputData.getImageArray().get(imageIdIt);
            if (imageIt.isHorizontal()) {
                final List<Integer> listB = inputData.getImageArray().get(imageIdIt).getTags();
                final int commonMatch = (int) tags.stream().filter(listB::contains).count();
                final int aNoMatch = tags.size() - commonMatch;
                final int bNoMatch = imageIt.getTags().size() - commonMatch;
                final int score = Math.min(aNoMatch, Math.min(commonMatch, bNoMatch));
                if (score > best) {
                    best = score;
                    nextImg = imageIdIt;
                }
                if (best == target) {
                    break;
                }
            }
        }
        this.totalScore += best;
        return nextImg;
    }

    public List<Slide> solve(final InputData inputData) {
        final List<Slide> slides = new ArrayList<>(inputData.getImageArray().size() / 2);
        Slide prevSlide = new Slide(-1);
        for (Image image : inputData.getImageArray()) {
            if (image.isHorizontal()) {
                prevSlide = new Slide(image.getId());
                break;
            }
        }
        if (prevSlide.getImageIds().get(0) == -1) {
            return slides;
        }
        slides.add(prevSlide);
        inputData.removeSlide(prevSlide);
        while (!inputData.getImageTagMap().isEmpty()) {
            int nextImage = getNextHorizontal(inputData, prevSlide);
            if (nextImage == -1) {
                for (int imageId : inputData.getImageTagMap().keySet()) {
                    if (inputData.getImageArray().get(imageId).isHorizontal()) {
                        nextImage = imageId;
                        break;
                    }
                }
                if (nextImage == -1) {
                    break;
                }
            }
            prevSlide = new Slide(nextImage);
            slides.add(prevSlide);
            inputData.removeSlide(prevSlide);
        }
        System.out.println("score: " + this.totalScore);
        return slides;
    }
}
