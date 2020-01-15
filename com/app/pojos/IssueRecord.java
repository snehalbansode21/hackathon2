package com.app.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "issueRecord")
public class IssueRecord 
{
	private Integer id;
	private Date issueDate;
	private Date returnDuedate;
	private Date returnDate;
	private double fineAmount;
	private Users user;
	private Copies copy;
	public IssueRecord() {
		// TODO Auto-generated constructor stub
	}
	public IssueRecord(Date issueDate, Date returnDuedate, Date returnDate, double fineAmount) {
		super();
		this.issueDate = issueDate;
		this.returnDuedate = returnDuedate;
		this.returnDate = returnDate;
		this.fineAmount = fineAmount;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	@Temporal(TemporalType.DATE)
	public Date getReturnDuedate() {
		return returnDuedate;
	}
	public void setReturnDuedate(Date returnDuedate) {
		this.returnDuedate = returnDuedate;
	}
	@Temporal(TemporalType.DATE)
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "copy_id")
	public Copies getCopy() {
		return copy;
	}
	public void setCopy(Copies copy) {
		this.copy = copy;
	}
	@Override
	public String toString() {
		return "IssueRecord [id=" + id + ", issueDate=" + issueDate + ", returnDuedate=" + returnDuedate
				+ ", returnDate=" + returnDate + ", fineAmount=" + fineAmount + "]";
	}
	
}
