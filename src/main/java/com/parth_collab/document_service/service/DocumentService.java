package com.parth_collab.document_service.service;

import com.parth_collab.document_service.model.UserDocument;
import com.parth_collab.document_service.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository repo;

    public DocumentService(DocumentRepository repo) {
        this.repo = repo;
    }

    public UserDocument createDocument(UserDocument doc) {
        doc.setCreatedAt(new Date());
        doc.setUpdatedAt(new Date());
        return repo.save(doc);
    }

    public List<UserDocument> getAllDocumentsByOwner(String ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    public UserDocument getDocumentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public UserDocument updateDocument(String id, UserDocument updated) {
        return repo.findById(id).map(doc -> {
            doc.setTitle(updated.getTitle());
            doc.setContent(updated.getContent());
            doc.setUpdatedAt(new Date());
            return repo.save(doc);
        }).orElse(null);
    }

    public void deleteDocument(String id) {
        repo.deleteById(id);
    }
}
