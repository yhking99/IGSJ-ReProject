package ezen.project.IGSJ.order.domain;

import java.util.Date;

public class OrderDTO {

	/*
	 * orderNum varchar(50) PK userId varchar(20) PK order_date datetime
	 * post_address varchar(20) detail_address varchar(50) detail_address2
	 * varchar(50) recipient varchar(10) recipient_phone varchar(15)
	 */

	private int orderNum;
	private String userId;
	private Date order_date;
	private String postAddress;
	private String detail_address;
	private String recipient;
	private String recipient_phone;

	private String userName;
	private String userPhoneNumber;
	private String address;
	private String detailAddress;
	
	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	/* using field */
	public OrderDTO(int orderNum, String userId, Date order_date, String postAddress, String detail_address,
			String recipient, String recipient_phone, String userName, String userPhoneNumber, String address,
			String detailAddress) {
		super();
		this.orderNum = orderNum;
		this.userId = userId;
		this.order_date = order_date;
		this.postAddress = postAddress;
		this.detail_address = detail_address;
		this.recipient = recipient;
		this.recipient_phone = recipient_phone;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.address = address;
		this.detailAddress = detailAddress;
	}
	

	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getPostAddress() {
		return postAddress;
	}

	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderNum=" + orderNum + ", userId=" + userId + ", order_date=" + order_date + ", postAddress="
				+ postAddress + ", detail_address=" + detail_address + ", recipient=" + recipient + ", recipient_phone="
				+ recipient_phone + ", userName=" + userName + ", userPhoneNumber=" + userPhoneNumber + ", address="
				+ address + ", detailAddress=" + detailAddress + "]";
	}

	


}
