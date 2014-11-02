/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Connie
 */
@Entity
public class ContactPerson extends Person implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    public ContactPerson() {
    }
    public ContactPerson(Builder builder) {
        id = builder.id;
        description = builder.description;
        setTitle(builder.title);
        setFirstname(builder.firstname);
        setLastname(builder.lastname);
        setEmail(builder.email);
        setPhone(builder.phone);
    }
    
    public static class Builder {
        private Long id;
        private String description;
        private String title;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;
        
        public Builder(String description) {
            this.description = description;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder description(String value){
            this.description = value;
            return this;
        }
        public Builder title(String value){
            this.title = value;
            return this;
        }
        public Builder firstname(String v){
            this.firstname = v;
            return this;
        }
        public Builder lastname(String v){
            this.lastname = v;
            return this;
        }
        public Builder email(String v){
            this.email = v;
            return this;
        }
        public Builder phone(String v){
            this.phone = v;
            return this;
        }
        public Builder person (Person value){
            this.title = value.getTitle();
            this.firstname = value.getFirstname();
            this.lastname = value.getLastname();
            this.email = value.getEmail();
            this.phone = value.getPhone();
            return this;
        }
        public Builder contactPerson(ContactPerson value){
            id = value.id;
            description = value.description;
            title = value.getTitle();
            firstname = value.getFirstname();
            lastname = value.getLastname();
            email = value.getEmail();
            phone = value.getPhone();
            return this;
        }
        public ContactPerson build(){
            return new ContactPerson(this);
        }
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof ContactPerson)) {
            return false;
        }
        ContactPerson other = (ContactPerson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.ContactPerson[ id=" + id + " ]";
    }
    
}
