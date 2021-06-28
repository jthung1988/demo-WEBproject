package tai.spring.bean;

import java.io.Serializable;

public class OrderDetailsPrimarykey implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderNo;
	
	private Integer itemNo;
	
	OrderDetailsPrimarykey(){};
	OrderDetailsPrimarykey(String orderNo, Integer itemNo){
		this.orderNo = orderNo;
		this.itemNo = itemNo;
	}
	
	
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public Integer getItemNo() {
		return itemNo;
	}
	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if(o.getClass().isInstance(OrderDetailsPrimarykey.class)) {
			OrderDetailsPrimarykey outkey = (OrderDetailsPrimarykey)o;
			if(orderNo.equals(outkey.getOrderNo()) && itemNo.equals(outkey.getItemNo())) {
				result = true;
			}
		}
		return result;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}
