package com.parth_collab.document_service.repository;



import com.parth_collab.document_service.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DocumentRepository extends MongoRepository<UserDocument, String> {
    List<UserDocument> findByOwnerId(String ownerId);
}

