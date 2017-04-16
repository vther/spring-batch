/**
 * 
 */
package com.vther.spring.batch.ch07.mail;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.vther.spring.batch.ch07.CreditBill;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author bruce.liu(mailto:jxta.liu@gmail.com)
 * 2013-9-29下午08:15:18
 */
public class MailItemProcessor implements ItemProcessor<CreditBill, SimpleMailMessage> {
	@Override
	public SimpleMailMessage process(CreditBill item) throws Exception {
		SimpleMailMessage msg = new SimpleMailMessage();
	    msg.setFrom("springbatchexample@163.com");
	    msg.setTo("springbatchexample@163.com");
	    msg.setSubject("Credit detail " + 
	    		new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒").
	    		format(Calendar.getInstance().getTime()));
	    msg.setText("Credit details: " + item.toString());
	    return msg;
	}
}
