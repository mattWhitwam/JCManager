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
public class JobData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="attribID")
    private Attrib attrib;
    
    private String val;

    public JobData(){
    }
    public JobData(Builder builder){
        id = builder.id;
        attrib = builder.attrib;
        val = builder.val;
    }
    public static class Builder {
        private Long id;
        private Attrib attrib;
        private String val;
        public Builder(String val){
            this.val = val;
        }
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        public Builder val(String v){
            this.val = v;
            return this;
        }
        public Builder attrib(Attrib value){
            this.attrib = value;
            return this;
        }
        public Builder jobData(JobData value){
            this.id = value.id;
            this.val = value.val;
            this.attrib = value.attrib;
            return this;
        }
        public JobData build(){
            return new JobData(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return val;
    }

    public void setValue(String val) {
        this.val = val;
    }

    public Attrib getAttribute() {
        return attrib;
    }

    public void setAttribute(Attrib attrib) {
        this.attrib = attrib;
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
        if (!(object instanceof JobData)) {
            return false;
        }
        JobData other = (JobData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.JobData[ id=" + id + " ]";
    }
    
}
