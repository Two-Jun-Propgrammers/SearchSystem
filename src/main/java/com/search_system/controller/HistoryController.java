package com.search_system.controller;

import com.search_system.model.History;
import com.search_system.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/history")
public class HistoryController {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryController(HistoryRepository historyRepository){
        this.historyRepository = historyRepository;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<History>> search(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "login") String login) {
        final List<History> histories = historyRepository.search(name, login);

        return histories != null && !histories.isEmpty()
                ? new ResponseEntity<>(histories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addHistory(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "login") String login) {
        final boolean created = historyRepository.create(name, login);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
