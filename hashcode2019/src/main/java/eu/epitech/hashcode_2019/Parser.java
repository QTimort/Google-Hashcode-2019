package eu.epitech.hashcode_2019;

import com.google.common.collect.HashBiMap;
import eu.epitech.hashcode_2019.model.Image;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;


public class Parser {

    public static void parse(final File file) {
        Parser.parse(file.getAbsolutePath());
    }

    public static void parse(final InputStream inputStream) {
        Parser.parse(new Scanner(inputStream));
    }

    public static void parse(final String content) {
        Parser.parse(new Scanner(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))));
    }

    public static void parse(final Scanner scanner) {
        try (final Scanner ignored = scanner) {
            final int nbImages = scanner.nextInt();
            Dictionnary.images = new Image[nbImages];
            Dictionnary.tags = HashBiMap.create(nbImages);
            Dictionnary.tagImages = new HashMap<>(nbImages);
            scanner.nextLine();
            for (int i = 0; i < nbImages; ++i) {
                final String[] s = scanner.nextLine().split(" ");
                final Image image = new Image();
                image.setHorizontal(s[0].equals("H"));
                image.setId(i);
                Dictionnary.images[i] = image;
                final int nbTags = Integer.parseInt(s[1]);
                image.setTags(new int[nbTags]);
                for (int j = 0; j < nbTags; ++j) {
                    image.getTags()[j] = Dictionnary.addTagOp(i, s[2 + j]);
                }
            }
        }
    }
}
