import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import pof.Trade;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap.EntryAggregator;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.aggregator.GroupAggregator;
import com.tangosol.util.aggregator.LongMin;
import com.tangosol.util.aggregator.LongSum;
import com.tangosol.util.extractor.ReflectionExtractor;
import com.tangosol.util.filter.AndFilter;
import com.tangosol.util.filter.EqualsFilter;


public class SumPositionByAccountAndProductTester {
	public static Logger logger = LogManager.getLogger(SumPositionByAccountAndProductTester.class.getName());
	public static void main(String[] args) throws IOException {
		//Get trade cache
	//	CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("trade");
	    
		//Create filter
        Filter accountId = new EqualsFilter("getAccountId", "account1");
        Filter productCusip = new EqualsFilter("getProductCusip", "cusip55");
        
        Filter filter = new AndFilter(accountId,productCusip);
		//Query
		Long simulatorStartTS = System.currentTimeMillis();
		Long position = (Long)cache.aggregate(filter, new LongSum("getPositionDelta"));
        long duration = System.currentTimeMillis() - simulatorStartTS;
        
        //Output result
        System.out.println(duration);
		logger.info(String.format("Position: %d", position));
		logger.info(String.format("Total time: %d", duration));
		CacheFactory.shutdown();
	}
}
