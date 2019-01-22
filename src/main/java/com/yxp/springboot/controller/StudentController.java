package com.yxp.springboot.controller;


import com.yxp.springboot.bean.Student;
import com.yxp.springboot.dao.StudentAnswerDao;
import com.yxp.springboot.dao.StudentDao;
import com.yxp.springboot.dao.StudentScoreDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
	@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentDao studentDao;

	@Resource
	private StudentScoreDao studentScoreDao;

	@Resource
	private StudentAnswerDao studentAnswerDao;

	@RequestMapping("/test")
	public String doRegister() {
		List<Student> students= studentDao.selectAll();
		for(Student s:students) {
			System.out.println(s.getStudentId());
		}
		return "welcome";
	}

	@RequestMapping("/findAll")
	public ModelAndView getAllStudent(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("allStudent");
		List<Student> students= studentDao.selectAll();
		mav.addObject("studentList", students);
		return mav;
	}

	@RequestMapping("/toAddStudent")
	public String toAddStudent() {
		return "addStudent";
	}

	@RequestMapping("/addStudent")
	public String addStudent(String studentId, String studentName, String password,String register) {
		if((studentId == null) || (password == null)){
			return "addStudent";
		}
		studentDao.insert(new Student(studentName,studentId,password));
//		if(register == null || !"true".equals(register)){
//			return "redirect:findAll";
//		}
		return "login";
	}

	@RequestMapping("/delStudent")
	public String delStudent(String studentId) {
		studentScoreDao.delete(studentId);
		studentAnswerDao.deleteS(studentId);
		studentDao.delete(studentId);
		return "redirect:findAll";
	}


}
