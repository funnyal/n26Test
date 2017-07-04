package service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import model.Statistic;

@Component
public interface N26Service {

	/**
	 * Adds a new transaction
	 * @param The new transaction to be added
	 */
	public ResponseEntity<?> transaction(Statistic statistic);
	
	/**
	 * Returns the statistics of the last 60s of inserted transactions
	 * @return last 60s statistics
	 */
	public Statistic statistic();
	
}
