package com.ecowishlist.eJournal.service;

import com.ecowishlist.eJournal.entity.JournalEntry;
import com.ecowishlist.eJournal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    JournalEntryRepository repo;

    public void createEntry(JournalEntry journalEntry)
    {
        journalEntry.setDate(LocalDateTime.now());
        repo.save(journalEntry);
    }

    public Optional<JournalEntry> getEntryById(ObjectId id)
    {
        return repo.findById(id);
    }

    public void deleteEntryById(ObjectId id)
    {
        repo.deleteById(id);
    }
    
    public List<JournalEntry> getAllEntries()
    {
        return repo.findAll();
    }

    public void updateEntryById(ObjectId id, JournalEntry updatedEntry)
    {
        Optional<JournalEntry> oldEntry = repo.findById(id);
        if(oldEntry.isPresent())
        {
            updatedEntry.setId(id);
            updatedEntry.setDate(oldEntry.get().getDate());
            if(updatedEntry.getTitle()==null || updatedEntry.getTitle().isEmpty())
                updatedEntry.setTitle(oldEntry.get().getTitle());
            if(updatedEntry.getContent()==null || updatedEntry.getContent().isEmpty())
                updatedEntry.setContent(oldEntry.get().getContent());
        }
        repo.save(updatedEntry);
    }
}
