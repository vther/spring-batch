package com.vther.spring.batch.ch11.multithread;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

/**
 * 2013-11-17上午07:36:36
 */
public class CreditBillProcessor implements ItemProcessor<CreditBill, DestinationCreditBill> {
    private JdbcTemplate jdbcTemplate = null;

    public DestinationCreditBill process(CreditBill bill) throws Exception {
        System.out.println(bill.toString());
        System.out.println("Job Process Thread name: " + Thread.currentThread().getName());
        DestinationCreditBill destCreditBill = new DestinationCreditBill();
        destCreditBill.setAccountID(bill.getAccountID());
        destCreditBill.setAddress(bill.getAddress());
        destCreditBill.setAmount(bill.getAmount());
        destCreditBill.setDate(bill.getDate());
        destCreditBill.setId(UUID.randomUUID().toString() + "::" + bill.getId());
        destCreditBill.setName(bill.getName());
        if (null != jdbcTemplate) {
            jdbcTemplate.update("update t_credit set flag=? where id=?", "true", bill.getId());
        }
        return destCreditBill;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
