import com.google.gson.*;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Notebook {

    private final List<Note> notes;
    private final Gson gsonData;
    String notesFile = "MyNotes.json";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Notebook() {
        notes = new ArrayList<>();
        gsonData = new GsonBuilder().setPrettyPrinting().create();
    }

    public void add(String text) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String date = currentDateTime.format(formatter);
        Note newNote = new Note(date, text);
        notes.add(newNote);
    }

    public void remove(String text) {
        notes.removeIf(note -> Objects.equals(note.getText(), text));
    }

    public List<Note> show() {
        return notes.stream().toList();
    }

    /* public String show(Date or LocalDateTime? since, Date or LocalDateTime till?, String keyWords) throws IOException {
        LocalDateTime date;
        List<Note> results = new ArrayList<>();

        It should be divided into keyWords. Then search for everything at once or by the presence of at least one?

        for (Note note: notes) {
            date = LocalDateTime.parse(note.getTime(), formatter);
            String text = note.getText();

            //isAfter > Note date > isBefore AND Note text including keyWord(s)

            if((date.isAfter(since))  && (date.isBefore(till)) && (text.contains(1)) && (text.contains(2))...) {
                results.add(note);
            }
        }
        try (Writer writer = new FileWriter(notesFile)) {
            Json(results, writer);
        }
       should return Json(results);
    } */
}