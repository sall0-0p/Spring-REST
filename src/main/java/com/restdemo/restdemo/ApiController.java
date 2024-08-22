package com.restdemo.restdemo;

import com.restdemo.restdemo.note.Note;
import com.restdemo.restdemo.note.NoteManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/note/{id}")
    public Note getNote(@PathVariable String id) {
        return NoteManager.getNote(id);
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return NoteManager.getAllNotes();
    }

    @PostMapping("/note/{id}")
    public void editContent(@PathVariable String id, @RequestBody String content) {
        NoteManager.editContent(id, content);
    }

    @PostMapping("/note")
    public String createNote(@RequestBody String content) {
        return NoteManager.addNote(content);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable String id) {
        NoteManager.deleteNote(id);
    }
}
