package WWSIS.teddybears.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "posts")
public class Post {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	public Integer id;

	@ManyToOne
	@Column(name = "user_id")
	public User firstName;

	@Column(name = "content")
	public String content;

	@Column(name = "creation_date")
	public Date creationDate;

	@Column(name = "is_public")
	public Boolean isPublic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFirstName() {
		return firstName;
	}

	public void setFirstName(User firstName) {
		this.firstName = firstName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}	
}