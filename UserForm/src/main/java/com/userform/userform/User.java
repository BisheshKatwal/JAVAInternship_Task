/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userform.userform;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Bishesh Katwal
 */

@Named
@SessionScoped
public class User implements Serializable {
    
    //form variables
    private String firstname, middlename, lastname;
    private String faculty, program;
    
    private Map<String, Map<String,String>> data = new HashMap<String, Map<String, String>>();
        
    private Map<String,String> facultyOptions;
    private Map<String,String> programOptions;
    
    private ArrayList<User> userList;
   
    
//getter and setter methods
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Map<String, String> getFacultyOptions() {
        return facultyOptions;
    }
    
    public void setFacultyOptions(Map<String, String> facultyOptions) {
        this.facultyOptions = facultyOptions;
    }

    public Map<String, String> getProgramOptions() {
        return programOptions;
    }

    public void setProgramOptions(Map<String, String> programOptions) {
        this.programOptions = programOptions;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
      
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    
    
    
    
//    Constructor
    public User(){
        
        userList = new ArrayList<>();
        facultyOptions = new HashMap <String,String>();
        facultyOptions.put("Management","Management");
        facultyOptions.put("Science & Technology","Science & Technology");
        
        Map <String, String> map = new HashMap<String,String>();
        map.put("BBA","BBA");
        map.put("BBS", "BBS");
        data.put("Management", map);
        
        Map <String, String> map2 = new HashMap <String, String>();
        map2.put("BSc CSIT", "BSc CSIT");
        map2.put("BE Comp.","BE Comp.");
        map2.put("BCA","BCA");
        data.put("Science & Technology",map2);
        
    }
    
    // method to change program values on selection of faculty
    public void onFacultyChange(){
        if(faculty != null && !faculty.equals(""))
            programOptions = data.get(faculty);
        else
            programOptions = new HashMap<String, String>();
        
       
    }    
   
    // method to pass input values for displaying in datatable
    
    public void updateTable(){
               
        User u = new User();
        
        u.setFirstname(firstname);
        u.setMiddlename(middlename);
        u.setLastname(lastname);
        u.setFaculty(faculty);
        u.setProgram(program);
       
        userList.add(u);
//        clear(u);
        this.firstname = null;
        this.middlename= null;
        this.lastname = null;
        this.faculty = null;
        this.program = null;
                
    }
   

    
    public void deleteRow(User u){
        userList.remove(u);
    }
    
    public void editRow(User u)
    {
        firstname = u.firstname;
        middlename= u.middlename;
        lastname= u.lastname;
        faculty = u.faculty;
        program = u.program;
        deleteRow(u);        
        
    }
    
      

  
}
