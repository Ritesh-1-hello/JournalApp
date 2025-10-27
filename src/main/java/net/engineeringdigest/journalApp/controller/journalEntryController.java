package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.dao.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/journal")
public class journalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @PostMapping("/addJournal")
    public ResponseEntity<JournalEntry> createJournal(@RequestBody JournalEntry journalEntry){
        try {
                journalEntry.setDate(LocalDateTime.now());
                journalEntryService.saveEntry(journalEntry);
                return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/allJournals")
    public ResponseEntity<List<JournalEntry>> getAll(){


        System.out.println("Auth module started");
        System.out.println("Token validation feature");
        
        System.out.println("Added user login feature");
      return  new ResponseEntity<>(journalEntryService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<JournalEntry>> getById(@PathVariable ObjectId id){
        Optional<JournalEntry> journalEntry =   journalEntryService.getById(id);
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(journalEntry,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/getById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id){
        try {
            journalEntryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
