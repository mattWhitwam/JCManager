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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Matthew
 */
@Entity
public class JobCardAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int lineNum;
    @ManyToOne
    @JoinColumn(name="AttribId")
    private Attrib attrib;

    @ManyToOne
    @JoinColumn(name="JobCardId")
    private JobCard jobCard;

    public JobCardAttribute(){
    }
    public JobCardAttribute(Builder builder){
        id = builder.id;
        lineNum = builder.lineNum;
        attrib = builder.attrib;
        jobCard = builder.jobCard;
    }

    public static class Builder {
        private Long id;
        private int lineNum;
        private Attrib attrib;
        private JobCard jobCard;
        
        public Builder(int lineNum){
            this.lineNum = lineNum;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder lineNum(int v){
            this.lineNum = v;
            return this;
        }
        public Builder attrib(Attrib value){
            this.attrib = value;
            return this;
        }
        public Builder jobCard(JobCard value){
            this.jobCard = value;
            return this;
        }
        public Builder jobCardAttribute(JobCardAttribute value){
            this.id = value.id;
            this.lineNum = value.lineNum;
            this.attrib = value.attrib;
            this.jobCard = value.jobCard;
            return this;
        }
        public JobCardAttribute build(){
            return new JobCardAttribute(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public Attrib getAttrib() {
        return attrib;
    }

    public void setAttrib(Attrib attrib) {
        this.attrib = attrib;
    }

    public JobCard getJobCard() {
        return jobCard;
    }

    public void setJobCard(JobCard jobCard) {
        this.jobCard = jobCard;
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
        if (!(object instanceof JobCardAttribute)) {
            return false;
        }
        JobCardAttribute other = (JobCardAttribute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.JobCardAttribute[ id=" + id + " ]";
    }
    
}
