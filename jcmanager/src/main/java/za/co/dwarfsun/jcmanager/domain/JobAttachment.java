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
public class JobAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filePath;

    public JobAttachment(){
    }
    
    public JobAttachment(Builder builder) {
        id = builder.id;
        filePath = builder.filePath;
    }
    
    public static class Builder {    
        private Long id;
        private String filePath;
        
        public Builder(String filePath){
            this.filePath = filePath;
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder filePath(String value){
            this.filePath = value;
            return this;
        }
        
        public Builder JobAttachment(JobAttachment value){
            id = value.getId();
            filePath = value.getFilePath();
            return this;
        }
        public JobAttachment build(){
            return new JobAttachment(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        if (!(object instanceof JobAttachment)) {
            return false;
        }
        JobAttachment other = (JobAttachment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.JobAttachment[ id=" + id + " ]";
    }
    
}
