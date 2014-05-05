package com.excite.atm.test;

 import org.junit.Test;

import com.excite.atm.bo.ATMTransactionBO;
import com.excite.atm.main.ATMMain;
import com.excite.atm.transactions.ATMTransaction;

import static org.junit.Assert.assertEquals;
public class TestWithdraw {
	
   
   @Test
   public void testPrintMessage() {
      ATMTransaction objTran;
	try 
	{
		objTran = ATMTransaction.getInstance();
		long type_of_notes[] = {100,50,20};
		long amt_of_notes[] = {1,1,1};
		ATMTransactionBO objATMTransactionBO = new ATMTransactionBO();
		objATMTransactionBO.setType_of_notes(type_of_notes);
		objATMTransactionBO.setAmt_of_notes(amt_of_notes);
		objTran.setObjATMTransactionBO(objATMTransactionBO);
		objTran.init(objATMTransactionBO);
		//System.out.println("Test withdrawl");
		assertEquals(70,objTran.withdraw(100).getValue());
	} 
	catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception in withdrawl"+e);
		e.printStackTrace();
	}
	  
      
   }
}