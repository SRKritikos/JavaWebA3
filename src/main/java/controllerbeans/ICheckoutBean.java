/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

/**
 *
 * @author Steven
 */
public interface ICheckoutBean {
  public UserBean getUserbean();
  public void setUserbean(UserBean userbean);
  public String getCanCheckoutClass();
  public void setCanCheckoutClass(String canCheckoutClass);
}
