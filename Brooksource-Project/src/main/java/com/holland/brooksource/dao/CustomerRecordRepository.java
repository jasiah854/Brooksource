package com.holland.brooksource.dao;

import com.holland.brooksource.entities.CustomerRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRecordRepository extends CrudRepository<CustomerRecord, Integer> {

    List<CustomerRecord> findByAccountNumber(Integer accountNumber);
}
