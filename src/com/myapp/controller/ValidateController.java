package com.myapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.helper.DBHelper;
import com.myapp.pojo.Users;

@Controller
public class ValidateController {
	public Connection connection=null;
	public PreparedStatement statement=null;
	public ResultSet resultset=null;
	
@RequestMapping("/login0.htm")
public ModelAndView log0(ModelMap m){
	ModelAndView mv= new ModelAndView();
	Users u1=new Users();
	m.addAttribute("user1", u1);
	mv.setViewName("login.jsp");	
	return mv;
	
}

@RequestMapping("/login.htm")
public ModelAndView log(@ModelAttribute("user1") Users u1) throws ClassNotFoundException, SQLException{
	ModelAndView mv= new ModelAndView();
	String id= u1.getId();
	String password=u1.getPassword();
	
	connection=DBHelper.createConnection();
	statement=connection.prepareStatement("select * from users where id=? and password=?");
	statement.setString(1, id);
	statement.setString(2,password);
	resultset=statement.executeQuery();
	int count=0;
	while(resultset.next()){
		count++;
	}
	if (count>0)
		mv.setViewName("success.jsp");
	else
		mv.setViewName("failure.jsp");
	
	return mv;		
}
}
