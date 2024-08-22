package com.restdemo.restdemo.note;

import jakarta.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteManager {
    private static final Map<String, Note> notes = new HashMap<>();

    public static String addNote(String content) {
        Note newNote = new Note(content);

        notes.put(newNote.getId(), newNote);

        return newNote.getId();
    }

    @Nullable
    public static Note getNote(String id) {
        return notes.get(id);
    }

    public static void editContent(String id, String newContent) {
        Note note = notes.get(id);

        if (note != null) {
            note.setContent(newContent);
        }
    }

    public static void deleteNote(String id) {
        notes.remove(id);
    }

    public static List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }

    public static boolean exists(String id) {
        return notes.containsKey(id);
    }
}
