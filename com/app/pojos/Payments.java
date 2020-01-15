package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payments 
{
	private Integer id;
	private double amount;
	private PaymentType type;
	private Date transactionTime;
	private Date nextPaymentDuedate;
	private Users user;
	public Payments() {
		// TODO Auto-generated constructor stub
	}
	public Payments(double amount, PaymentType type, Date transactionTime, Date nextPaymentDuedate) {
		super();
		this.amount = amount;
		this.type = type;
		this.transactionTime = transactionTime;
		this.nextPaymentDuedate = nextPaymentDuedate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Enumerated(EnumType.STRING)
	public PaymentType getType() {
		return type;
	}
	public void setType(PaymentType type) {
		this.type = type;
	}
	@Temporal(TemporalType.TIME)
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	@Temporal(TemporalType.DATE)
	public Date getNextPaymentDuedate() {
		return nextPaymentDuedate;
	}
	public void setNextPaymentDuedate(Date nextPaymentDuedate) {
		this.nextPaymentDuedate = nextPaymentDuedate;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Payments [id=" + id + ", amount=" + amount + ", type=" + type + ", transactionTime=" + transactionTime
				+ ", nextPaymentDuedate=" + nextPaymentDuedate + "]";
	}
	

}
