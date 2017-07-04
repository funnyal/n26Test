package hello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class StatisticCounter implements Serializable {

	private static StatisticCounter instance;
	private static final int SECONDS = 60;
    private double sum = 0;
    private long lastTransactionTime = 0;
   
    private List<Double> values = new ArrayList<>();
    private ConcurrentHashMap<Long, List<Double>> holds =
            new ConcurrentHashMap<>(new HashMap<Long, List<Double>>());
	private double avg = 0;

	private double max = 0;
    private double min = 0;
    private long count = 0;
    private long countHolds = 0;
    
    public static StatisticCounter getInstance(){
    	if (instance == null) {
			instance = new StatisticCounter();
		}

		return instance;
    }
    
    public boolean checkLastTransactionTime(){
    	long time = System.currentTimeMillis();
    	if (( time - lastTransactionTime ) / 3600 > SECONDS && lastTransactionTime != 0){
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public synchronized void addValue(double amount){
    	values.add(amount);
    	holds.put(countHolds, values);
    	countHolds++;
    }
    
    public void clearValues(){
    	values.clear();
    }
    
    public double getSum(){
    	return sum;
    }
    
    public static void setInstance(StatisticCounter instance) {
		StatisticCounter.instance = instance;
	}
    
    public void setAvg() {
		this.avg =  sum / values.size();
	}

	public void setMax(double max) {
		this.max = max;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public StatisticCounter() {
	}

	public double getAvg() {
		return sum / values.size();
	}
	public double getMax() {
		return max;
	}
	public double getMin() {
		return min;
	}

	public void setLastTransactionTime(long lastTransactionTime) {
		this.lastTransactionTime = lastTransactionTime;
	}

	public synchronized StatisticCounter calculate(){
		if(values != null){ 
			this.sum = values.stream().mapToDouble(Double::doubleValue).sum();
			this.avg = (sum / values.size());
			this.max = Collections.max(values);
			this.min = Collections.min(values);
			this.count = (values.size());
		}
		return instance;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
}
