package com.kaladivo.aig.images;

import com.kaladivo.aig.utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Static class that can analyze images.
 *
 * Created by kaladivo on 27.12.15.
 */
public class ImageAnalyzer {
    private final static String DP_NAME_SPLIT = "-";

    public static AnalyzedImage analyzeImage(File file, String resourceType) {
        if(!FileUtils.isImage(file)) return null;

        int imageDp = getImageDp(file.getName());
        if(imageDp == -1) return null;

        String imageName = getImageName(imageDp, file.getName());
        String imageType = getFormatName(file.getName());
        BufferedImage image = null;

        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            return null;
        }

        return new AnalyzedImage(image, file, imageName, imageDp, resourceType, imageType);

    }

    private static int getImageDp(String fileName) {
        String[] split = fileName.split(DP_NAME_SPLIT);

        String dpStringWithSuffix = split[split.length - 1];
        String dpString = dpStringWithSuffix.split("\\.")[0];

        try {
            int imageDp = Integer.parseInt(dpString);
            return imageDp;
        } catch (NumberFormatException e){
            return -1;
        }
    }

    private static String getImageName(int imageDp, String fileName) {
        return fileName.replace(DP_NAME_SPLIT + imageDp, "");
    }

    private static String getFormatName(String fileName) {
        String[] split = fileName.split("\\.");

        return split[split.length - 1];
    }
}
