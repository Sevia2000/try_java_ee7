/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprisegeeks.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 * ユーザーアカウント
 */
@Entity
@NamedQueries(
@NamedQuery(name = "Account.nameOrEmali", query = "select a from Account a where a.name = :name or a.email = :email")
)
public class Account implements Serializable{
    
    @NotNull(message = "{required}")
    @Size(message = "{required}", min = 1) // 未入力の場合、空文字になるため。
    @Id
    @Column(length = 40)
    private String name;
    
    @Email(message = "{email.invalid}")
    @NotNull(message = "{required}")
    @Size(message = "{required}", min = 1)
    @Column(length = 200, unique = true, nullable = false)
    private String email;
    
    @Column(length = 32, nullable = true )
    private String gravaterHash;
    
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

    public String getGravaterHash() {
        return gravaterHash;
    }

    public void setGravaterHash(String gravaterHash) {
        this.gravaterHash = gravaterHash;
    }
    
    public String getGravatar() {
        return "https://www.gravatar.com/avatar/" + gravaterHash;
    }
}
