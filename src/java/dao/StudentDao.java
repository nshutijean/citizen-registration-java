/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Student;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Nick
 */
public class StudentDao extends GenericDao<Student>{
    public List<Student> getNull(){
      Session se = HibernateUtil.getSessionFactory().openSession();
      se.beginTransaction();
      List<Student> li = se.createQuery("from Student e where e.accountStatus=NULL").list();
      return li;
    }
    
    public List<Student> searchByName(String name){
        String searchCriteria = "lastName";
        Session se = HibernateUtil.getSessionFactory().openSession();
        se.beginTransaction();
        List<Student> li = se.createQuery("From Student as rb where rb."+searchCriteria+" like :sf").setString("sf",name+'%').list();
        return li;
    }
        public List<Student> getApprovedStudent(){
      Session se = HibernateUtil.getSessionFactory().openSession();
      se.beginTransaction();
      List<Student> li = se.createQuery("from Student e where e.accountStatus='approved'").list();
      return li;
    }
        public List<Student> getRejectedStudent(){
      Session se = HibernateUtil.getSessionFactory().openSession();
      se.beginTransaction();
      List<Student> li = se.createQuery("from Student e where e.accountStatus='rejected'").list();
      return li;
    }
          public List<Student> searchByNameForApproved(String name){
        String searchCriteria = "lastName";
        Session se = HibernateUtil.getSessionFactory().openSession();
        se.beginTransaction();
        List<Student> li = se.createQuery("From Student as rb where rb."+searchCriteria+" like :sf"+" and rb.accountStatus='approved'").setString("sf",name+'%').list();
        return li;
    }
                public List<Student> searchByNameForRejected(String name){
        String searchCriteria = "lastName";
        Session se = HibernateUtil.getSessionFactory().openSession();
        se.beginTransaction();
        List<Student> li = se.createQuery("From Student as rb where rb."+searchCriteria+" like :sf"+" and rb.accountStatus='rejected'").setString("sf",name+'%').list();
        return li;
    }
                  public List<Student> searchByNameForNewApplicant(String name){
        String searchCriteria = "lastName";
        Session se = HibernateUtil.getSessionFactory().openSession();
        se.beginTransaction();
        List<Student> li = se.createQuery("From Student as rb where rb."+searchCriteria+" like :sf"+" and rb.accountStatus=NULL").setString("sf",name+'%').list();
        return li;
    } 
                 public List<Student> getFemaleApplicant(){
      Session se = HibernateUtil.getSessionFactory().openSession();
      se.beginTransaction();
      List<Student> li = se.createQuery("from Student e where e.gender='FEMALE'").list();
      return li;
    }
                  public List<Student> getMaleApplicant(){
      Session se = HibernateUtil.getSessionFactory().openSession();
      se.beginTransaction();
      List<Student> li = se.createQuery("from Student e where e.gender='MALE'").list();
      return li;
    }
      
}
