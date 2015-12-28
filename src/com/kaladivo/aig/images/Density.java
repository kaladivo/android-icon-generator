package com.kaladivo.aig.images;

import com.kaladivo.aig.utils.ImageUtils;

import java.awt.image.BufferedImage;

/**
 * Enum of various screen densities.
 *
 * Created by kaladivo on 27.12.15.
 */
public enum Density {
    LDPI (120), MDPI(160), HDPI(240), XHDPI(320), XXHDPI(420), XXXHDPI(640);

    public final int dpi;

    Density(int dpi) {
        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public int calculatePixels(int dp) {
        return (int) (dp * ((double) this.dpi / 160));
    }

    public BufferedImage produceImage(int widthDp, BufferedImage original) {
        final double scale = (double) this.calculatePixels(widthDp) / original.getWidth();

        return ImageUtils.resizeImage(scale, original);
    }
}
