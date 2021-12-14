package com.tew.model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8420789334117957380L;
	
	private String login;
	private String passwd;
	
	public User() {
		
	}
	
	public User(String l, String n) {
		// TODO Auto-generated constructor stub
		this.login = l;
		this.passwd = n;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String name) {
		this.passwd = name;
	}
	
}
