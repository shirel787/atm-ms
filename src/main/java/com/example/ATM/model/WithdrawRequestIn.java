package com.example.ATM.model;


import static com.example.ATM.model.WithdrawRequest.WithdrawRequestBuilder.aWithdrawRequest;

public class WithdrawRequestIn {



    private String cardNumber;
    private String codeNumber;
    private Double amount;


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public  WithdrawRequest toWithdrawRequest() {
        return aWithdrawRequest().amount(amount).cardNumber(cardNumber).codeNumber(codeNumber).build();
    }
}
