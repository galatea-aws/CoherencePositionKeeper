package pof;

import java.io.IOException;
import java.util.Date;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Base;

public class Trade  implements PortableObject{
    private Long tradeId;
    private String accountId;
    private String productCusip;
    private String exchange;
    private String status;
    private String sourcesystemId;
    private Date knowledgeDate;
    private Date effectiveDate;
    private Date settlementDate;
    private Long positionDelta;
    private String createUser;
    private Date createTimestamp;
    private String lastUpdateUser;
    private Date lastUpdateTimestamp;
    
    public Trade(){
    	
    }
    
    
    public Trade(Long tradeId, String accountId, String productCusip, String exchange, String status, String sourcesystemId, 
    		Date knowledgeDate, Date effectiveDate, Date settlementDate, Long positionDelta, 
    		String createUser, Date createTimestamp, String lastUpdateUser, Date lastUpdateTimestamp) {
        this.setTradeId(tradeId);
    	this.setAccountId(accountId);
        this.setProductCusip(productCusip);
        this.setExchange(exchange);
        this.setStatus(status);
        this.setSourcesystemId(sourcesystemId);
        this.setKnowledgeDate(knowledgeDate);
        this.setEffectiveDate(effectiveDate);
        this.setSettlementDate(settlementDate);
        this.setPositionDelta(positionDelta);
        this.setCreateUser(createUser);
        this.setCreateTimestamp(createTimestamp);
        this.setLastUpdateUser(lastUpdateUser);
        this.setLastUpdateTimestamp(lastUpdateTimestamp);
    }
    
    
    
	@Override
	public void readExternal(PofReader reader) throws IOException {
		 this.tradeId             = reader.readLong(TRADEID);
		 this.accountId           = reader.readString(ACCOUNTID);
		 this.productCusip        = reader.readString(PRODUCTCUSIP);
		 this.exchange            = reader.readString(EXCHANGE);
		 this.status              = reader.readString(STATUS);
		 this.sourcesystemId      = reader.readString(SOURCESYSTEMID);
		 this.knowledgeDate       = new Date(reader.readDate(KNOWLEDGEDATE).getTime());
		 this.effectiveDate       = new Date(reader.readDate(EFFECTIVEDATE).getTime());
		 this.settlementDate      = new Date(reader.readDate(SETTLEMENTDATE).getTime());
		 this.positionDelta       = reader.readLong(POSITIONDELTA);
		 this.createUser          = reader.readString(CREATEUSER);
		 this.createTimestamp     = new Date(reader.readDate(CREATETIMESTAMP).getTime());
		 this.lastUpdateUser      = reader.readString(LASTUPDATEUSER);
		 this.lastUpdateTimestamp = new Date(reader.readDate(LASTUPDATETIMESTAMP).getTime());
		
	}
	
	@Override
	public void writeExternal(PofWriter writer) throws IOException {
		 writer.writeLong(TRADEID,tradeId);
		 writer.writeString(ACCOUNTID,accountId);
		 writer.writeString(PRODUCTCUSIP,productCusip);
		 writer.writeString(EXCHANGE,exchange);
		 writer.writeString(STATUS,status);
		 writer.writeString(SOURCESYSTEMID,sourcesystemId);
		 writer.writeDate(KNOWLEDGEDATE,knowledgeDate);
		 writer.writeDate(EFFECTIVEDATE,effectiveDate);
		 writer.writeDate(SETTLEMENTDATE,settlementDate);
		 writer.writeLong(POSITIONDELTA,positionDelta);
		 writer.writeString(CREATEUSER,createUser);
		 writer.writeDate(CREATETIMESTAMP,createTimestamp);
		 writer.writeString(LASTUPDATEUSER,lastUpdateUser);
		 writer.writeDate(LASTUPDATETIMESTAMP,lastUpdateTimestamp);
	}
    
    // ----- Object methods -------------------------------------------------

    /**
    * {@inheritDoc}
    */
    public boolean equals(Object that){
	    if (this == that){
	    	return true;
	    }
	    if (that == null){
	    	return false;
        }
	    
	    Trade tThat = (Trade)that;
        return Base.equals(getTradeId(), tThat.getTradeId());
    }


    /**
    * {@inheritDoc}
    */
    public int hashCode(){
        return (getTradeId() == null ? 0 : getTradeId().hashCode());
    }

    /**
    * {@inheritDoc}
    */
    public String toString(){
    	return tradeId.toString();
    }
    
    
    //----------------------- Index ------------------------------------
    public static final int  TRADEID = 0;
    public static final int  ACCOUNTID = 1;
    public static final int  PRODUCTCUSIP = 2;
    public static final int  EXCHANGE = 3;
    public static final int  STATUS = 4;
    public static final int  SOURCESYSTEMID = 5;
    public static final int  KNOWLEDGEDATE = 6;
    public static final int  EFFECTIVEDATE = 7;
    public static final int  SETTLEMENTDATE = 8;
    public static final int  POSITIONDELTA = 9;
    public static final int  CREATEUSER = 10;
    public static final int  CREATETIMESTAMP = 11;
    public static final int  LASTUPDATEUSER = 12;
    public static final int  LASTUPDATETIMESTAMP = 13;
    
    //----------------------- Getter and Setter ------------------------
	public Long getTradeId() {
		return tradeId;
	}
	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getProductCusip() {
		return productCusip;
	}
	public void setProductCusip(String productCusip) {
		this.productCusip = productCusip;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSourcesystemId() {
		return sourcesystemId;
	}
	public void setSourcesystemId(String sourcesystemId) {
		this.sourcesystemId = sourcesystemId;
	}
	public Date getKnowledgeDate() {
		return knowledgeDate;
	}
	public void setKnowledgeDate(Date knowledgeDate) {
		this.knowledgeDate = knowledgeDate;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public long getPositionDelta() {
		return positionDelta;
	}
	public void setPositionDelta(long positionDelta) {
		this.positionDelta = positionDelta;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
}
