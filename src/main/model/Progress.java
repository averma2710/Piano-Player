package model;

import java.util.ArrayList;

public class Progress {

    ArrayList<Recorder> prev = new ArrayList<>();

    public Progress() {
    }
    //EFFECTS: Adds a recorder to prev.
    //MODIFIES: this

    public void addRecording(Recorder prevRecording) {
        prev.add(prevRecording);
    }
    //EFFECTS: returns prev the list of recorders.

    public ArrayList getRecordings() {
        return prev;
    }
    //EFFECTS: returns recorder at index i in the list prev.

    public Recorder getRecorder(int i) {
        return prev.get(i);
    }
}


