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
public class JobInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String info;
    private String status;
    private Integer complete;

    public JobInfo(){
    }
    
    public JobInfo(Builder builder) {
        id = builder.id;
        info = builder.info;
        status = builder.status;
        if (builder.complete)
            complete = 1;
        else
            complete = 0;
    }
    
    public static class Builder {    
        private Long id;
        private String info;
        private String status;
        private Boolean complete;
        
        public Builder(String info) {
            this.info = info;
        }
    
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
        
        public Builder jobInfo(JobInfo value){
            id = value.getId();
            info = value.getInfo();
            status = value.getStatus();
            complete = value.isComplete();
            return this;
        }
        public JobInfo build(){
            return new JobInfo(this);
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
        return (complete == 1);
    }

    public void setComplete(Boolean complete) {
        if (complete)
            this.complete = 1;
        else
            this.complete = 0;
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
        if (!(object instanceof JobInfo)) {
            return false;
        }
        JobInfo other = (JobInfo) object;
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
