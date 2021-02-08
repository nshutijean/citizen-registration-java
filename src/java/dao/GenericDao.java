/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Nick
 */
public class GenericDao<X>{

   public void create(X d){
       Session ss = HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       ss.save(d);
       ss.getTransaction().commit();
       ss.close();
       
   } 
   
   public void update(X d){
       Session ss = HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       ss.update(d);
       ss.getTransaction().commit();
       ss.close();
   } 
   
   public void delete(X d){
       Session ss = HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       ss.delete(d);
       ss.getTransaction().commit();
       ss.close();
   } 
   
   public List<X> findAll(Class kls){
       Session ss = HibernateUtil.getSessionFactory().openSession();
       Query q = ss.createQuery("from "+kls.getName()+" d");
       List<X> list = q.list();
       ss.close();
       return list;
   }
   
   public X findById(Class kls, String id){
       Session ss = HibernateUtil.getSessionFactory().openSession();
       X obj = (X)ss.get(kls, id);     
       ss.close();
       return obj;
   }
}
