package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/************************************************************************************
 *          @author          Vaishnavi Voorelli
 *          Description      It is an Entity class for Users 
  *         Version             1.0
  *         Created Date     05-10-2020
 ************************************************************************************/



@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="user_management")
public class User {
	@Id
	@Column(name="email_id")
	private String email;
	@Column(name="user_id",length=20)
	private String userId;
	@Column(name="full_name",length=30)
	private String fullName;
	@Column(name="password")
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
