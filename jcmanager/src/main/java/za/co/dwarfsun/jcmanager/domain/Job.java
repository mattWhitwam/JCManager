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
 * @author Matthew
 */
@Entity
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String info;
    private String status;
    private Boolean complete;

    public Job(){
    }
    
    public Job(Builder builder) {
        id = builder.id;
        info = builder.info;
        status = builder.status;
        complete = builder.complete;
    }
    
    public static class Builder {    
        private Long id;
        private String info;
        private String status;
        private Boolean complete;
    
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder info(String value){
            this.info = value;
            return this;
        }
        
        public Builder status(String value){
            this.status = value;
            return this;
        }
        
        public Builder complete(Boolean value){
            this.complete = value;
            return this;
        }
        
        public Builder Job(Job value){
            id = value.getId();
            info = value.getInfo();
            status = value.getStatus();
            complete = value.isComplete();
            return this;
        }
        public Job build(){
            return new Job(this);
        }
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.Job[ id=" + id + " ]";
    }
    
}
