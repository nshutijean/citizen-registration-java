/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DepartmentDao;
import dao.DistrictDao;
import dao.ElevelDao;
import dao.FacultyDao;
import dao.OlevelDao;
import dao.ProvinceDao;
import dao.StudentDao;
import dao.UserCounter;
import domain.Department;
import domain.District;
import domain.EGender;
import domain.EParentEducationLevel;
import domain.EStatus;
import domain.ElevelSchool;
import domain.Faculty;
import domain.OlevelSchool;
import domain.Province;
import domain.Student;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author Nick
 */
@ManagedBean(name = "sc",eager = true)
@SessionScoped
public class StudentController {
    private StudentDao stDao = new StudentDao();
    private Student student = new Student();
    private String toi = new String();
    private List<Province> li = new ArrayList<>();
    private List<District> lii = new ArrayList<>();
    private List<Department> liii = new ArrayList<>();
    private String useFaculty = new String();
    private List<Student> students = new ArrayList<>();
    private List<Student> studentsFromSearch = new ArrayList<>();
    private List<Student> approvedStudent = new ArrayList<>();
    private List<Student> rejectedStudent = new ArrayList<>();
    private List<Student> newApplicant = newApplicant = new StudentDao().getNull();
    private String searchString;
    private String searchStringChanged;
    private int rejectedNumber ;
     private int approvedNumber ;
     private int newApplicantNumber ;
      private int femaleApplicant ;
     private int maleApplicant ;
    public StudentController() {
        li = new ProvinceDao().findAll(Province.class);
        students = new StudentDao().findAll(Student.class);
        lii = new DistrictDao().findAll(District.class);
        approvedStudent = new StudentDao().getApprovedStudent();
        rejectedStudent = new StudentDao().getRejectedStudent();
        newApplicant = new StudentDao().getNull();
        rejectedNumber = new StudentDao().getRejectedStudent().size();
        approvedNumber = new StudentDao().getApprovedStudent().size();
        newApplicantNumber = new StudentDao().getNull().size();
        femaleApplicant = new StudentDao().getFemaleApplicant().size();
        maleApplicant = new StudentDao().getMaleApplicant().size();
    }
    
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
   public List<String> getTGender(){
    List<String> li = new ArrayList<>();
    for(EGender temp:EGender.values()){
      li.add(temp.toString());
    }
    return li;
   } 
    public List<String> getTStatus(){
    List<String> li = new ArrayList<>();
    for(EStatus temp:EStatus.values()){
      li.add(temp.toString());
    }
    return li;
   } 

    public String getToi() {
        return toi;
    }

    public void setToi(String toi) {
        this.toi = toi;
    }


    public void initDistrict(){
      lii = new ProvinceDao().findById(Province.class, toi).getDistrict();
    }
     public void initDepartment(){
      liii = new FacultyDao().findById(Faculty.class, useFaculty).getDepartments();
    }

    public List<Province> getLi() {
        return li;
    }

    public void setLi(List<Province> li) {
        this.li = li;
    }

    public List<District> getLii() {
        return lii;
    }

    public void setLii(List<District> lii) {
        this.lii = lii;
    }

