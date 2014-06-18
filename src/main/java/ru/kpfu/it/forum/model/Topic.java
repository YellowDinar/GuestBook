package ru.kpfu.it.forum.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "top_id")
    private Long id;

    @Lob
    @Size(min = 20, message = "Минимальный размер лекции 20 символов")
    @Column(name = "top_text")
    private String text;

    @Column(name = "top_created_at")
    private Date createdAt;

    @Column(name = "top_updated_at")
    private Date updatedAt;

    @JsonIgnore
    @OrderBy("createdAt ASC")
    @OneToMany(mappedBy = "topic", fetch=FetchType.EAGER)
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
