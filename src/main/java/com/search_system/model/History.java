package com.search_system.model;

import lombok.Data;

import java.util.UUID;

@Data
public class History {
    private UUID id;
    private String name;
    private UUID userId;
}
