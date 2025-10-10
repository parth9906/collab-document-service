package com.parth_collab.document_service.controller;

import com.parth_collab.document_service.model.UserDocument;
import com.parth_collab.document_service.service.DocumentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {
    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<UserDocument> create(@RequestBody UserDocument doc, @RequestHeader("X-User-Id") String userId) {
        doc.setOwnerId(userId);

        return ResponseEntity.ok(service.createDocument(doc));
    }

    @GetMapping("/owner/me")
    public ResponseEntity<List<UserDocument>> getMyDocuments(HttpServletRequest request, @RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(service.getAllDocumentsByOwner(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDocument> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getDocumentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDocument> update(@PathVariable String id, @RequestBody UserDocument doc) {
        return ResponseEntity.ok(service.updateDocument(id, doc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
