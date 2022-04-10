package com.search_system.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String login;
    private String password;
    private UUID roleId;
}
