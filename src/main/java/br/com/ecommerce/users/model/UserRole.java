package br.com.ecommerce.users.model;

public enum UserRole {

	CLIENT("client"),
	EMPLOYEE("employee"),
	ADMIN("admin");
	
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}