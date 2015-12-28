package com.kaladivo.aig.images;

import com.kaladivo.aig.loging.Log;
import com.kaladivo.aig.utils.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Generates images in all densities from master image.
 *
 * Created by kaladivo on 27.12.15.
 */
public class ImagesGenerator {
    private final AnalyzedImage analyzedImage;
    private final File outputDir;

    public ImagesGenerator(AnalyzedImage analyzedImage, File outputDir) {
        this.analyzedImage = analyzedImage;
        this.outputDir = outputDir;
    }

    public void generate() throws IOException {
        if(!this.isImageWideEnough()) {
            Log.getLog().print(
                    "Error: Image %s must be at least %s px wide!!",
                    this.analyzedImage.imageFile.getPath(),
                    Density.XXXHDPI.calculatePixels(this.analyzedImage.image.getWidth()));
            return;
        }

        Log.getLog().print("Generating images from %s...", this.analyzedImage.imageFile.getName());

        for(Density density : Density.values()) {
            BufferedImage image = density.produceImage(this.analyzedImage.widthDp, this.analyzedImage.image);
            File imageFile = FileUtils.getFileForResource(this.analyzedImage.imageName, this.analyzedImage.resourceType, density, this.outputDir);
            ImageIO.write(image, this.analyzedImage.formatName, imageFile);
        }

        Log.getLog().print("Images generated.");
    }

    private boolean isImageWideEnough() {
        return this.analyzedImage.image.getWidth() >= Density.XXXHDPI.calculatePixels(this.analyzedImage.widthDp);
    }
}
