package com.exam.Tapcodechallenge.repository;

import com.exam.Tapcodechallenge.entity.WhiteListEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiteListEntryRepository extends JpaRepository<WhiteListEntry, Long> {
}
