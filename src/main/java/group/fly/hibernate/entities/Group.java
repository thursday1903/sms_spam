package group.fly.hibernate.entities;

// default package
// Generated May 17, 2022, 10:11:26 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group_tele")
public class Group implements java.io.Serializable {

	private Long groupId;
	private String groupName;
	private String idBotJoined;
	private Date createdAt;
	private Date updatedAt;
	private Long chatId;
	private Integer totalMember;
	

	public Group() {
	}

	public Group(String groupName, String idBotJoined, Date createdAt, Date updatedAt, Long chatId) {
		this.groupName = groupName;
		this.idBotJoined = idBotJoined;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.chatId = chatId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "group_id", unique = true, nullable = false)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "id_bot_joined")
	public String getIdBotJoined() {
		return this.idBotJoined;
	}

	public void setIdBotJoined(String idBotJoined) {
		this.idBotJoined = idBotJoined;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 19)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "chat_id")
	public Long getChatId() {
		return this.chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

	
	@Column(name = "total_member")
	public Integer getTotalMember() {
		return totalMember;
	}

	public void setTotalMember(Integer totalMember) {
		this.totalMember = totalMember;
	}

	
}
