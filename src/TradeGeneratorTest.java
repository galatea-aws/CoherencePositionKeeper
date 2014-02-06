import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import pof.Trade;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.extractor.ReflectionExtractor;

public class TradeGeneratorTest {
	public static Logger logger = LogManager.getLogger(TradeGeneratorTest.class.getName());
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
	  	
		CacheFactory.ensureCluster();
		NamedCache cache = CacheFactory.getCache("trade");
		TradeGenerator tradeGenerator = new TradeGenerator(6, 100);
		
		Calendar calendar = Calendar.getInstance();
        Date endDate = calendar.getTime();
        
        //Set the current knowledge date and effective date
        Integer tradedays = Integer.valueOf(tradesimulatorProp.getProperty("tradedays"));
        calendar.add(Calendar.DAY_OF_YEAR,-1*(tradedays));
        Date currentDate = calendar.getTime();
		Long tradeId = 1L;
	  	Long simulatorStartTS = System.currentTimeMillis();
	    while (currentDate.before(endDate)) {
			for (int i = 0; i < tradeVolume; i++) {
				Trade trade = tradeGenerator
						.CreateTrade(tradeId++,currentDate, currentDate, 0);
				cache.put(trade.getTradeId(), trade);
				//logger.info(String.format("Insert trade %d", trade.getTradeId()));
			}
        	calendar.add(Calendar.DAY_OF_YEAR,1);
			currentDate = calendar.getTime();
			logger.info(String.format("Insert trade %d", tradeId));
	    }
		ValueExtractor extractor = new ReflectionExtractor("getProductCusip");
	    cache.addIndex(extractor, true, null);
	    extractor = new ReflectionExtractor("getAccountId");
	    cache.addIndex(extractor, true, null);
		logger.info(String.format("Total time: %d", (System.currentTimeMillis() - simulatorStartTS)));
		CacheFactory.shutdown();

	}
}
