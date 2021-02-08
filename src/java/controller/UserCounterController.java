/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserCounter;
import java.util.concurrent.atomic.AtomicInteger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
;


/**
 *
 * @author Nick
 */
@ManagedBean(name = "userControl")
@ApplicationScoped
public class UserCounterController {


    public int getActiveUser() {
        return UserCounter.getOnlineUsers();
    }





}
