package com.kaladivo.aig.images;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Represents one master image. {@link ImagesGenerator} uses it to generate various dense images from.
 * <p/>
 * Created by kaladivo on 27.12.15.
 */
public class AnalyzedImage {
    public final BufferedImage image;
    public final File imageFile;
    public final String imageName;
    public final int widthDp;
    public final String resourceType;
    public final String formatName;

    public AnalyzedImage(BufferedImage image, File imageFile, String imageName, int widthDp, String resourceType, String formatName) {
        this.image = image;
        this.imageFile = imageFile;
        this.imageName = imageName;
        this.widthDp = widthDp;
        this.resourceType = resourceType;
        this.formatName = formatName;
    }


}
