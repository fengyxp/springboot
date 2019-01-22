package com.yxp.springboot.controller;


import com.yxp.springboot.bean.Question;
import com.yxp.springboot.dao.QuestionBankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
	@RequestMapping("/question")
public class QuestionController {
	@Resource
	private QuestionBankDao questionBank;

	@RequestMapping("/test")
	public String doRegister() {
		List<Question> qa= questionBank.selectAll();
		for(Question q:qa) {
			System.out.println(q.getAnswer());
		}
		return "welcome";
	}

	@RequestMapping("/findAll")
	public ModelAndView getAllQuestion(HttpServletRequest request){
		ModelAndView mav=new ModelAndView("allQuestion");
		List<Question> qa= questionBank.selectAll();
		mav.addObject("questionList", qa);
		return mav;
	}

	@RequestMapping("/toAddQuestion")
	public String toAddQuestion() {
		return "addQuestion";
	}

	@RequestMapping("/addQuestion")
	public String addQuestion(Integer question_id, String question, String A, String B, String C, String D, String answer, String analyse) {
		if((question == null) || (A == null) || (B == null) ||
				(C == null) || (D == null) || (answer == null)){
			return "addQuestion";
		}
		questionBank.insert(new Question(question_id,question,A,B,C,D,answer,analyse));
		return "redirect:findAll";
	}

	@RequestMapping("/delQuestion")
	public String delQuestion(Integer question_id) {
		questionBank.delete(question_id);
		return "redirect:findAll";
	}


}
