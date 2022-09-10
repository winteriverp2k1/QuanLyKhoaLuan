/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "positionforthesis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Positionforthesis.findAll", query = "SELECT p FROM Positionforthesis p"),
    @NamedQuery(name = "Positionforthesis.findById", query = "SELECT p FROM Positionforthesis p WHERE p.id = :id"),
    @NamedQuery(name = "Positionforthesis.findByName", query = "SELECT p FROM Positionforthesis p WHERE p.name = :name")})
public class Positionforthesis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "thesisPosition")
    private Set<ThesisPosition> thesisPositionSet;

    public Positionforthesis() {
    }

    public Positionforthesis(Integer id) {
        this.id = id;
    }

    public Positionforthesis(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<ThesisPosition> getThesisPositionSet() {
        return thesisPositionSet;
    }

    public void setThesisPositionSet(Set<ThesisPosition> thesisPositionSet) {
        this.thesisPositionSet = thesisPositionSet;
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
        if (!(object instanceof Positionforthesis)) {
            return false;
        }
        Positionforthesis other = (Positionforthesis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.duy.pojo.Positionforthesis[ id=" + id + " ]";
    }
    
}
