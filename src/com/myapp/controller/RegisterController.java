package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.helper.DBHelper;
import com.myapp.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class RegisterController {
	public Connection connection=null;
	public PreparedStatement statement=null;
	public PreparedStatement statement1=null;
	public ResultSet resultset=null;
	DBHelper dbhelper=new DBHelper();
	
@RequestMapping("/register0.htm")
public ModelAndView reg0(ModelMap m){
	ModelAndView mv= new ModelAndView();
	Users u=new Users();
	m.addAttribute("user", u);
	mv.setViewName("register.jsp");	
	return mv;
}

@RequestMapping("/register.htm")
public ModelAndView reg(@ModelAttribute("user")Users u) throws SQLException, ClassNotFoundException{
	ModelAndView mv= new ModelAndView();
	
	connection=DBHelper.createConnection();
	statement=connection.prepareStatement("insert into users values(?,?,?,?,?)");
	String id=u.getId();
	String password=u.getPassword();
	String name=u.getName();
	String address=u.getAddress();
	String phone=u.getPhone();
	if((password.length()<9) && (name.length()<51) && (address.length()<51) && (phone.length()<11) )
		{
			statement1=connection.prepareStatement("select * from users");
			resultset=statement1.executeQuery();
		
			while(resultset.next())
				{
					if(resultset.getString("id").equals(id))
						{
							mv.setViewName("registerFailure.jsp");
							return mv;
						}
				}
			
		
			statement.setString(1, u.getId());
			statement.setString(2, u.getPassword());
			statement.setString(3, u.getName());
			statement.setString(4, u.getAddress());
			statement.setString(5, u.getPhone());
	
			int status=statement.executeUpdate();
			if(status==1)
				{
					mv.setViewName("registerSuccess.jsp");
				}
			else
				mv.setViewName("registerFailure.jsp");
				return mv;
		}
	else
		mv.setViewName("registerFailure.jsp");
	return mv;
	}
	}



