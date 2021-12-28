package ru.nsu.yadryshnikova;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Multimaps;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;


public class NoteBook {

    public static class NoteBookSerializer implements JsonSerializer<NoteBook> {
        @Override
        public JsonElement serialize(NoteBook src, Type typeOfSrc, JsonSerializationContext context) {
            return context.serialize(src.getNotes().asMap());
        }
    }

    public static class NotebookDeserializer implements JsonDeserializer<NoteBook> {
        @Override
        public NoteBook deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            Type noteMapType = new TypeToken<Map<LocalDateTime, Collection<Note>>>() {}.getType();
            Map<LocalDateTime, Collection<Note>> noteMap = context.deserialize(json, noteMapType);
            NoteBook notebook = new NoteBook();
            for (var entry : noteMap.entrySet()) {
                notebook.notes.putAll(entry.getKey(), entry.getValue());
            }
            return notebook;
        }
    }

    private Multimap<LocalDateTime, Note> notes;

    public NoteBook() {
        notes = MultimapBuilder.treeKeys().linkedListValues().build();
    }

    public void addNote(String noteTitle, String noteContents) {
        addNote(noteTitle, noteContents, LocalDateTime.now());
    }

    public void addNote(String noteTitle, String noteContents, LocalDateTime date) {
        notes.put(date, new Note(noteTitle, noteContents));
    }

    public void removeNote(String noteTitle) {
        for (var entry : notes.entries()) {
            LocalDateTime date = entry.getKey();
            Note note = entry.getValue();
            if (noteTitle.equals(note.title)) {
                notes.remove(date, note);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Could not find note with title '%s'", noteTitle));
    }

    public Multimap<LocalDateTime, Note> getNotes() {
        return MultimapBuilder.treeKeys().linkedListValues().build(notes);
    }

    public Multimap<LocalDateTime, Note> getNotes(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return Multimaps.filterEntries(notes, (entry) -> {
            LocalDateTime date = entry.getKey();
            return !date.isBefore(dateFrom) && date.isBefore(dateTo);
        });
    }

    public Multimap<LocalDateTime, Note> getNotes(
            LocalDateTime dateFrom,
            LocalDateTime dateTo,
            Collection<String> keywords
    ) {
        return Multimaps.filterEntries(getNotes(dateFrom, dateTo), (entry) -> {
            Note note = entry.getValue();
            return keywords.stream().anyMatch(kw -> note.title.contains(kw));
        });
    }

}
