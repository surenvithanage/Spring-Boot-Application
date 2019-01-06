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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="techguy"
)
public class Role  implements java.io.Serializable {


     private Integer roleid;
     private String name;
     private Set<Privilege> privileges = new HashSet<Privilege>(0);
     private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

    public Role(String name, Set<Privilege> privileges, Set<User> users) {
       this.name = name;
       this.privileges = privileges;
       this.users = users;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="roleid", unique=true, nullable=false)
    public Integer getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<Privilege> getPrivileges() {
        return this.privileges;
    }
    
    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }




}

