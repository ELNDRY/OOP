package ru.nsu.yadryshnikova;

public class Note {
    String title;
    String contents;
    Note(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Note))
            return false;

        Note objNote = (Note) obj;
        return objNote.title.equals(this.title) && objNote.contents.equals(this.contents);
    }
}
