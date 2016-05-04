package entityDB;

public enum IncomeType {

	CUSTOMER_PURCHASE("Customer Description"),
	COMPANY_NEW_COUPON("Conpany New Coupon"),
	COMPANY_UPDATE_COUPON("Company Update Coupon");
	
	private String description;

	/**
	 * @param description
	 */
	private IncomeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
	
	
	
	
	
	
}
