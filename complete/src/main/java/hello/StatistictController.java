package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exceptions.OlderTransactionException;
import model.Statistic;

@RestController
public class StatistictController {

    private static StatisticCounter statisticCounter = StatisticCounter.getInstance();

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus( value = HttpStatus.CREATED)
    @ResponseBody
    public void transactions(@RequestBody Statistic statistic) {
    	statisticCounter.setLastTransactionTime(statistic.getTimeStamp());
    	if ( statisticCounter.checkLastTransactionTime() ){
    		statisticCounter.clearValues();
    		throw new OlderTransactionException();
    	}
    	statisticCounter.addValue(statistic.getAmount());
//    	CompletableFuture.supplyAsync(() -> statisticCounter.increment());
    }
    
    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public StatisticCounter statistics() {

//    	CompletableFuture.supplyAsync(() -> statisticCounter.calculate());
    	statisticCounter.calculate();
    	return statisticCounter;
    }
}
