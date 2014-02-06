import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Filter;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.InvocableMap.EntryAggregator;
import com.tangosol.util.aggregator.GroupAggregator;
import com.tangosol.util.aggregator.LongSum;
import com.tangosol.util.extractor.ReflectionExtractor;
import com.tangosol.util.filter.EqualsFilter;


public class SumPositionForProductGroupByAccountTester {
	public static Logger logger = LogManager.getLogger(SumPositionForProductGroupByAccountTester.class.getName());
	public static void main(String[] args) throws IOException {
		//Get trade cache
		//CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("trade");
	    //Create Index
		ValueExtractor extractor = new ReflectionExtractor("getProductCusip");
	    cache.addIndex(extractor, true, null);
	    extractor = new ReflectionExtractor("getAccountId");
	    cache.addIndex(extractor, true, null);
		//Create filter
        Filter productCusip = new EqualsFilter("getProductCusip", "cusip1");
	
		//Query
		Long simulatorStartTS = System.currentTimeMillis();
        EntryAggregator gp=GroupAggregator.createInstance("getAccountId", new LongSum("getPositionDelta")); 
        Object o = cache.aggregate(productCusip, gp);
        long duration = System.currentTimeMillis() - simulatorStartTS;

        //Output result
        System.out.println(o);
        System.out.println(duration);
		logger.info(String.format("Total time: %d", duration));
		CacheFactory.shutdown();
	}
}
