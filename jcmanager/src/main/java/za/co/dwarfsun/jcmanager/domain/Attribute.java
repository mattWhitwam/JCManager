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
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String description;
    private String tableName;
    private String field;
    private Boolean iskey;
    
    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    private List<JobCardAttribute> jobCardAttributes;

    @OneToMany(orphanRemoval=true, cascade= CascadeType.ALL)
    private List<JobData> jobData;

    public Attribute() {
    }
    
    public Attribute(Builder builder) {
        id = builder.id;
        description = builder.description;
        tableName = builder.tableName;
        field = builder.field;
        iskey = builder.iskey;
    }

    public static class Builder {    
        private Long id;
        private String description;
        private String tableName;
        private String field;
        private Boolean iskey;
        
        public Builder(String description){
            this.description = description;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder tableName(String value){
            this.tableName = value;
            return this;
        }
        public Builder field(String value){
            this.field = value;
            return this;
        }
        public Builder iskey(Boolean value){
            this.iskey = value;
            return this;
        }
        public Builder Attribute(Attribute value){
            id = value.getId();
            description = value.getDescription();
            tableName = value.getTableName();
            field = value.getField();
            iskey = value.getIskey();
            return this;
        }
        public Attribute build(){
            return new Attribute(this);
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
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getIskey() {
        return iskey;
    }

    public void setIskey(Boolean iskey) {
        this.iskey = iskey;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute other = (Attribute) object;
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
