package com.davadzh.bluebeard.DAL.Record;

import com.davadzh.bluebeard.DAL.Record.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
