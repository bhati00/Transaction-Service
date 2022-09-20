package Transaction.Transactionservice.controller;

import Transaction.Transactionservice.modal.Transaction;
import Transaction.Transactionservice.repository.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class TransactionController {
    @Autowired
    public JpaRepo trascRepo;

    @PostMapping (value = "/create")
    public ResponseEntity createTransaction(@RequestBody Transaction transaction){
         LocalDateTime createAt = LocalDateTime.now();
         transaction.setCreateAt(createAt);
         trascRepo.save(transaction);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    // TransactionDetails for userId
    @GetMapping(value = "/TransactionDetailsUser/{userId}")
    public List<String> getTransactionDetailsForUser(@PathVariable("userId") int userId){

        List<Transaction> trasactionsDetails = trascRepo.findAllById(Collections.singleton(userId));
        if(trasactionsDetails==null){
            ResponseEntity.notFound().header("person not fund");
            return null;
        }
        List<String> totalTransaction = new ArrayList<>();

        for(Transaction trasactionsDetail:trasactionsDetails){
            String detail = String.valueOf(trasactionsDetail.getTranscId())+String.valueOf((trasactionsDetail.getMerchantId()));
            detail+=String.valueOf(trasactionsDetail.getUserId())+String.valueOf(trasactionsDetail.getClientReferenceId());
            totalTransaction.add(detail);
        }
        ResponseEntity.accepted().header("Transaction Details");
        return totalTransaction;
    }

    //TrsactionsDetails for merchantId
    @GetMapping(value = "/TransactionDetailsMerchant/{merchantId}")
    public List<String> getTransactionDetailsForMerchant(@PathVariable("merchantId") int merchantId){

        List<Transaction> trasactionsDetails = trascRepo.findAllById(Collections.singleton(merchantId));
        if(trasactionsDetails==null){
            ResponseEntity.notFound().header("person not fund");
            return null;
        }
        List<String> totalTransaction = new ArrayList<>();

        for(Transaction trasactionsDetail:trasactionsDetails){
            String detail = String.valueOf(trasactionsDetail.getTranscId())+String.valueOf((trasactionsDetail.getMerchantId()));
            detail+=String.valueOf(trasactionsDetail.getUserId())+String.valueOf(trasactionsDetail.getClientReferenceId());
            totalTransaction.add(detail);
        }
        ResponseEntity.accepted().header("Transaction Details");
        return totalTransaction;
    }

    //Transactions details by transaction Id
    @GetMapping(value = "/TransactionDetails/{transcId}")
    public String getTransactionDetailsBYTransactionId(@PathVariable("transcId") int transcId){
        Transaction trasactionsDetail = trascRepo.findById(transcId).get();
        String detail = String.valueOf(trasactionsDetail.getTranscId())+String.valueOf((trasactionsDetail.getMerchantId()));
        detail+=String.valueOf(trasactionsDetail.getUserId())+String.valueOf(trasactionsDetail.getClientReferenceId());
        return detail;
    }
}
