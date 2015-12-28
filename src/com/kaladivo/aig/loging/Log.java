package com.kaladivo.aig.loging;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.ArrayList;

/**
 * Take care of logging to UI. Is thread safe.
 *
 * Created by kaladivo on 27.12.15.
 */
public class Log {
    private final ObservableList<String> logList;

    private Log(ListView<String> listView) {
        this.logList = new ObservableListWrapper<String>(new ArrayList<String>());
        listView.setItems(this.logList);
    }

    public void print(String message, Object ... args) {
        if(Platform.isFxApplicationThread()) this.logList.add(String.format(message, args));
        else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Log.getLog().print(message, args);
                }
            });
        }
    }

    public synchronized void clear() {
        if(Platform.isFxApplicationThread()) this.logList.clear();
        else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Log.getLog().clear();
                }
            });
        }
    }

    private static Log log;

    public static void init(ListView<String> list) {
        Log.log = new Log(list);
    }

    public static Log getLog() {
        if(Log.log == null) throw new IllegalStateException("Log must be initialized first. See Log#init()");
        return Log.log;
    }
}
