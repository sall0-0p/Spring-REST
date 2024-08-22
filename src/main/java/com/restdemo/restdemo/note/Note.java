package com.restdemo.restdemo.note;

public class Note {
    private final String id;
    private String content;

    public Note(String content) {
        this.id = generateId();
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String generateId() {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < 7) {
            result.append(Math.round(Math.random() * 10));
            i++;
        }

        if (!NoteManager.exists(result.toString())) {
            return result.toString();
        } else {
            return generateId();
        }
    }
}
