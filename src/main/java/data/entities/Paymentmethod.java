/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Steven Kritikos
 * email: stevenrktitikos@outlook.com
 */
@Entity
@Table(name = "paymentmethod")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Paymentmethod.findAll", query = "SELECT p FROM Paymentmethod p"),
  @NamedQuery(name = "Paymentmethod.findByPaymentMethodId", query = "SELECT p FROM Paymentmethod p WHERE p.paymentMethodId = :paymentMethodId"),
  @NamedQuery(name = "Paymentmethod.findByCardNumber", query = "SELECT p FROM Paymentmethod p WHERE p.cardNumber = :cardNumber"),
  @NamedQuery(name = "Paymentmethod.findByCardCvv", query = "SELECT p FROM Paymentmethod p WHERE p.cardCvv = :cardCvv"),
  @NamedQuery(name = "Paymentmethod.findByDateTo", query = "SELECT p FROM Paymentmethod p WHERE p.dateTo = :dateTo"),
  @NamedQuery(name = "Paymentmethod.findByIsPreferred", query = "SELECT p FROM Paymentmethod p WHERE p.isPreferred = :isPreferred"),
  @NamedQuery(name = "Paymentmethod.findByPaymentType", query = "SELECT p FROM Paymentmethod p WHERE p.paymentType = :paymentType")})
public class Paymentmethod implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "payment_method_id")
  private String paymentMethodId;
  @Size(max = 64)
  @Column(name = "card_number")
  private String cardNumber;
  @Size(max = 3)
  @Column(name = "card_cvv")
  private String cardCvv;
  @Column(name = "date_to")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateTo;
  @Column(name = "isPreferred")
  private Boolean isPreferred;
  @Size(max = 15)
  @Column(name = "payment_type")
  private String paymentType;
  @OneToMany(mappedBy = "paymentMethodId", fetch = FetchType.EAGER)
  private List<Cateringorder> cateringorderList;
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Customer customerId;

  public Paymentmethod() {
  }

  public Paymentmethod(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }

  public String getPaymentMethodId() {
    return paymentMethodId;
  }

  public void setPaymentMethodId(String paymentMethodId) {
    this.paymentMethodId = paymentMethodId;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardCvv() {
    return cardCvv;
  }

  public void setCardCvv(String cardCvv) {
    this.cardCvv = cardCvv;
  }

  public Date getDateTo() {
    return dateTo;
  }

  public void setDateTo(Date dateTo) {
    this.dateTo = dateTo;
  }

  public Boolean getIsPreferred() {
    return isPreferred;
  }

  public void setIsPreferred(Boolean isPreferred) {
    this.isPreferred = isPreferred;
  }

  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  @XmlTransient
  public List<Cateringorder> getCateringorderList() {
    return cateringorderList;
  }

  public void setCateringorderList(List<Cateringorder> cateringorderList) {
    this.cateringorderList = cateringorderList;
  }

  public Customer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Customer customerId) {
    this.customerId = customerId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Paymentmethod)) {
      return false;
    }
    Paymentmethod other = (Paymentmethod) object;
    if ((this.paymentMethodId == null && other.paymentMethodId != null) || (this.paymentMethodId != null && !this.paymentMethodId.equals(other.paymentMethodId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "data.entities.Paymentmethod[ paymentMethodId=" + paymentMethodId + " ]";
  }

}
