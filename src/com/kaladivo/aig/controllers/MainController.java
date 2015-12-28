package com.kaladivo.aig.controllers;

import com.kaladivo.aig.images.GenerateTask;
import com.kaladivo.aig.loging.Log;
import com.kaladivo.aig.utils.UIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;

import java.io.File;

/**
 *
 * <p/>
 * Created by kaladivo on 27.12.15.
 */
public class MainController implements GenerateTask.Callback{
    @FXML private ListView<String> outputListView;
    @FXML private Text selectedOutputText;
    @FXML private Text selectedInputText;
    @FXML private Button generateButton;
    @FXML private ProgressIndicator progressIndicator;

    private File outputDir;
    private File inputDir;
    private boolean isGenerating = false;


    @FXML
    private void initialize() {
        Log.init(this.outputListView);
        UIUtils.addAutoScroll(this.outputListView);
        Log.getLog().print("Welcome to the Android Icon Generator");
    }

    @FXML
    private void onSelectOutput() {
        this.outputDir = UIUtils.letUserSelectDir();
        this.selectedOutputText.setText(this.outputDir.getName());
    }

    @FXML
    private void onSelectInput() {
        this.inputDir = UIUtils.letUserSelectDir();
        this.selectedInputText.setText(this.inputDir.getName());
    }

    @FXML
    private void onGenerate() {
        if(isGenerating) return;
        Log.getLog().clear();


        if(!checkIfEverythingIsFilled()) {
            notifyUserToFillWhatsNot();
            return;
        }

        this.isGenerating = true;
        this.updateUIGenerating(true);

        GenerateTask task = new GenerateTask(this.inputDir, this.outputDir, this);
        task.execute();
    }

    @Override
    public void onGenerateTaskDone() {
        this.isGenerating = false;
        this.updateUIGenerating(false);
    }

    private void notifyUserToFillWhatsNot() {
        if(this.outputDir == null) Log.getLog().print("Please select output directory");
        if(this.inputDir == null) Log.getLog().print("Please select input directory");
    }

    private boolean checkIfEverythingIsFilled() {
        return this.outputDir != null && this.inputDir != null;
    }

    private void updateUIGenerating(boolean isGenerating) {
        if(isGenerating) {
            this.generateButton.setVisible(false);
            this.progressIndicator.setVisible(true);
        } else {
            this.generateButton.setVisible(true);
            this.progressIndicator.setVisible(false);
        }
    }
}
