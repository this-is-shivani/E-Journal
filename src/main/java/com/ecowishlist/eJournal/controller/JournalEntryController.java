package com.ecowishlist.eJournal.controller;

import com.ecowishlist.eJournal.entity.JournalEntry;
import com.ecowishlist.eJournal.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService service;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllEntries()
    {
        List<JournalEntry> entries = service.getAllEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("id/{varId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable("varId") ObjectId id)
    {
        Optional<JournalEntry> entry = service.getEntryById(id);
        if(entry.isPresent())
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{varId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable("varId") ObjectId id)
    {
        service.deleteEntryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry entry)
    {
        service.createEntry(entry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("id/{varId}")
    public ResponseEntity<?> updateEntryById(@PathVariable("varId") ObjectId id, @RequestBody JournalEntry entryUpdate)
    {
        service.updateEntryById(id, entryUpdate);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
