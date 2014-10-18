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
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    
    @OneToMany
    @JoinColumn(name="jobId")
    private List<JobInfo> job;

    public Site() {
    }

    public Site(Builder builder) {
        id = builder.id;
        name = builder.name;
        address = builder.address;
        job = builder.job;
    }
    
    public static class Builder {
        private Long id;
        private String name;
        private String address;
        private List<JobInfo> job;
        
        public Builder(String name){
            this.name = name;
        }
        public Builder id(Long v){
            this.id = v;
            return this;
        }
        public Builder name(String v){
            this.name = v;
            return this;
        }
        public Builder address(String v){
            this.address = v;
            return this;
        }
        public Builder job(List<JobInfo> v){
            this.job = v;
            return this;
        }
        public Builder site(Site v){
            id = v.id;
            name = v.name;
            address = v.address;
            job = v.job;
            return this;
        }
        public Site build(){
            return new Site(this);
        }
    }

    public List<JobInfo> getJob() {
        return job;
    }

    public void setJob(List<JobInfo> job) {
        this.job = job;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.Site[ id=" + id + " ]";
    }
    
}
