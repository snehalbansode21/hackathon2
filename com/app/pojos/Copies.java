package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "copies")
public class Copies 
{
	private Integer id;
	private String status;
	private int rack;
	private List<IssueRecord> issueRecordList = new ArrayList<>();
	private Books book;
	public Copies() {
		// TODO Auto-generated constructor stub
	}
	public Copies(String status, int rack) {
		super();
		this.status = status;
		this.rack = rack;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRack() {
		return rack;
	}
	public void setRack(int rack) {
		this.rack = rack;
	}
	@OneToMany(mappedBy = "copy",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<IssueRecord> getIssueRecordList() {
		return issueRecordList;
	}
	public void setIssueRecordList(List<IssueRecord> issueRecordList) {
		this.issueRecordList = issueRecordList;
	}
	@ManyToOne
	@JoinColumn(name = "book_id")
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public void addIssueRecord(IssueRecord i)
	{
		issueRecordList.add(i);
		i.setCopy(this);
	}
	public void removeIssueRecord(IssueRecord i)
	{
		issueRecordList.remove(i);
		i.setCopy(null);
	}
	@Override
	public String toString() {
		return "Copies [id=" + id + ", status=" + status + ", rack=" + rack + "]";
	}
	
	
}
