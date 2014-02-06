package pof;

import java.io.IOException;
import java.util.Date;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Base;

public class Account implements PortableObject{
	private	String accountId;	          
	private	String accountName;	      
	private	String accountAddress;	      
	private	String accountTin;		      
	private	String createUser;           
	private	Date createtimeStamp;      
	private	String lastupdateUser;      
	private	Date lastupdateTimestamp; 
	
	public Account(){
		
	}
	
	public Account(String accountId,String accountName,String accountAddress,String accountTin,
			String createUser,Date createtimeStamp,String lastupdateUser,Date lastupdateTimestamp){
		this.setAccountId(accountId);
		this.setAccountName(accountName);
		this.setAccountAddress(accountAddress);
		this.setAccountTin(accountTin);
		this.setCreateUser(createUser);
		this.setCreatetimeStamp(createtimeStamp);
		this.setLastupdateUser(lastupdateUser);
		this.setLastupdateTimestamp(lastupdateTimestamp);
	}
	

	@Override
	public void readExternal(PofReader reader) throws IOException {
		this.accountId	         = reader.readString(ACCOUNTID);
		this.accountName	     = reader.readString(ACCOUNTNAME);
		this.accountAddress	     = reader.readString(ACCOUNTADDRESS);
		this.accountTin		     = reader.readString(ACCOUNTTIN);
		this.createUser          = reader.readString(CREATEUSER);
		this.createtimeStamp     = new Date(reader.readDate(CREATETIMESTAMP).getTime());
		this.lastupdateUser      = reader.readString(LASTUPDATEUSER);
		this.lastupdateTimestamp = new Date(reader.readDate(LASTUPDATETIMESTAMP).getTime());
	}

	@Override
	public void writeExternal(PofWriter writer) throws IOException {
		writer.writeString(ACCOUNTID,this.accountId);
		writer.writeString(ACCOUNTNAME,this.accountName);
		writer.writeString(ACCOUNTADDRESS,this.accountAddress);
		writer.writeString(ACCOUNTTIN,this.accountTin);
		writer.writeString(CREATEUSER,this.createUser);
		writer.writeDate(CREATETIMESTAMP,this.createtimeStamp);
		writer.writeString(LASTUPDATEUSER,this.lastupdateUser);
		writer.writeDate(LASTUPDATETIMESTAMP,this.lastupdateTimestamp);
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
	    
	    Account aThat = (Account)that;
        return Base.equals(getAccountId(), aThat.getAccountId());
    }


    /**
    * {@inheritDoc}
    */
    public int hashCode(){
        return (getAccountId() == null ? 0 : getAccountId().hashCode());
    }

    /**
    * {@inheritDoc}
    */
    public String toString(){
    	return accountId.toString();
    }
    
	//----------------------- Index ------------------------------------
	private static final int ACCOUNTID = 0;
	private static final int ACCOUNTNAME = 1;
	private static final int ACCOUNTADDRESS = 2;
	private static final int ACCOUNTTIN = 3;
	private static final int CREATEUSER = 4;
	private static final int CREATETIMESTAMP = 5;
	private static final int LASTUPDATEUSER = 6;
	private static final int LASTUPDATETIMESTAMP = 7;
	
    //----------------------- Getter and Setter ------------------------
	private String getAccountId() {
		return accountId;
	}

	private void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	private String getAccountName() {
		return accountName;
	}

	private void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	private String getAccountAddress() {
		return accountAddress;
	}

	private void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	private String getAccountTin() {
		return accountTin;
	}

	private void setAccountTin(String accountTin) {
		this.accountTin = accountTin;
	}

	private String getCreateUser() {
		return createUser;
	}

	private void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private Date getCreatetimeStamp() {
		return createtimeStamp;
	}

	private void setCreatetimeStamp(Date createtimeStamp) {
		this.createtimeStamp = createtimeStamp;
	}

	private String getLastupdateUser() {
		return lastupdateUser;
	}

	private void setLastupdateUser(String lastupdateUser) {
		this.lastupdateUser = lastupdateUser;
	}

	private Date getLastupdateTimestamp() {
		return lastupdateTimestamp;
	}

	private void setLastupdateTimestamp(Date lastupdateTimestamp) {
		this.lastupdateTimestamp = lastupdateTimestamp;
	}
}
