package net.engineeringdigest.journalApp.service;


import net.engineeringdigest.journalApp.dao.JournalEntry;
import net.engineeringdigest.journalApp.dao.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

// Temporary change for stash demo
  //  Added new UI feature (dummy text for demo)


    @Autowired
    JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journal){
        journalEntryRepo.save(journal);
    }

    public List<JournalEntry> getAll(){
      return  journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId objectId){
        return journalEntryRepo.findById(objectId);

    }

    public boolean deleteById(ObjectId id){
        journalEntryRepo.deleteById(id);
        return true;
    }
}
