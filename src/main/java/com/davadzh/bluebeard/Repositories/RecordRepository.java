package com.davadzh.bluebeard.Repositories;

import com.davadzh.bluebeard.DAL.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
