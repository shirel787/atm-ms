package com.example.ATM.controller;

import com.example.ATM.model.WithdrawRequest;
import com.example.ATM.model.WithdrawRequestIn;
import com.example.ATM.repository.WithdrawRequestRepository;
import com.example.ATM.service.WithdrawRequestService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class WithdrawReqController {

    @Autowired
    WithdrawRequestService withdrawReqService;
    @Autowired
    WithdrawRequestRepository withdrawReqRepository;

    @RequestMapping(value = "/validateWithdraw", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkWithDrawValid(@RequestParam String cardNumber,@RequestParam Double amount) {
        var withdras=withdrawReqRepository.findByCardNumberAndRequestDate(cardNumber, DateUtils.truncate(new Date(), Calendar.DATE));
        var sum =withdras.stream().mapToDouble(r-> r.getAmount()).sum();
        if (sum + amount.doubleValue()> 2000 || withdras.size()>=5) {
           return new ResponseEntity<>(false,HttpStatus.OK);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }


}
