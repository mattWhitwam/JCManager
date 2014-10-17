/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.co.dwarfsun.jcmanager.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Matthew
 */
@Entity
public class AuditTrail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tod;
    
    private String type;
    private String tableName;
    private String field;
    private String username;
    private String oldValue;
    private String newValue;

    public AuditTrail(){
    }
    public AuditTrail(Builder builder){
        id = builder.id;
        tod = builder.tod;
        type = builder.type;
        tableName = builder.tableName;
        field = builder.field;
        username = builder.username;
        oldValue = builder.oldValue;
        newValue = builder.newValue;
    }

    public static class Builder {    
        private Long id;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date tod;
        private String type;
        private String tableName;
        private String field;
        private String username;
        private String oldValue;
        private String newValue;
        
        public Builder(Date tod){
            this.tod=tod;
        }
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        public Builder type(String value){
            this.type=value;
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
        public Builder username(String value){
            this.username = value;
            return this;
        }
        public Builder oldValue(String value){
            this.oldValue = value;
            return this;
        }
        public Builder newValue(String value){
            this.newValue = value;
            return this;
        }
        public Builder AuditTrail(AuditTrail value){
            this.id = value.id;
            this.tod = value.tod;
            this.type = value.type;
            this.tableName = value.tableName;
            this.field = value.field;
            this.username = value.username;
            this.oldValue = value.oldValue;
            this.newValue = value.newValue;
            return this;
        }
        public AuditTrail build(){
            return new AuditTrail(this);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTod() {
        return tod;
    }

    public void setTod(Date tod) {
        this.tod = tod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTable() {
        return tableName;
    }

    public void setTable(String tableName) {
        this.tableName = tableName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
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
        if (!(object instanceof AuditTrail)) {
            return false;
        }
        AuditTrail other = (AuditTrail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.dwarfsun.jobcardmanager.model.AuditTrail[ id=" + id + " ]";
    }
    
}
