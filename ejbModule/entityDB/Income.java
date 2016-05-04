package entityDB;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Income") ////
public class Income implements Serializable {
		
	private static final long serialVersionUID = 1L;
	private long incomeId;
	private long id;
	private String name;

	private Timestamp date;
	//@Enumerated(EnumType.STRING)
	private IncomeType description;
	private double amount;

	// Constructor
	public Income(){}
	
	/**
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 * @param amount
	 */
//	public Income(long id, String name, Timestamp date, IncomeType description, double amount) {
////		this.id = id;
////		this.name = name;
//		this.date = date;
//		this.description = description;
//		this.amount = amount;
//	}

//	@EmbeddedId
//	private IncomePK pk;
	
//	public IncomePK getPK() {return pk;}
//	public void setPK(IncomePK pk) {this.pk=pk;}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // automatically generated
	@Column//(name="INCOMEID", nullable=false)
	public long getIncomeId() {return incomeId;	}
	public void setIncomeId(long incomeId) {this.incomeId = incomeId;}
	
	@Column//(name="ID", nullable=false)
	public long getId() {return id;	}
	public void setId(long id) {this.id = id;}


	@Column//(name="NAME", nullable=false)
	public String getName() {return name;}
	public void setName(String name) {this.name = name;	}
	
	@Column//(name="DATE", nullable=false)
	public Timestamp getDate() {return date;}
	public void setDate(Timestamp date) {this.date = date;}
	
	@Column//(name="DESCRIPTION", nullable=false)
	public IncomeType getDescription() {return description;}
	public void setDescription(IncomeType description) {this.description = description;}

	@Column//(name="AMOUNT", nullable=false)
	public double getAmount() {return amount;}
	public void setAmount(double amount) {this.amount = amount;}

	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", id=" + id + ", name=" + name + ", date=" + date + ", description="
				+ description + ", amount=" + amount + "]\n";
	}

}
