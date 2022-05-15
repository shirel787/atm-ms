package com.example.ATM.controller;

import com.example.ATM.AtmApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AtmApplication.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig
public class WithdrawReqControllerTest {

    @Autowired
    WithdrawReqController  withdrawReqController;

    @Test
    public void checkBlockBigAmount() throws Exception {
        var response=withdrawReqController.checkWithDrawValid("1234",3000.0);
        Assert.assertEquals(response.getBody(), Boolean.FALSE);
    }



}