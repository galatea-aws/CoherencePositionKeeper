import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import pof.Trade;

import com.tangosol.coherence.component.util.daemon.queueProcessor.service.grid.InvocationService;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;


public class TestDataSimulator {
	public static Logger logger = LogManager.getLogger(TestDataSimulator.class.getName());
	public static void main(String[] args) throws IOException {
		Properties tradesimulatorProp = new Properties();
		int tradeVolume = 50000;
	  	try {
            //load a properties file
    		tradesimulatorProp.load(new FileInputStream("resource/tradesimulatorconfig.properties"));
    		tradeVolume = Integer.valueOf(tradesimulatorProp.getProperty("tradevolume"));
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
	  	
	  	//Get trade cache
	//	CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("trade");
/*        InvocationService service = (InvocationService)
                CacheFactory.getConfigurableCacheFactory()
                    .ensureService("ExtendTcpInvocationService");*/
        //Set the current knowledge date and effective date
		Calendar calendar = Calendar.getInstance();
        Date endDate = calendar.getTime();
        Integer tradedays = Integer.valueOf(tradesimulatorProp.getProperty("tradedays"));
        calendar.add(Calendar.DAY_OF_YEAR,-1*(tradedays));
        Date currentDate = calendar.getTime();
        
	  	//Generate trade and insert it
		Long tradeId = 1L;
	  	Long simulatorStartTS = System.currentTimeMillis();
		TradeGenerator tradeGenerator = new TradeGenerator(6, 100);
	    while (currentDate.before(endDate)) {
			for (int i = 0; i < tradeVolume; i++) {
				Trade trade = tradeGenerator
						.CreateTrade(tradeId++,currentDate, currentDate, 0);
				cache.put(trade.getTradeId(), trade);
			}
			logger.info(tradeId);
        	calendar.add(Calendar.DAY_OF_YEAR,1);
			currentDate = calendar.getTime();
	    }
	    
	    //Create Index
		ValueExtractor extractor = new ReflectionExtractor("getProductCusip");
	    cache.addIndex(extractor, true, null);
	    extractor = new ReflectionExtractor("getAccountId");
	    cache.addIndex(extractor, true, null);
	    
	    //Output time
		logger.info(String.format("Total time: %d", (System.currentTimeMillis() - simulatorStartTS)));
		CacheFactory.shutdown();

	}
}
