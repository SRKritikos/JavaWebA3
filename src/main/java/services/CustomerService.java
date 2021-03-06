/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.dao.CustomerDAOImpl;
import data.entities.Customer;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Steven Kritikos
 */
@Stateless
public class CustomerService implements ICustomerService {

  @EJB
  private CustomerDAOImpl customerDAO;

  @Override
  public boolean saveCustomer(Customer customer) {
    boolean rtVl = this.customerDAO.edit(customer);
    return rtVl;
  }

  @Override
  public Customer getCustomerById(String customerId) {
    Customer rtVl = this.customerDAO.find(customerId);
    return rtVl;
  }

  public void setCustomerDAO(CustomerDAOImpl customerDAO) {
    this.customerDAO = customerDAO;
  }

  @Override
  public Customer getCustomerByName(String username) {
    Customer rtVl = this.customerDAO.getCustomerByName(username);
    return rtVl;
  }

  @Override
  public Customer authenticateCustomer(String username, String password) {
    Customer rtVl = this.customerDAO.getUserByUsernameAndPassword(username, password);
    return rtVl;
  }

}
