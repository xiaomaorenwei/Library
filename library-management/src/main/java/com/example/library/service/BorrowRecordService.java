package com.example.library.service;

import com.example.library.model.BorrowRecord;
import com.example.library.repository.BorrowRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordService {
    private final BorrowRecordRepository borrowRecordRepository;

    public BorrowRecordService(BorrowRecordRepository borrowRecordRepository) {
        this.borrowRecordRepository = borrowRecordRepository;
    }

    public List<BorrowRecord> findAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }
    
    public BorrowRecord findBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id).orElse(null);
    }
    
    public BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }
    
    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.deleteById(id);
    }
    
    public BorrowRecord updateBorrowRecord(Long id, BorrowRecord borrowRecordDetails) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
        if (borrowRecord != null) {
            borrowRecord.setBook(borrowRecordDetails.getBook());
            borrowRecord.setUser(borrowRecordDetails.getUser());
            borrowRecord.setBorrowDate(borrowRecordDetails.getBorrowDate());
            borrowRecord.setReturnDate(borrowRecordDetails.getReturnDate());
            borrowRecord.setReturned(borrowRecordDetails.isReturned());
            return borrowRecordRepository.save(borrowRecord);
        }
        return null;
    }
    
    public BorrowRecord returnBook(Long id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
        if (borrowRecord != null) {
            borrowRecord.setReturned(true);
            borrowRecord.setReturnDate(LocalDate.now());
            return borrowRecordRepository.save(borrowRecord);
        }
        return null;
    }

    public BorrowRecord findBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id).orElse(null);
    }

    public BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }

    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.deleteById(id);
    }
}