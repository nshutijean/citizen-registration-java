/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Nick
 */
public class UserCounter implements HttpSessionListener{
     private static  AtomicInteger active = new AtomicInteger();    
     private static int i = 1;
      @Override
      public void sessionCreated(HttpSessionEvent se) {  
              active.incrementAndGet();  
              i++;
      }  
      @Override
      public void sessionDestroyed(HttpSessionEvent se) {  
                if(active.get() > 0)  
                       active.decrementAndGet();  
                i--;
           
      }  
     public static int getOnlineUser() {  
             return active.get();  
      }
       public static int getOnlineUsers() {  
             return i;  
      }


    public static void setI(int i) {
        UserCounter.i = i;
    }
    
}
