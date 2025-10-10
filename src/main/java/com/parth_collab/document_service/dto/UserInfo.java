package com.parth_collab.document_service.dto;


import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
}

