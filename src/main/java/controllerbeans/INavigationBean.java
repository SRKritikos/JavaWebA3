/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerbeans;

import javax.ejb.Local;

/**
 *
 * @author Steven
 */
@Local
public interface INavigationBean {

  public String goToHome();

  public String goToCatering();
  public String goToCheckout();
}
