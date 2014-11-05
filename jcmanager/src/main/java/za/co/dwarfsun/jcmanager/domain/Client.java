/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    
    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(name="ClientId")
    private List<ContactPerson> contactPersons;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="ClientId")
    private List<Site> sites;

    public Client() {
    }
    

    public Client(Builder builder) {
        id = builder.id;
        name = builder.name;
        contactPersons = builder.contactPersons;
        sites = builder.sites;
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private List<ContactPerson> contactPersons;
        private List<Site> sites;

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
            this.contactPersons = value;
            return this;
        }
        public Builder site(List<Site> value) {
            this.sites = value;
            return this;
        }
        public Builder client(Client value){
            id = value.getId();
            name = value.getName();
            contactPersons = value.getContactPersons();
            sites = value.getSites();
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

    public List<ContactPerson> getContactPersons() {
        return contactPersons;
    }
    
    public void addContactPerson(ContactPerson contactPerson) {
        this.contactPersons.add(contactPerson);
    }

    public void setContactPersons(List<ContactPerson> contactPersons) {
        this.contactPersons = contactPersons;
    }

    public List<Site> getSites() {
        return sites;
    }
    
    public void addSite(Site site){
        this.sites.add(site);
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }



    
}
