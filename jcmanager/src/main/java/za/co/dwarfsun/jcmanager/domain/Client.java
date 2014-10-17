/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 
 * @author Matthew
 */
@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany
    @JoinColumn(name="contactPersonId")
    private List<ContactPerson> contactPerson;
    
    @OneToMany
    @JoinColumn(name="siteId")
    private List<Site> site;

    public Client() {
    }
    

    public Client(Builder builder) {
        id = builder.id;
        name = builder.name;
        contactPerson = builder.contactPerson;
        site = builder.site;
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private List<ContactPerson> contactPerson;
        private List<Site> site;

        public Builder(String name) {
            this.name = name;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder contactPerson(List<ContactPerson> value) {
            this.contactPerson = value;
            return this;
        }
        public Builder site(List<Site> value) {
            this.site = value;
            return this;
        }
        public Builder client(Client value){
            id = value.getId();
            name = value.getName();
            contactPerson = value.getContactPerson();
            site = value.getSite();
            return this;
        }
        public Client build(){
            return new Client(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactPerson> getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(List<ContactPerson> contactPerson) {
        this.contactPerson = contactPerson;
    }

    public List<Site> getSite() {
        return site;
    }

    public void setSite(List<Site> site) {
        this.site = site;
    }



    
}
