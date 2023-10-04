package com.projeto.dscommerce.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_user")
public class User implements UserDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 
 @Column(columnDefinition ="TEXT")
 private String email;
 
 private String phone;
 private LocalDate birth_date;
 private String password;
 
 @ManyToMany
 @JoinTable(name = "tb_user_role",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "role_id"))
 private Set<Role> roles = new HashSet<>();
 
 @OneToMany(mappedBy = "client")
 private List<Order> orders = new ArrayList<>();
 
 public User(){
	 
 }

public User(Long id, String name, String email, String phone, LocalDate birth_date, String password) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.birth_date = birth_date;
	this.password = password;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public LocalDate getBirth_date() {
	return birth_date;
}


public void setBirth_date(LocalDate birth_date) {
	this.birth_date = birth_date;
}



public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Order> getOrders() {
	return orders;
}

public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}
public void addRole(Role role) {
	roles.add(role);
	
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return roles;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return email;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}


 
}
