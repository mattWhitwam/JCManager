/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.UniqueConstraint;
//import org.springframework.hateoas.ResourceSupport;
/**
 *
 * @author Matthew
 */
@Entity
public class JcUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String userName;
    @Basic(optional = false)
    private String password;
    
    public JcUser(){
    }
    
    public JcUser(Builder builder) {
        id = builder.id;
        userName = builder.userName;
        password = builder.password;
    }
    
    public static class Builder {
        private Long id;
        private String userName;
        private String password;
        
        public Builder(String userName){
            this.userName = userName;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userName(String value){
            this.userName = value;
            return this;
        }
        public Builder password(String value){
            this.password = value;
            return this;
        }
        public Builder jcUser(JcUser value){
            id = value.getId();
            userName = value.getUserName();
            password = value.getPassword();
            return this;
        }
        public JcUser build() {
            return new JcUser(this);
        }
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JcUser)) {
            return false;
        }
        JcUser other = (JcUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jcmanager.domain.User[ id=" + id + " ]";
    }
    
}
