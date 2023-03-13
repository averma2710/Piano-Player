package persisitence;


import model.Progress;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import model.Recorder;
import org.json.*;

//REFERENCE : code below was referred from the following project :
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads Progress from JSON data stored in file
public class  JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Progress from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Progress read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProgress(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Progress from JSON object and returns it
    private Progress parseProgress(JSONObject jsonObject) {
        Progress progress = new Progress();
        addRecorders(progress, jsonObject);
        return progress;
    }

    // MODIFIES: progress
    // EFFECTS: parses Recorder from JSON object and adds them to Progress.
    private void addRecorders(Progress progress, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("songs");
        for (Object json : jsonArray) {
            JSONArray nextThingy = (JSONArray) json;
            addRecord(progress, nextThingy);
        }
    }


    // MODIFIES: progress
    // EFFECTS: parses recorder from JSON object and adds it to progress

    private void addRecord(Progress progress, JSONArray jsonArray) {
        ArrayList<String> records = new ArrayList<>();
        for (Object s : jsonArray) {
            records.add((String) s);
        }
        Recorder r = new Recorder(records);
        progress.addRecording(r);
    }
}

