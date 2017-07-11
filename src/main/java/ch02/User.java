package ch02;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by TaeHwan
 * 2017. 7. 11. PM 1:14
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
    protected User(){}

    public User(String email, String name, Date createDate){
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void changeName(String newName){
        this.name = newName;
    }
}
