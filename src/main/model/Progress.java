package model;
//Stores previously played recordings.

import java.util.ArrayList;
//Constructs a progress which contains a list pf recorder.

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