    public String getUseFaculty() {
        return useFaculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public void setUseFaculty(String useFaculty) {
        this.useFaculty = useFaculty;
    }
   public List<Faculty> getFacultyList(){
     List<Faculty> li = new FacultyDao().findAll(Faculty.class);
     return li;
   } 

    public List<Department> getLiii() {
        return liii;
    }

    public void setLiii(List<Department> liii) {
        this.liii = liii;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<Student> getStudentsFromSearch() {
        return studentsFromSearch;
    }

    public void setStudentsFromSearch(List<Student> studentsFromSearch) {
        this.studentsFromSearch = studentsFromSearch;
    }

    public String getSearchStringChanged() {
        return searchStringChanged;
    }

    public void setSearchStringChanged(String searchStringChanged) {
        this.searchStringChanged = searchStringChanged;
    }

    public List<Student> getApprovedStudent() {
        return approvedStudent;
    }

    public void setApprovedStudent(List<Student> approvedStudent) {
        this.approvedStudent = approvedStudent;
    }

    public List<Student> getRejectedStudent() {
        return rejectedStudent;
    }

    public void setRejectedStudent(List<Student> rejectedStudent) {
        this.rejectedStudent = rejectedStudent;
    }

    public List<Student> getNewApplicant() {
        return newApplicant;
    }

    public void setNewApplicant(List<Student> newApplicant) {
        this.newApplicant = newApplicant;
    }

    public int getRejectedNumber() {
        return rejectedNumber;
    }

    public void setRejectedNumber(int rejectedNumber) {
        this.rejectedNumber = rejectedNumber;
    }

    public int getApprovedNumber() {
        return approvedNumber;
    }

    public void setApprovedNumber(int approvedNumber) {
        this.approvedNumber = approvedNumber;
    }

    public int getNewApplicantNumber() {
        return newApplicantNumber;
    }

    public void setNewApplicantNumber(int newApplicantNumber) {
        this.newApplicantNumber = newApplicantNumber;
    }

    public int getFemaleApplicant() {
        return femaleApplicant;
    }

    public void setFemaleApplicant(int femaleApplicant) {
        this.femaleApplicant = femaleApplicant;
    }

    public int getMaleApplicant() {
        return maleApplicant;
    }

    public void setMaleApplicant(int maleApplicant) {
        this.maleApplicant = maleApplicant;
    }
    
    
   public String saveStudent(){
       try {
            ElevelSchool d = new ElevelSchool();
            d.setSchoolName(student.getEl().getSchoolName());
            d.setStartYear(student.getEl().getStartYear());
            d.setEndYear(student.getEl().getEndYear());
            d.setMarks(student.getEl().getMarks());
            OlevelSchool di = new OlevelSchool();
            di.setSchoolName(student.getOl().getSchoolName());
            di.setStartYear(student.getOl().getStartYear());
            di.setEndYear(student.getOl().getEndYear());
            
            new ElevelDao().create(d);
            new OlevelDao().create(di);
            student.setEl(d);
            student.setOl(di);
            new StudentDao().create(student);
              newApplicant = new StudentDao().getNull();
             FacesContext c = FacesContext.getCurrentInstance();
            c.addMessage(null, new FacesMessage("student saved"));
            return "successPage";
       } catch (Exception e) {
          FacesContext c = FacesContext.getCurrentInstance();
            c.addMessage(null, new FacesMessage(e.getMessage())); 
            return "preview";
       }
    
   }
   public String getDepartmentName(String name){
       return new DepartmentDao().findById(Department.class,name).getName();
   }
   
    public String getDate(Date date1) {
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        String date = format.format(date1);
        return date;
    }
    public void approve(Student st){
        st.setAccountStatus("approved");
      new StudentDao().update(st);
      newApplicant = new StudentDao().searchByNameForNewApplicant("");  
    }
    public void reject(Student st){
      st.setAccountStatus("rejected");
       new StudentDao().update(st);
       newApplicant = new StudentDao().searchByNameForNewApplicant("");  
    }
    
    public void searchByTitle(String title)
{
   students = new StudentDao().searchByName(title);
   approvedStudent = new StudentDao().searchByNameForApproved(title);
   rejectedStudent = new StudentDao().searchByNameForRejected(title);
   newApplicant = new StudentDao().searchByNameForNewApplicant(title);
}
    public void searchStringValueChanged(ValueChangeEvent vce)
{
    searchByTitle((String) vce.getNewValue());
}
  public int getOnlineUsers(){
    return UserCounter.getOnlineUser();
  } 
   public int getOnlineUsersi(){
    return UserCounter.getOnlineUsers();
  }  
   public void reduceSession(){
     UserCounter.setI(UserCounter.getOnlineUsers()-1);
   }
   public String giveProvinceOnPreview(String id){
       return new DistrictDao().findById(District.class, id).getProvince().getName();
    }
    public String giveDistrictOnPreview(String id){
       return new DistrictDao().findById(District.class, id).getName();
    }
        public List<String> getParentEducation(){
    List<String> li = new ArrayList<>();
    for(EParentEducationLevel temp:EParentEducationLevel.values()){
      li.add(temp.toString());
    }
    return li;
   } 
        
        public String getStudentScore(Double marks){
           if(marks >= 80.0){
              return "Grand Distinction";
           }else if(70 <= marks && marks < 80){
            return "Distinction";
           }
           else if(60 <= marks && marks < 70){
              return "Satisfaction";
           }else if(50 <= marks  && marks <60){
                 return "Pass";
             }else{
                   return "Fail";
                   }
        }
}
