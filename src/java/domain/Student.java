/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Nick
 */
@Entity
public class Student extends Person{
    private String program;
    private String accountStatus;
    @OneToOne
    private OlevelSchool ol = new OlevelSchool();
    @OneToOne
    private ElevelSchool el = new ElevelSchool();
    @ManyToOne
    private Department department = new Department();
    @Enumerated(EnumType.STRING)
    private EParentEducationLevel fatherEducation;
     @Enumerated(EnumType.STRING)
    private EParentEducationLevel matherEducation;

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public OlevelSchool getOl() {
        return ol;
    }

    public void setOl(OlevelSchool ol) {
        this.ol = ol;
    }

    public ElevelSchool getEl() {
        return el;
    }

    public void setEl(ElevelSchool el) {
        this.el = el;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public EParentEducationLevel getFatherEducation() {
        return fatherEducation;
    }

    public void setFatherEducation(EParentEducationLevel fatherEducation) {
        this.fatherEducation = fatherEducation;
    }

    public EParentEducationLevel getMatherEducation() {
        return matherEducation;
    }

    public void setMatherEducation(EParentEducationLevel matherEducation) {
        this.matherEducation = matherEducation;
    }
    
    
}
