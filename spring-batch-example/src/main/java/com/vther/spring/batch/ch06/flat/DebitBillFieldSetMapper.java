
package com.vther.spring.batch.ch06.flat;

import com.vther.spring.batch.ch06.DebitBill;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 *
 * 2013-4-6上午07:13:55
 */
public class DebitBillFieldSetMapper implements FieldSetMapper<DebitBill> {

	public DebitBill mapFieldSet(FieldSet fieldSet) throws BindException {
		DebitBill result = new DebitBill();
		result.setAccountID(fieldSet.readString("accountID"));
		result.setName(fieldSet.readString("name"));
		result.setAmount(fieldSet.readDouble("amount"));
		result.setDate(fieldSet.readString("date"));
		return result;
	}
}
