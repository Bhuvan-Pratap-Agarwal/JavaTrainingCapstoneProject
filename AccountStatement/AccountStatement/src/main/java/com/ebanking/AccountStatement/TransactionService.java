package com.ebanking.AccountStatement;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactions(Long accountId, Date fromDate, Date toDate) {
        return transactionRepository.findByAccountIdAndTransactionDateBetween(accountId, fromDate, toDate);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public void writeTransactionsToCsv(Long accountId, Date fromDate, Date toDate, PrintWriter writer) {
        List<Transaction> transactions = getTransactions(accountId, fromDate, toDate);
        writer.println("Id,AccountId,TransactionDate,Description,Amount");
        for (Transaction transaction : transactions) {
            writer.println(transaction.getId() + "," + transaction.getAccountId() + "," + transaction.getTransactionDate() + "," + transaction.getDescription() + "," + transaction.getAmount());
        }
    }
}

