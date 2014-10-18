/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Matthew
 */
@Entity
public class Attrib implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    private String tblName;
    private String fldName;
    private Integer isakey;
    
    @OneToMany//(orphanRemoval=true, cascade= CascadeType.ALL)
    private List<JobCardAttribute> jobCardAttributes;

    @OneToMany//(orphanRemoval=true, cascade= CascadeType.ALL)
    private List<JobData> jobData;

    public Attrib() {
    }
    
    public Attrib(Builder builder) {
        id = builder.id;
        description = builder.description;
        tblName = builder.tblName;
        fldName = builder.fldName;
        if (builder.isakey)
            isakey = 1;
        else
            isakey = 0;
    }

    public static class Builder {    
        private Long id;
        private String description;
        private String tblName;
        private String fldName;
        private Boolean isakey;
        
        public Builder(String description){
            this.description = description;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder tblName(String value){
            this.tblName = value;
            return this;
        }
        public Builder fldName(String value){
            this.fldName = value;
            return this;
        }
        public Builder isakey(Boolean value){
/*            if (value)
                this.isakey = 1;
            else
                this.isakey = 0;*/
            this.isakey = value;
            return this;
        }
        public Builder description(String v){
            this.description = v;
            return this;
        }
        public Builder attrib(Attrib value){
            id = value.getId();
            description = value.getDescription();
            tblName = value.getTableName();
            fldName = value.getField();
            isakey = value.getIskey();
            return this;
        }
        public Attrib build(){
            return new Attrib(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableName() {
        return tblName;
    }

    public void setTableName(String tblName) {
        this.tblName = tblName;
    }

    public String getField() {
        return fldName;
    }

    public void setField(String fldName) {
        this.fldName = fldName;
    }

    public Boolean getIskey() {
        return (isakey == 1);
    }

    public void setIskey(Boolean isakey) {
        //this.isakey = isakey;
        if (isakey)
            this.isakey = 1;
        else
            this.isakey = 0;
    }

    public List<JobCardAttribute> getJobCardAttributes() {
        return jobCardAttributes;
    }

    public void setJobCardAttributes(List<JobCardAttribute> jobCardAttributes) {
        this.jobCardAttributes = jobCardAttributes;
    }

    public List<JobData> getJobData() {
        return jobData;
    }

    public void setJobData(List<JobData> jobData) {
        this.jobData = jobData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fldNames are not set
        if (!(object instanceof Attrib)) {
            return false;
        }
        Attrib other = (Attrib) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.Attribute[ id=" + id + " ]";
    }
    
}
