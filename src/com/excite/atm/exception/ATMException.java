package com.excite.atm.exception;

public class ATMException extends Exception 
{
		String errCode=null;
		String errMsg=null;
		Exception ex;
		
		/********************************************************************************/
		/**
		Description:    Default Constructor - used when the cause of the error unknown. 
		                User Sees an 'Application Error' message in such cases.
		@param:         None
	 	@return:	      None
		@exception:     None
		@see
		**/
		/*********************************************************************************/
		public ATMException()
		{
			super("1001");
			this.errCode = "10001";
			this.errMsg=""+getErrorMessage(Integer.parseInt(errCode));
		}
		/********************************************************************************/
		/**
		Description:    Default Constructor - used when the cause of the error unknown. 
		                User Sees an 'Application Error' message in such cases.
		@param:         None
	 	@return:	      None
		@exception:     None
		@see
		**/
		/*********************************************************************************/
		public ATMException(String eCode)
		{
			super(eCode);
			this.errCode = eCode;
			this.errMsg=""+getErrorMessage(Integer.parseInt(errCode));			
		}
		/********************************************************************************/
		
		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
		
		
		public String getErrorMessage(int eCode)
		{
			String eMsg="General Exception...";
			switch(eCode)
			{
			case 1001:
				eMsg="General Exception";
				break;
			case 1003:
				eMsg="Initialisation Exception";
				break;
			case 1004:
				eMsg="Illegal combinations of notes.";
				break;
			case 1005:
				eMsg="Insufficient balance in the ATM";
				break;
			}
			return eMsg;
		}

}
