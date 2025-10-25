package net.engineeringdigest.journalApp.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {

}
