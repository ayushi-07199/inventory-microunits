package com.dxctraining.inventorymgt.supplier.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Sessiondata {
	private int id=-1;
	private boolean userLoggedin;
	
	public Sessiondata() {
		
	}
	
	public Sessiondata(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void saveLogin(int id){
        this.userLoggedin=true;
        this.id=id;
    }

    public void  clear(){
        id=-1;
        userLoggedin=false;
    }
	
	public boolean isUserLoggedin() {
		return userLoggedin;
	}
	

}