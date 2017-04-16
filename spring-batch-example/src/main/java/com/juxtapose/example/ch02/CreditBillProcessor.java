package com.juxtapose.example.ch02;

import org.springframework.batch.item.ItemProcessor;


public class CreditBillProcessor implements ItemProcessor<CreditBill, CreditBill> {

    public CreditBill process(CreditBill bill) throws Exception {
        System.out.println("CreditBillProcessor ----> " + bill.toString());
        return bill;
    }
}
