/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.prism.impl.BaseMesh;
import dao.DepartmentDao;
import dao.DistrictDao;
import dao.FacultyDao;
import dao.GenericDao;
import dao.ProvinceDao;
import dao.StudentDao;
import domain.Department;
import domain.District;
import domain.EGender;
import domain.Faculty;
import domain.Province;
import domain.Student;
import java.util.ArrayList;
import java.util.List;
import util.HibernateUtil;

/**
 *
 * @author Nick
 */
public class main {
    public static void main(String[] args) {
      Faculty fa = new FacultyDao().findById(Faculty.class, "F002");
       Department d = new Department();
       d.setId("D003");
       d.setName("finance");
           d.setFaculty(fa);
       new DepartmentDao().create(d);
    }
    }
