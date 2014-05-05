package com.excite.atm.transactions;

import com.excite.atm.bo.ATMTransactionBO;
import com.excite.atm.exception.ATMException;

public class ATMTransaction {

	private static ATMTransaction _atmTran = null;
	private ATMTransactionBO objATMTransactionBO;

	public ATMTransaction() throws ATMException {
		// auto initialization of funds at start of ATM transaction
		objATMTransactionBO = init(new ATMTransactionBO());
	}

	public static ATMTransaction getInstance() throws Exception, Exception {
		if (ATMTransaction._atmTran == null) {
			synchronized (ATMTransaction.class) {
				if (ATMTransaction._atmTran == null) {
					ATMTransaction._atmTran = new ATMTransaction();
				}
			}
		}
		return ATMTransaction._atmTran;
	}

	public ATMTransactionBO getObjATMTransactionBO() {
		return objATMTransactionBO;
	}

	public void setObjATMTransactionBO(ATMTransactionBO objATMTransactionBO) {
		this.objATMTransactionBO = objATMTransactionBO;
	}

	public ATMTransactionBO init(ATMTransactionBO objATMTransactionBO)
			throws ATMException {
		// initialize the funds in atm
		try {
			// this.objATMTransactionBO = objATMTransactionBO;
			synchronized (objATMTransactionBO) {
				long[] notes = objATMTransactionBO.getType_of_notes();
				long[] amt = objATMTransactionBO.getAmt_of_notes();
				long value = 0l;
				for (int t = 0; t < notes.length; t++)
					value = value + notes[t] * amt[t];
				objATMTransactionBO.setValue(value);
			}
		} catch (Exception e) {
			throw new ATMException("1003");
		}

		return objATMTransactionBO;
	}

	public ATMTransactionBO deposit() throws ATMException {
		// deposit the funds
		return null;
	}

	public ATMTransactionBO withdraw(long wfunds) throws ATMException {
		// clone the bo for validating funds
		long noteType[] = objATMTransactionBO.getType_of_notes().clone();
		long amtOfNotes[] = objATMTransactionBO.getAmt_of_notes().clone();
		long avblbalance = balance();// total available balance in the ATM
		if (wfunds < avblbalance) {
			long dblBalance = 0;

			for (int t = 0; t < noteType.length; t++) {
				if (wfunds > 0 && wfunds >= noteType[t]) {
					long rmd = wfunds / noteType[t];
					long quo = wfunds % noteType[t];
					if (rmd <= amtOfNotes[t]) {
						amtOfNotes[t] = amtOfNotes[t] - rmd;
						wfunds = quo;
					} else if (rmd > amtOfNotes[t]) {
						rmd = rmd - amtOfNotes[t];
						amtOfNotes[t] = 0;
						wfunds = rmd * noteType[t] + quo;
						// System.out.println("rmd====="+rmd+"wfunds====="+wfunds);
					}
				}
			}
		} else
			throw new ATMException("1005");// insufficient funds in atm

		if (wfunds > 0)
			throw new ATMException("1004");// illegal combinations
		else if (wfunds == 0) {
			// success then commit the changes in the system from clone by
			// re-initialization
			objATMTransactionBO.setType_of_notes(noteType);
			objATMTransactionBO.setAmt_of_notes(amtOfNotes);
			init(objATMTransactionBO);
			System.out.println("Success : "+objATMTransactionBO);
		}
		return objATMTransactionBO;
	}

	public long balance() throws ATMException {
		// balance of ATM
		// System.out.println(objATMTransactionBO);
		return objATMTransactionBO.getValue();
	}
}
