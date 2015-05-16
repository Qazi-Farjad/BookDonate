package POJOS;
// Generated May 15, 2015 6:55:47 PM by Hibernate Tools 4.3.1


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
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="donation"
)
public class User  implements java.io.Serializable {


     private Integer id;
     private String name;
     private byte[] organization;
     private String email;
     private String password;
     private String address;
     private String city;
     private String country;
     private byte[] verification;
     private Set matchmakers = new HashSet(0);

    public User() {
    }

	
    public User(String name, byte[] organization, String email, String password, String city, String country, byte[] verification) {
        this.name = name;
        this.organization = organization;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.verification = verification;
    }
    public User(String name, byte[] organization, String email, String password, String address, String city, String country, byte[] verification, Set matchmakers) {
       this.name = name;
       this.organization = organization;
       this.email = email;
       this.password = password;
       this.address = address;
       this.city = city;
       this.country = country;
       this.verification = verification;
       this.matchmakers = matchmakers;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="Name", nullable=false, length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="Organization", nullable=false)
    public byte[] getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(byte[] organization) {
        this.organization = organization;
    }

    
    @Column(name="Email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="Password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="Address", length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="City", nullable=false, length=45)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="Country", nullable=false, length=45)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    
    @Column(name="Verification", nullable=false)
    public byte[] getVerification() {
        return this.verification;
    }
    
    public void setVerification(byte[] verification) {
        this.verification = verification;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set getMatchmakers() {
        return this.matchmakers;
    }
    
    public void setMatchmakers(Set matchmakers) {
        this.matchmakers = matchmakers;
    }




}

