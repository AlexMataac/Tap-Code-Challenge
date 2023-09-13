package com.exam.Tapcodechallenge.service;

import com.exam.Tapcodechallenge.entity.WhiteListEntry;
import com.exam.Tapcodechallenge.exception.WhiteListEntryNotFoundException;

import java.util.List;

public interface WhiteListEntryService {
    List<WhiteListEntry> getWhiteList();

    WhiteListEntry addToWhiteList(WhiteListEntry entry);

    void removeFromWhiteList(Long id) throws WhiteListEntryNotFoundException;
}
