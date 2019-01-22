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


@Controller
public class LoginController {

	@Resource
	private StudentDao studentDao;

	@Resource
	private StudentScoreDao studentScoreDao;

	@Resource
	private StudentAnswerDao studentAnswerDao;

	@RequestMapping("/login")
	public ModelAndView login(String account, String password, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("login");
		if(account == null ) {
			mav.setViewName("login");
			return mav;
		} else if(account.isEmpty()){
			mav.addObject("message","account is empty");
			return mav;
		} else if(password.isEmpty()){
			mav.addObject("message","password is empty");
			return mav;
		}

		if("yy".equals(account) && "1".equals(password)) {
			mav.setViewName("admin");
            mav.addObject("beginTest","false");
			return mav;
		}

		Student student = studentDao.selectOne(account);
		if(student == null) {
			mav.addObject("message","account error");
			return mav;
		} else if(!student.getPassword().equals(password)){
			mav.addObject("message","password error");
			return mav;
		}

		mav.setViewName("studentTestManage");
		mav.addObject("student_id", account);

		return mav;
	}


}
