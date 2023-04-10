package com.holland.brooksource.api;
import com.holland.brooksource.dao.CustomerRecordRepository;
import com.holland.brooksource.entities.CustomerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CustomerRewardsRestAPI {
    @Autowired
    CustomerRecordRepository recordRepo;

    @GetMapping("/add-points/{id}/{amount}")
    public String addPointsById(@PathVariable("id") Integer id, @PathVariable("amount") double amount) {
        try {
            CustomerRecord record = new CustomerRecord(id, amount);
            System.out.println("id: " + id + "& purchase amount: " + amount);
            recordRepo.save(record);
        }catch (Exception x){
            return "Error processing records";
        }
        return  "record saved!";
    }

    @GetMapping("/points/{id}")
    public String currentPointsById(@PathVariable("id") Integer id){
       AtomicInteger points = new AtomicInteger();
        System.out.println("id = " + id);
        List<CustomerRecord> records = recordRepo.findByAccountNumber(id);
        System.out.println("the records = " + records.toString());
        records.forEach(record -> {
            int purchase = record.getPurchaseAmount().intValue();
            int amt = 0;
            if ( purchase > 50 && purchase < 100) {
                amt += (purchase - 50);
            } else if (purchase > 100) {
                amt += 50 + (purchase - 100) * 2;
            }
            points.addAndGet(amt);
        });
        System.out.println("current points : " + points.get());
        return "current points : " + points.get();
    }


}
