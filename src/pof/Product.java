package pof;

import java.io.IOException;
import java.util.Date;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.Base;

public class Product implements PortableObject{
	private String productCusip;
	private String productName;
	private String productIsin;
	private String prodcutTicker;
	private String prodcutRic;
	private String prodcutCcy;
	private String prodcutCoi;
	private String createUser;
	private Date   createTimestamp;
	private String lastupdateUser;
	private Date   lastupdateTimestamp;
	
	public Product(){
		
	}
	
	public Product(String productCusip,String productName,String productIsin,String prodcutTicker,
					String prodcutRic,String prodcutCcy,String prodcutCoi,
					String createUser,Date createTimestamp,String lastupdateUser,Date lastupdateTimestamp){
		this.setProductCusip(productCusip);     
		this.setProductName(productName);
		this.setProductIsin(productIsin);
		this.setProdcutTicker(prodcutTicker);
		this.setProdcutRic(prodcutRic);
		this.setProdcutCcy(prodcutCcy);
		this.setProdcutCoi(prodcutCoi);
		this.setCreateUser(createUser);
		this.setCreateTimestamp(createTimestamp);
		this.setLastupdateUser(lastupdateUser);
		this.setLastupdateTimestamp(lastupdateTimestamp);
	}
	
	

	@Override
	public void readExternal(PofReader reader) throws IOException {
		this.productCusip        = reader.readString(PRODUCTCUSIP);
		this.productName         = reader.readString(PRODUCTNAME);
		this.productIsin         = reader.readString(PRODUCTISIN);
		this.prodcutTicker       = reader.readString(PRODCUTTICKER);
		this.prodcutRic          = reader.readString(PRODCUTRIC);
		this.prodcutCcy          = reader.readString(PRODCUTCCY);
		this.prodcutCoi          = reader.readString(PRODCUTCOI);
		this.createUser          = reader.readString(CREATEUSER);
		this.createTimestamp     = reader.readDate(CREATETIMESTAMP);
		this.lastupdateUser      = reader.readString(LASTUPDATEUSER);
		this.lastupdateTimestamp = reader.readDate(LASTUPDATETIMESTAMP);
	}

	@Override
	public void writeExternal(PofWriter writer) throws IOException {
		writer.writeString(PRODUCTCUSIP,productCusip);     
		writer.writeString(PRODUCTNAME,productName);
		writer.writeString(PRODUCTISIN,productIsin);
		writer.writeString(PRODCUTTICKER,prodcutTicker);
		writer.writeString(PRODCUTRIC,prodcutRic);
		writer.writeString(PRODCUTCCY,prodcutCcy);
		writer.writeString(PRODCUTCOI,prodcutCoi);
		writer.writeString(CREATEUSER,createUser);
		writer.writeDate(CREATETIMESTAMP,createTimestamp);
		writer.writeString(LASTUPDATEUSER,lastupdateUser);
		writer.writeDate(LASTUPDATETIMESTAMP,lastupdateTimestamp);
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
	    
	    Product pThat = (Product)that;
        return Base.equals(getProductCusip(), pThat.getProductCusip());
    }


    /**
    * {@inheritDoc}
    */
    public int hashCode(){
        return (getProductCusip() == null ? 0 : getProductCusip().hashCode());
    }

    /**
    * {@inheritDoc}
    */
    public String toString(){
    	return productCusip.toString();
    }
    
    //----------------------- Index ------------------------------------
	private static final int PRODUCTCUSIP = 0;
	private static final int PRODUCTNAME = 1;
	private static final int PRODUCTISIN = 2;
	private static final int PRODCUTTICKER = 3;
	private static final int PRODCUTRIC = 4;
	private static final int PRODCUTCCY = 5;
	private static final int PRODCUTCOI = 6;
	private static final int CREATEUSER = 7;
	private static final int CREATETIMESTAMP = 8;
	private static final int LASTUPDATEUSER = 9;
	private static final int LASTUPDATETIMESTAMP = 10;
	
	// ----- Object methods -------------------------------------------------
	private String getProductCusip() {
		return productCusip;
	}

	private void setProductCusip(String productCusip) {
		this.productCusip = productCusip;
	}

	private String getProductName() {
		return productName;
	}

	private void setProductName(String productName) {
		this.productName = productName;
	}

	private String getProductIsin() {
		return productIsin;
	}

	private void setProductIsin(String productIsin) {
		this.productIsin = productIsin;
	}

	private String getProdcutTicker() {
		return prodcutTicker;
	}

	private void setProdcutTicker(String prodcutTicker) {
		this.prodcutTicker = prodcutTicker;
	}

	private String getProdcutRic() {
		return prodcutRic;
	}

	private void setProdcutRic(String prodcutRic) {
		this.prodcutRic = prodcutRic;
	}

	private String getProdcutCcy() {
		return prodcutCcy;
	}

	private void setProdcutCcy(String prodcutCcy) {
		this.prodcutCcy = prodcutCcy;
	}

	private String getProdcutCoi() {
		return prodcutCoi;
	}

	private void setProdcutCoi(String prodcutCoi) {
		this.prodcutCoi = prodcutCoi;
	}

	private String getCreateUser() {
		return createUser;
	}

	private void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	private Date getCreateTimestamp() {
		return createTimestamp;
	}

	private void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
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
