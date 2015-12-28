package com.kaladivo.aig.utils;

import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Contains handy methods that can help while working with user interface.
 *
 * Created by kaladivo on 27.12.15.
 */
public class UIUtils {

    /**
     * Creates a system file chooser. Returns chosen file.
     * @return Directory that user chose.
     */
    public static File letUserSelectDir() {
        DirectoryChooser chooser = new DirectoryChooser();
        return chooser.showDialog(new Stage());
    }

    /**
     * Makes ListView scroll on the bottom element when added.
     * @param view
     * @param <S>
     */
    public static <S> void addAutoScroll(final ListView<S> view) {
        if (view == null) {
            throw new NullPointerException();
        }

        view.getItems().addListener((ListChangeListener<S>) (c -> {
            c.next();
            final int size = view.getItems().size();
            if (size > 0) {
                view.scrollTo(size - 1);
            }
        }));
    }
}
