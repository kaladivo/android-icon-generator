package com.kaladivo.aig.images;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Analyzes input directory.
 *
 * Created by kaladivo on 27.12.15.
 */
public class InputDirAnalyzer {
    private final static String DIR_POSTFIX = "-res";

    final File inputDirectory;

    public InputDirAnalyzer(File inputDirectory) {
        if(!inputDirectory.isDirectory()) throw new IllegalArgumentException("inputDirectory must be directory!");
        this.inputDirectory = inputDirectory;
    }

    public AnalyzedImage[] analyze() {
        ArrayList<AnalyzedImage> images = new ArrayList<>();

        for(File dir : this.getResDirs()) {
            images.addAll(Arrays.asList(analyzeDirectory(dir)));
        }

        return images.toArray(new AnalyzedImage[images.size()]);
    }

    private AnalyzedImage[] analyzeDirectory(File dir) {
        final String resType = this.getResourceType(dir);
        ArrayList<AnalyzedImage> images = new ArrayList<>();

        for(File f : dir.listFiles()) {
            AnalyzedImage analyzedImage = ImageAnalyzer.analyzeImage(f, resType);
            if(analyzedImage != null) images.add(analyzedImage);
        }

        return images.toArray(new AnalyzedImage[images.size()]);
    }

    private File[] getResDirs() {
        ArrayList<File> result = new ArrayList<>();

        for(File file : inputDirectory.listFiles()) {
            if(isResDir(file)) result.add(file);
        }

        return result.toArray(new File[result.size()]);
    }

    private boolean isResDir(File dir) {
        return dir.isDirectory() && dir.getName().contains(DIR_POSTFIX);
    }

    private String getResourceType(File dir) {
        return dir.getName().replace(DIR_POSTFIX, "");
    }
}
