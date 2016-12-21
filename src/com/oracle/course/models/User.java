package com.oracle.course.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "iuser",schema="drug_admin")
@SequenceGenerator(name="iuser_id_sequence",sequenceName="drug_admin.iuser_id_sequence")
public class User {
	private Long id;
	private String userName;
	private String password;
	private String token;
	private Integer ilevel;
	private Double consumedMoney;
	private Date birthday;
	private Integer age;
	private String email;
	
	@Id
	@GeneratedValue(generator="iuser_id_sequence")
    @Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Basic
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Basic
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Basic
	@Column(name="token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Basic
	@Column(name="ilevel")
	public Integer getIlevel() {
		return ilevel;
	}
	public void setIlevel(Integer ilevel) {
		this.ilevel = ilevel;
	}
	
	@Basic
	@Column(name="consumed_money")
	public Double getConsumedMoney() {
		return consumedMoney;
	}
	public void setConsumedMoney(Double consumedMoney) {
		this.consumedMoney = consumedMoney;
	}
	@Basic
	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Basic
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Basic
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
