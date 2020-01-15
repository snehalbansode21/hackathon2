package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users 
{
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Role role;
	private List<Payments> paymentList;
	private List<IssueRecord> issueRecordList;
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(String name, String email, String phone, String password, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 30)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 30,unique = true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 40)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(length = 30)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.STRING)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public List<Payments> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payments> paymentList) {
		this.paymentList = paymentList;
	}
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public List<IssueRecord> getIssueRecordList() {
		return issueRecordList;
	}
	public void setIssueRecordList(List<IssueRecord> issueRecordList) {
		this.issueRecordList = issueRecordList;
	}
	public void addPayments(Payments p)
	{
		paymentList.add(p);
		p.setUser(this);
	}
	public void removePayments(Payments p)
	{
		paymentList.remove(p);
		p.setUser(null);
	}
	public void addIssueRecord(IssueRecord i)
	{
		issueRecordList.add(i);
		i.setUser(this);
	}
	public void removeIssueRecord(IssueRecord i)
	{
		issueRecordList.remove(i);
		i.setUser(null);
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", role=" + role + "]";
	}
	
}
