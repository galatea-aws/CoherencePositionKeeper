import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import pof.Trade;

public class TradeGenerator {
	
	private int maxAccounts = 0;
	private int maxProducts = 0;
	private Random random = new Random();
    
    public TradeGenerator(int maxAccounts, int maxProducts){
    	this.maxAccounts = maxAccounts;
    	this.maxProducts = maxProducts;
    }
    
    public Trade CreateTrade(Long tradeId, Date knowledgeDate, Date effectiveDate,int probabilityByIsin) throws IOException{
        String accountId = "account" + (random.nextInt(maxAccounts)+1);
        
    	int productId = random.nextInt(maxProducts)+1;
    	String productCusip = "cusip" + productId;
    	String productIsin = StringUtils.rightPad(String.valueOf(productId), 12, "0");
    	
    	
    	String exchange = "XX";
    	String status = "Y";
    	String sourcesystemId = "testsystem" + tradeId;
    	
    	//Set settlement Date
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(effectiveDate);
    	calendar.add(Calendar.DAY_OF_YEAR, 3);
    	Date settlementDate = calendar.getTime();
         
        long positionDelta = random.nextInt(1000)*(random.nextBoolean()?1:-1);
        String user = "TestAccount";
    	return new Trade(tradeId, accountId, productCusip, exchange, status, sourcesystemId, 
    			knowledgeDate, effectiveDate, settlementDate, positionDelta,
    			user, new Date(), user, new Date());
    }
}
