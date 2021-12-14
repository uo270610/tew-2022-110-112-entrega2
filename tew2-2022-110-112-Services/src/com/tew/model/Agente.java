package com.tew.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agente")
public class Agente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String login;
	private String passwd;
	
	
	@XmlElement
	public Long getId() {
		return id;
	}
	@XmlElement
	public String getLogin() {
		return login;
	}
	@XmlElement
	public String getPasswd() {
		return passwd;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
