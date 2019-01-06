package com.techguy.application.model;
// Generated Jan 3, 2019 9:27:06 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cvdata generated by hbm2java
 */
@Entity
@Table(name="cvdata"
    ,catalog="techguy"
)
public class Cvdata  implements java.io.Serializable {


     private Long cvDataId;
     private String surname;
     private String initials;
     private String addressLineOne;
     private String addressLineTwo;
     private String city;
     private String province;
     private String cityCode;
     private String country;
     private String linkedInAddress;
     private String githubAddress;
     private String position;
     private Set<Project> projects = new HashSet<Project>(0);
     private Set<User> users = new HashSet<User>(0);
     private Set<Technology> technologies = new HashSet<Technology>(0);
     private Set<Referee> referees = new HashSet<Referee>(0);
     private Set<Experience> experiences = new HashSet<Experience>(0);

    public Cvdata() {
    }

    public Cvdata(String surname, String initials, String addressLineOne, String addressLineTwo, String city, String province, String cityCode, String country, String linkedInAddress, String githubAddress, String position, Set<Project> projects, Set<User> users, Set<Technology> technologies, Set<Referee> referees, Set<Experience> experiences) {
       this.surname = surname;
       this.initials = initials;
       this.addressLineOne = addressLineOne;
       this.addressLineTwo = addressLineTwo;
       this.city = city;
       this.province = province;
       this.cityCode = cityCode;
       this.country = country;
       this.linkedInAddress = linkedInAddress;
       this.githubAddress = githubAddress;
       this.position = position;
       this.projects = projects;
       this.users = users;
       this.technologies = technologies;
       this.referees = referees;
       this.experiences = experiences;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cvDataId", unique=true, nullable=false)
    public Long getCvDataId() {
        return this.cvDataId;
    }
    
    public void setCvDataId(Long cvDataId) {
        this.cvDataId = cvDataId;
    }

    
    @Column(name="surname", length=45)
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    
    @Column(name="initials", length=45)
    public String getInitials() {
        return this.initials;
    }
    
    public void setInitials(String initials) {
        this.initials = initials;
    }

    
    @Column(name="addressLineOne", length=45)
    public String getAddressLineOne() {
        return this.addressLineOne;
    }
    
    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    
    @Column(name="addressLineTwo", length=45)
    public String getAddressLineTwo() {
        return this.addressLineTwo;
    }
    
    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    
    @Column(name="city", length=45)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="province", length=45)
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }

    
    @Column(name="cityCode", length=45)
    public String getCityCode() {
        return this.cityCode;
    }
    
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    
    @Column(name="country", length=45)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="linkedInAddress", length=50)
    public String getLinkedInAddress() {
        return this.linkedInAddress;
    }
    
    public void setLinkedInAddress(String linkedInAddress) {
        this.linkedInAddress = linkedInAddress;
    }

    
    @Column(name="githubAddress", length=50)
    public String getGithubAddress() {
        return this.githubAddress;
    }
    
    public void setGithubAddress(String githubAddress) {
        this.githubAddress = githubAddress;
    }

    
    @Column(name="position", length=45)
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cvdata")
    public Set<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cvdata")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="technology_has_cvdata", catalog="techguy", joinColumns = { 
        @JoinColumn(name="CVData_cvDataId", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Technology_technologyId", nullable=false, updatable=false) })
    public Set<Technology> getTechnologies() {
        return this.technologies;
    }
    
    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cvdata")
    public Set<Referee> getReferees() {
        return this.referees;
    }
    
    public void setReferees(Set<Referee> referees) {
        this.referees = referees;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cvdata")
    public Set<Experience> getExperiences() {
        return this.experiences;
    }
    
    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }




}


