package cn.edu.lingnan.shop.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COMMENTS", schema = "ONLINESHOP")

public class Comments implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private Product product;
	private String content;
	private Date commentdate;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** full constructor */
	public Comments(User user, Product product, String content, Date commentdate) {
		this.user = user;
		this.product = product;
		this.content = content;
		this.commentdate = commentdate;
	}

	// Property accessors
	@SequenceGenerator(name = "generator_comments",allocationSize=1,sequenceName="seq_comm")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator_comments")

	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCTID")

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "CONTENT", length = 100)

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COMMENTDATE", length = 7)

	public Date getCommentdate() {
		return this.commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

}