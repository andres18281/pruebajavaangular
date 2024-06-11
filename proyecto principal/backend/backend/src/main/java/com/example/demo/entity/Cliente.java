package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	
	public String getSharedKey() {
		return sharedKey;
	}
	public void setSharedKey(String sharedKey) {
		this.sharedKey = sharedKey;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getDateinitial() {
		return dateinitial;
	}
	public void setDateinitial(String dateinitial) {
		this.dateinitial = dateinitial;
	}
	public String getDateend() {
		return dateend;
	}
	public void setDateend(String dateend) {
		this.dateend = dateend;
	}
	

	@Column(name = "sharedKey")
	private String sharedKey;
	@Column(name = "businessId")
	private String businessId;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private int phone;
	@Column(name = "dateinitial")
	private String dateinitial;
	@Column(name = "dateend")
	private String dateend;
	
	public void generarSharedKey() {
        if (businessId != null && !businessId.isEmpty() && email != null && !email.isEmpty()) {
            String[] parts = businessId.split("\\s+");
            String firstPart = parts[0].toLowerCase();
            String[] emailParts = email.split("@");
            String secondPart = emailParts[0].toLowerCase();
            if (firstPart.length() > 0 && secondPart.length() > 0) {
                sharedKey = firstPart.charAt(0) + secondPart;
                this.setSharedKey(sharedKey);
            }
        }
    }
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Configuración de generación automática
    private Long id;
	 
	 @Override
	    public String toString() {
	        return "Cliente{" +
	        		" sharedKey='" + sharedKey + '\'' +
	                ", businessId='" + businessId + '\'' +
	                ", phone='" + phone + '\'' +
	                ", email='" + email + '\'' +
	                ", dateinitial='" + dateinitial + '\'' +
	                ", dateend='" + dateend + '\'' +
	                '}';
	    }
	
	private static final long serialVersionUID = 1285454306356845809L;
}
