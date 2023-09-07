package models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImagesModel {

    private HashMap<String, BufferedImage> allImages = new HashMap<>();

    public ImagesModel() {
        List<String> resources = new ArrayList<>();
        try {
            resources = getResourceFiles(".", ".png");
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("-- Found resources --");
        for(String r: resources) {
            System.out.println(r);
            try {
                allImages.put(r, ImageIO.read(ImagesModel.this.getResourceAsStream(r)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("-- Stored Keys --");
        for(String i: allImages.keySet()) {
            System.out.println(i);
        }

    }

    public ArrayList<String> getKeySet() {
        return new ArrayList<>(allImages.keySet());
    }

    public BufferedImage getValue(String key) {
        if(key == null) {
            return null;
        }

        return allImages.get(key);
    }

    private List<String> getResourceFiles(String path, String extension) throws IOException {
        List<String> filenames = new ArrayList<>();

        BufferedReader br = null;
        try {
            InputStream in = getResourceAsStream(path);
            br = new BufferedReader(new InputStreamReader(in));

            String resource = "";
            while ((resource = br.readLine()) != null) {
                if(resource.endsWith(extension)) {
                    filenames.add(resource);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return filenames;
    }

    private InputStream getResourceAsStream(String resource) {
        InputStream in = null;
        try {
            in = getContextClassLoader().getResourceAsStream(resource);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return in == null ? ImagesModel.this.getResourceAsStream(resource) : in;
    }

    private ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }


}
