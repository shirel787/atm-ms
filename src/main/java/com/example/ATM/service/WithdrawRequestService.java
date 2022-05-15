package com.example.ATM.service;

import com.example.ATM.model.WithdrawRequest;
import com.example.ATM.repository.WithdrawRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawRequestService {

    @Autowired
    WithdrawRequestRepository withdrawRequestRepository;

    public WithdrawRequest saveRequest(WithdrawRequest req)
    {
        return withdrawRequestRepository.save(req);
    }
}
