package model;
//Stores previously played recordings.

import org.json.JSONArray;
import org.json.JSONObject;
import persisitence.Writable;

import java.util.ArrayList;
//Constructs a progress which contains a list pf recorder.

public class Progress implements Writable {

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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("recorder", "myRecorder");
        json.put("songs", recordersToJson());
        return json;
    }

    private JSONArray recordersToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Recorder r : prev) {
            jsonArray.put(r.getMusic());
        }

        return jsonArray;
    }
}
