package WWSIS.teddybears.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	public Integer id;

    @OneToOne
    @JoinColumn(name = "id")
	@Column(name = "follower_id")
	public User follower;
    
    @OneToOne
    @JoinColumn(name = "id")
	@Column(name = "follower_id")
	public User followed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollowed() {
		return followed;
	}

	public void setFollowed(User followed) {
		this.followed = followed;
	}  
}
