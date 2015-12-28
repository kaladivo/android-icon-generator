package com.kaladivo.aig.images;

import com.kaladivo.aig.loging.Log;
import com.sun.istack.internal.NotNull;
import javafx.application.Platform;

import java.io.File;
import java.io.IOException;

/**
 * Simple task that analyzes the inputs and generates the outputs.
 *
 * Created by kaladivo on 28.12.15.
 */
public class GenerateTask implements Runnable{
    private final File inputDir;
    private final File outputDir;
    private final Callback callback;

    public GenerateTask(@NotNull File inputDir, @NotNull File outputDir, Callback callback) {
        if(inputDir == null || outputDir == null) throw new IllegalArgumentException("Argument's must not be null!");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.callback = callback;
    }

    @Override
    public void run() {
        Log.getLog().print("Analyzing inputs");

        InputDirAnalyzer analyzer = new InputDirAnalyzer(this.inputDir);
        AnalyzedImage[] analyzedImages = analyzer.analyze();

        Log.getLog().print("Inputs analyzed");

        Log.getLog().print("Generating outputs from %d image/s", analyzedImages.length);

        for(AnalyzedImage image : analyzedImages) {
            ImagesGenerator generator = new ImagesGenerator(image, outputDir);
            try {
                generator.generate();
            } catch (IOException e) {
                Log.getLog().print("Unable to generate image %s", image.imageFile.getPath());
            }
        }

        Log.getLog().print("Generating done");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                GenerateTask.this.callback.onGenerateTaskDone();
            }
        });
    }

    public void execute() {
        new Thread(this).start();
    }

    public interface Callback {
        void onGenerateTaskDone();
    }
}
