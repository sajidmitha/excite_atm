package com.excite.atm.bo;

public class ATMTransactionBO {

	private long type_of_notes[] = { 100, 50, 20 };
	private long amt_of_notes[] = { 10, 5, 15 };
	private long value;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long[] getType_of_notes() {
		return type_of_notes;
	}

	public void setType_of_notes(long[] type_of_notes) {
		this.type_of_notes = type_of_notes;
	}

	public long[] getAmt_of_notes() {
		return amt_of_notes;
	}

	public void setAmt_of_notes(long[] amt_of_notes) {
		this.amt_of_notes = amt_of_notes;
	}

	public long getAmtOfNote(long notetype) {
		long count = 0;
		for (int t = 0; t < type_of_notes.length; t++) {
			if (notetype == type_of_notes[t])
				count = amt_of_notes[t];
		}
		return count;
	}

	public long setAmtOfNote(int notetype, int amt) {
		int count = -1;// failure
		for (int t = 0; t < type_of_notes.length; t++) {
			if (notetype == type_of_notes[t]) {
				amt_of_notes[t] = amt;
				count = 1;// success
			}
		}
		return count;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("type_of_notes: " + type_of_notes[0] + "/" + type_of_notes[1]
				+ "/" + type_of_notes[2]);
		sb.append(",");
		sb.append("amt_of_notes: " + amt_of_notes[0] + "/" + amt_of_notes[1]
				+ "/" + amt_of_notes[2]);
		sb.append(",");
		sb.append("value : " + value);
		return sb.toString();

	}
}
