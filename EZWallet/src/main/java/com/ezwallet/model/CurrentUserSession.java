package com.ezwallet.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {
 
	@Id
	@Column(unique=true)
	private String UserId;
	private String uuid;
	private LocalDateTime localdatetime;

	
	
//	public CurrentUserSession() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public CurrentUserSession(String userId, String uuid, LocalDateTime localdatetime) {
//		super();
//		UserId = userId;
//		this.uuid = uuid;
//		this.localdatetime = localdatetime;
//	}
//	public String getUserId() {
//		return UserId;
//	}
//	public void setUserId(String userId) {
//		UserId = userId;
//	}
//	public String getUuid() {
//		return uuid;
//	}
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
//	public LocalDateTime getLocaldatetime() {
//		return localdatetime;
//	}
//	public void setLocaldatetime(LocalDateTime localdatetime) {
//		this.localdatetime = localdatetime;
//	}
//	@Override
//	public String toString() {
//		return "CurrentUserSession [UserId=" + UserId + ", uuid=" + uuid + ", localdatetime=" + localdatetime + "]";
//	}
//	
//	
}
