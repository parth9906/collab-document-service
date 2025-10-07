package com.parth_collab.document_service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "documents")
public class UserDocument {
    @Id
    private String id;
    private String title;
    private String content;
    private String ownerId;
    private List<String> collaborators;
    private Date createdAt;
    private Date updatedAt;
}

