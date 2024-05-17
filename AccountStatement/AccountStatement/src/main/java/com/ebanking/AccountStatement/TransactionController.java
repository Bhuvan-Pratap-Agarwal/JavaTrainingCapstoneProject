package com.ebanking.AccountStatement;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{accountId}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long accountId,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        return transactionService.getTransactions(accountId, fromDate, toDate);
    }

    @PostMapping("/account/{accountId}/transactions")
    public Transaction addTransaction(@PathVariable Long accountId, @RequestBody Transaction transaction) {
        transaction.setAccountId(accountId);
        return transactionService.saveTransaction(transaction);
    }
    @GetMapping("/account/{accountId}/transactions/download")
    public ResponseEntity<byte[]> downloadTransactions(@PathVariable Long accountId,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
        transactionService.writeTransactionsToCsv(accountId, fromDate, toDate, writer);
        writer.flush();
        writer.close();

        byte[] bytes = out.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.csv");
        headers.add(HttpHeaders.CONTENT_TYPE, "text/csv; charset=UTF-8");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bytes);
    }

}


