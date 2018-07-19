package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

public class Transactions 
{
	private String description;
	private BigDecimal debited;
	private BigDecimal credited;
	
	public Transactions() 
	{
		
	}

	public Transactions(String description, BigDecimal debited, BigDecimal credited) {
		super();
		this.description = description;
		this.debited = debited;
		this.credited = credited;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDebited() {
		return debited;
	}

	public void setDebited(BigDecimal debited) {
		this.debited = debited;
	}

	public BigDecimal getCredited() {
		return credited;
	}

	public void setCredited(BigDecimal credited) {
		this.credited = credited;
	}

	@Override
	public String toString() {
		return "Tansactions [description=" + description + ", debited=" + debited + ", credited=" + credited + "]";
	}
	
	

}
