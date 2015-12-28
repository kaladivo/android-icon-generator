package com.kaladivo.aig.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Contains handy methods for working with images.
 *
 * Created by kaladivo on 27.12.15.
 */
public class ImageUtils {

    public static BufferedImage resizeImage(double scaleFactor, BufferedImage imageToResize) {
        final int newWidth = (int) (imageToResize.getWidth() * scaleFactor);
        final int newHeight = (int) (imageToResize.getHeight() * scaleFactor);

        Image image = imageToResize.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return newImage;
    }
}
