package com.exam.Tapcodechallenge.controller;

import com.exam.Tapcodechallenge.entity.WhiteListEntry;
import com.exam.Tapcodechallenge.exception.WhiteListEntryNotFoundException;
import com.exam.Tapcodechallenge.service.WhiteListEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whitelist")
public class WhiteListEntryController {

    private final WhiteListEntryService service;

    @Autowired
    public WhiteListEntryController(WhiteListEntryService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<WhiteListEntry>> getWhiteList(
            @RequestParam(required = false) String environment,
            @RequestParam(required = false) String application,
            @RequestParam(required = false) String clientName
    ) {
        List<WhiteListEntry> clientList = service.getWhiteList();
        return new ResponseEntity<List<WhiteListEntry>>(clientList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addToWhiteList(@RequestBody WhiteListEntry whiteListEntry) {
         service.addToWhiteList(whiteListEntry);
         return ResponseEntity.status(HttpStatus.CREATED).body("IP added to whitelist");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) throws WhiteListEntryNotFoundException {
        service.removeFromWhiteList(id);
        return new ResponseEntity<>("IP removed from whitelist", HttpStatus.OK);
    }
}
