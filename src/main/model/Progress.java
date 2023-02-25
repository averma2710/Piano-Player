package model;

import java.util.ArrayList;

public class Progress {

    ArrayList<Recorder> prev = new ArrayList<>();

    public Progress() {
    }

    public void addRecording(Recorder prevRecording) {
        prev.add(prevRecording);
    }

    public ArrayList getRecordings() {
        return prev;
    }

    public Recorder getRecorder(int i) {
        return prev.get(i);
    }
}


