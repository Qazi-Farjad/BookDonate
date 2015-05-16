package POJOS;
// Generated May 15, 2015 6:55:47 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name="transaction"
    ,catalog="donation"
)
public class Transaction  implements java.io.Serializable {


     private Integer transId;
     private Matchmaker matchmakerByDonorId;
     private Matchmaker matchmakerByRecId;
     private Date date;

    public Transaction() {
    }

	
    public Transaction(Matchmaker matchmakerByDonorId, Matchmaker matchmakerByRecId) {
        this.matchmakerByDonorId = matchmakerByDonorId;
        this.matchmakerByRecId = matchmakerByRecId;
    }
    public Transaction(Matchmaker matchmakerByDonorId, Matchmaker matchmakerByRecId, Date date) {
       this.matchmakerByDonorId = matchmakerByDonorId;
       this.matchmakerByRecId = matchmakerByRecId;
       this.date = date;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="TransId", unique=true, nullable=false)
    public Integer getTransId() {
        return this.transId;
    }
    
    public void setTransId(Integer transId) {
        this.transId = transId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DonorId", nullable=false)
    public Matchmaker getMatchmakerByDonorId() {
        return this.matchmakerByDonorId;
    }
    
    public void setMatchmakerByDonorId(Matchmaker matchmakerByDonorId) {
        this.matchmakerByDonorId = matchmakerByDonorId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RecId", nullable=false)
    public Matchmaker getMatchmakerByRecId() {
        return this.matchmakerByRecId;
    }
    
    public void setMatchmakerByRecId(Matchmaker matchmakerByRecId) {
        this.matchmakerByRecId = matchmakerByRecId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="Date", length=10)
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}

