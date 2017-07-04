package model;

import java.io.Serializable;

public class Statistic implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  double amount;
    private long timestamp;
    
    public Statistic(){}
	
	public Statistic( double amount, long timeStamp) {
		super();
		this.amount = amount;
		this.timestamp = timeStamp;
	}

	public long getTimeStamp() {
		return timestamp;
	}

	public double getAmount() {
		return amount;
	}
}
