package com.exam.Tapcodechallenge.service;

import com.exam.Tapcodechallenge.entity.WhiteListEntry;
import com.exam.Tapcodechallenge.exception.WhiteListEntryNotFoundException;
import com.exam.Tapcodechallenge.repository.ClientRepository;
import com.exam.Tapcodechallenge.repository.WhiteListEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WhiteListEntryServiceImpl implements WhiteListEntryService {


    private final WhiteListEntryRepository entryRepository;

    @Autowired
    public WhiteListEntryServiceImpl(ClientRepository repo, WhiteListEntryRepository entryRepository) {
        this.entryRepository = entryRepository;

    }

    @Override
    public List<WhiteListEntry> getWhiteList() {
        return entryRepository.findAll();
    }

    @Override
    public WhiteListEntry addToWhiteList(WhiteListEntry entry) {
        return entryRepository.save(entry);
    }

    @Override
    public void removeFromWhiteList(Long id) throws WhiteListEntryNotFoundException {
        Optional<WhiteListEntry> entryOptional = entryRepository.findById(id);
        if (entryOptional.isEmpty()) {
            entryRepository.findById(id).stream().filter(entry -> entry.getId() == id);
        } else  entryRepository.delete(entryOptional.get());
    }
}
