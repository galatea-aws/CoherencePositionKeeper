import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap.EntryAggregator;
import com.tangosol.util.aggregator.GroupAggregator;
import com.tangosol.util.aggregator.LongSum;
import com.tangosol.util.filter.EqualsFilter;


public class SumPositionForAccountGroupByProductTester {
	public static Logger logger = LogManager.getLogger(SumPositionForAccountGroupByProductTester.class.getName());
	public static void main(String[] args) throws IOException {
		//Get trade cache
		//CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("trade");
		
		//Create filter
        Filter accountId = new EqualsFilter("getAccountId", "account3");
	
		//Query
		Long simulatorStartTS = System.currentTimeMillis();
        EntryAggregator gp=GroupAggregator.createInstance("getProductCusip", new LongSum("getPositionDelta")); 
        Object o = cache.aggregate(accountId, gp);
        long duration = System.currentTimeMillis() - simulatorStartTS;
        
        //Output result
        System.out.println(o);
        System.out.println(duration);
		logger.info(String.format("Total time: %d", duration));
		CacheFactory.shutdown();
	}
}
