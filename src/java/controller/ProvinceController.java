/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProvinceDao;
import domain.Province;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nick
 */
@ManagedBean(name = "provControl")
public class ProvinceController {
    private Province province = new Province();

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    public void saveProvince(){
       
      new ProvinceDao().create(province);
        FacesContext c = FacesContext.getCurrentInstance();
            c.addMessage(null, new FacesMessage("province saved")); 
    }
    
}
