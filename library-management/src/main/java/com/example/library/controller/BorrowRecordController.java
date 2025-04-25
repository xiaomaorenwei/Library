package com.example.library.controller;

import com.example.library.model.BorrowRecord;
import com.example.library.service.BorrowRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {
    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }

    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordService.findAllBorrowRecords();
    }

    @GetMapping("/{id}")
    public BorrowRecord getBorrowRecordById(@PathVariable Long id) {
        return borrowRecordService.findBorrowRecordById(id);
    }

    @PostMapping
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        return borrowRecordService.saveBorrowRecord(borrowRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordService.deleteBorrowRecord(id);
    }
}