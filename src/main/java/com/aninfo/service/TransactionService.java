package com.aninfo.service;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }
    @Transactional
    public Transaction withdraw(Long cbu, Double sum) {
        Transaction transaction = Transaction.withdraw(cbu, sum);
        return transaction;
    }

    @Transactional
    public Transaction deposit(Long cbu, Double sum) {
        Transaction transaction = Transaction.deposit(cbu, sum);
        return transaction;
    }

    public Collection<Transaction> getTransactions(Long cbu) {
        return transactionRepository.findAllByCbu(cbu);
    }

    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    public Optional<Transaction> deleteTransaction(Long id) {
        Optional<Transaction> transaction = getTransaction(id);
        transactionRepository.deleteById(id);
        return transaction;
    }
}
