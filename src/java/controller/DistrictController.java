/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DistrictDao;
import dao.ProvinceDao;
import domain.District;
import domain.Province;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nick
 */
@ManagedBean(name = "disControl")
public class DistrictController {
    private String provId ;
    private District district = new District();
    private List<Province> provList = new ArrayList<>();

    public DistrictController() {
        provList = new ProvinceDao().findAll(Province.class);
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }
    
    
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Province> getProvList() {
        return provList;
    }

    public void setProvList(List<Province> provList) {
        this.provList = provList;
    }
   public void saveDistrict(){
       
      new DistrictDao().create(district);
     
       FacesContext c = FacesContext.getCurrentInstance();
            c.addMessage(null, new FacesMessage("province saved"));
   }
  
}
