package com.yxp.springboot.controller;


import com.yxp.springboot.bean.Question;
import com.yxp.springboot.bean.StudentAnswer;
import com.yxp.springboot.bean.StudentScore;
import com.yxp.springboot.dao.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {
    @Resource
    private QuestionBankDao questionBank;
    @Resource
    private TestDao test;
    @Resource
    private SecondTestDao secondTestDao;

	@Resource
	private StudentScoreDao studentScoreDao;

	@Resource
	private StudentAnswerDao studentAnswerDao;


//	private int threshold = 60;
    private int questionCount = 5;
	private double limitTime = 1; //单位分钟
	private String beginTest = "false";

    @RequestMapping("/createTestQuestion")
    public ModelAndView getAllQuestion(HttpServletRequest request){
        if(beginTest.equals("true")){
            ModelAndView mav=new ModelAndView("admin");
            mav.addObject("message","test is running, can't create test questions");
            return mav;
        }
        List<Question> qs = questionBank.selectAll();
        if(questionCount > qs.size()) {
            ModelAndView mav=new ModelAndView("admin");
            mav.addObject("message","questionqCount is more than questionBank");
            return mav;
        }
        test.deleteAll();
        secondTestDao.deleteAll();
        List<Question> testQ = new ArrayList<>();
        List<Question> secondTestQ = new ArrayList<>();
        Random r1 = new Random();
        Set<Integer> first = new HashSet<>();
        while (first.size() < questionCount) {
            int ran1 = r1.nextInt(qs.size());
            first.add(Integer.valueOf(ran1));
        }
        for (Integer index: new ArrayList<>(first)){
            testQ.add(qs.get(index.intValue()));
            test.insert(qs.get(index.intValue()));
        }

        Random r2 = new Random(2);
        Set<Integer> Second = new HashSet<>();
        while (Second.size() < questionCount) {
            int ran2 = r1.nextInt(qs.size());
            Second.add(Integer.valueOf(ran2));
        }
        for (Integer index: new ArrayList<>(Second)){
            secondTestQ.add(qs.get(index.intValue()));
            secondTestDao.insert(qs.get(index.intValue()));
        }
        ModelAndView mav=new ModelAndView("testQuestion");
        mav.addObject("testQ", testQ);
        mav.addObject("secondTestQ", secondTestQ);
        return mav;
    }

	@RequestMapping("/toSetTestParameters")
	public ModelAndView toSetTestParameters() {
		ModelAndView mav=new ModelAndView("setTestParameters");
		mav.addObject("beginTest",beginTest);
//		mav.addObject("threshold",threshold);
        mav.addObject("questionCount",questionCount);
        mav.addObject("limitTime",limitTime);
        List<Question> qs = questionBank.selectAll();
        mav.addObject("maxCount",qs.size());
		return mav;
	}

	@RequestMapping("/setTestParameters")
	public ModelAndView setTestParameters(double limitTime, int questionCount) {
		ModelAndView mav=new ModelAndView("setTestParameters");
		if(beginTest.equals("false")) {
//            this.threshold = threshold;
            this.limitTime = limitTime;
            this.questionCount = questionCount;
        } else {
            mav.addObject("beginTest",beginTest);
        }
//        mav.addObject("threshold",threshold);
        mav.addObject("questionCount",questionCount);
        mav.addObject("limitTime",limitTime);
        List<Question> qs = questionBank.selectAll();
        mav.addObject("maxCount",qs.size());
		return mav;
	}

	@RequestMapping("/toSetBeginTest")
	public ModelAndView toSetBeginTest() {
		ModelAndView mav=new ModelAndView("setBeginTest");
        List<Question> questions = test.selectAll();
        if(questions == null || questions.isEmpty()) {
            mav.setViewName("admin");
            mav.addObject("message","Please create test questions");
            return mav;
        }
		mav.addObject("beginTest",beginTest);
		return mav;
	}

    @RequestMapping("/toSetThreshold")
    public ModelAndView toSetThreshold(String student_id,HttpServletRequest request) {
        ModelAndView mav=new ModelAndView("setThreshold");
        mav.addObject("student_id",student_id);
        StudentScore sS = studentScoreDao.selectOne(student_id);
        if(sS != null) {
            mav.addObject("threshold",sS.getThreshold());
        }
        if(sS != null && sS.getSecondScore() == -2){
            mav.addObject("message","Can't set threshold, please begin second test");
            mav.addObject("threshold",sS.getThreshold());
            mav.addObject("set","false");
        }
        return mav;
    }

    @RequestMapping("/setThreshold")
    public ModelAndView setThreshold(Integer threshold, String student_id,HttpServletRequest request) {
        ModelAndView mav=new ModelAndView("setThreshold");

        StudentScore oldS = studentScoreDao.selectOne(student_id);
        if(oldS == null) {
            StudentScore sS = new StudentScore(student_id,-1,-1,-1,"notBegin",threshold);
            studentScoreDao.insert(sS);
        } else if(oldS.getScore() >= 0) {
            mav.addObject("message","Can't set threshold, grade exists.");
            threshold = oldS.getThreshold();
        } else{
            StudentScore sS = new StudentScore(student_id,oldS.getScore(),oldS.getSecondScore(),oldS.getTotalScore(),oldS.getResult(),threshold);
            studentScoreDao.update(sS);
        }

        mav.addObject("student_id",student_id);
        mav.addObject("threshold",threshold);
        return mav;
    }

	@RequestMapping("/setBeginTest")
	public ModelAndView setBeginTest(String beginTest) {
		ModelAndView mav=new ModelAndView("setBeginTest");
		if(beginTest == null) {
            this.beginTest = "false";
        } else{
            this.beginTest = beginTest;
        }
		mav.addObject("beginTest",beginTest);
		return mav;
	}

    @RequestMapping("/toTest")
    public ModelAndView toTest(String student_id,HttpServletRequest request) {
//        student_id = "114";
        ModelAndView mav=new ModelAndView("test");
        if ("false".equals(beginTest)) {
            mav.addObject("test","notBegin");
            mav.addObject("student_id",student_id);
            return mav;
        }
        StudentScore q = studentScoreDao.selectOne(student_id);
//        StudentScore s = studentScoreDao.selectOne(student_id);
        if(q != null && q.getSecondScore() != -2 && q.getTotalScore() >= 0) {
            studentScoreDao.delete(student_id);
            studentAnswerDao.deleteS(student_id);
            mav.addObject("message","The previous grade had be overwritten. Please set threshold");
            mav.setViewName("setThreshold");
            mav.addObject("student_id",student_id);
            return mav;
        }
        if (q == null) {
            mav.setViewName("setThreshold");
            mav.addObject("message","Please set threshold");
        } else if(q.getScore() == -1){
            mav.addObject("test","beginFirst");
        } else if(q.getSecondScore() == -2) {
            mav.addObject("test","beginSecond");
        } else {
            mav.addObject("test","ending");
        }

        mav.addObject("student_id",student_id);
        return mav;
    }

    @RequestMapping("/firstBeginTest")
    public ModelAndView firstBeginTest(String student_id) {

        ModelAndView mav=new ModelAndView("firstTest");
        List<Question> firstTestQuestions = test.selectAll();
        mav.addObject("firstTestQuestions",firstTestQuestions);
        mav.addObject("student_id",student_id);
        mav.addObject("limitTime",limitTime);
        mav.addObject("firstTest","true");
        return mav;
    }

    @RequestMapping("/firstSubmit")
    public ModelAndView firstSubmit(HttpServletRequest request,String student_id, String overtime) {
        ModelAndView mav=new ModelAndView("test");
        List<Question> firstTestQuestions = test.selectAll();
        List<StudentAnswer> studentAnswerBeans = new ArrayList<>();
        Enumeration em = request.getParameterNames();
        Integer score  = 0;
        Integer oneScore = 100 / questionCount;
//        String student_id = "114";
        int question_number = 0;
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            if("student_id".equals(name)) {
                continue;
            }
            if("overtime".equals(name)) {
                continue;
            }

            String answer = request.getParameter(name);
            Question q =firstTestQuestions.get(question_number);
            Integer question_id = q.getQuestionId();

            if (answer == null || answer.isEmpty()) {
                answer = "?";
            } else if (q.getAnswer().equals(answer)){
                score += oneScore;
            }

            StudentAnswer atuB = new StudentAnswer(question_id, student_id,answer,null, q.getAnswer(),q.getAnalyse());
            studentAnswerDao.insert(atuB);
            studentAnswerBeans.add(atuB);
            question_number++;
        }

        StudentScore q = studentScoreDao.selectOne(student_id);

        String result = "";
        if(score >= q.getThreshold()){
            result = "pass";
        } else {
            result = "notPass";
        }

        Integer secondScore  = -1;
        Integer totalScore  = score;

        if("true".equals(overtime)){
            secondScore = -2;
            mav.addObject("test","beginSecond");
        } else{
            mav.addObject("test","ending");

        }

        StudentScore sS = new StudentScore(student_id,score,secondScore,totalScore,result,q.getThreshold());
        studentScoreDao.update(sS);


        mav.addObject("result", result);
        mav.addObject("score", score);
        mav.addObject("student_id",student_id);
        return mav;
    }

    @RequestMapping("/seocndBeginTest")
    public ModelAndView seocndBeginTest(String student_id) {
        ModelAndView mav=new ModelAndView("secondTest");
        List<Question> secondTestQuestions = secondTestDao.selectAll();
        mav.addObject("secondTestQuestions",secondTestQuestions);
        mav.addObject("student_id",student_id);
        mav.addObject("limitTime",limitTime);
        mav.addObject("firstTest","false");
        return mav;
    }

    @RequestMapping("/secondSubmit")
    public ModelAndView seocndSubmit(HttpServletRequest request, String student_id) {
        ModelAndView mav=new ModelAndView("test");
        List<Question> secondTestQuestions = secondTestDao.selectAll();
        List<StudentAnswer> studentAnswerBeans = new ArrayList<>();
        Enumeration em = request.getParameterNames();

        Integer secondScore  = 0;
        Integer oneScore = 20;
//        String student_id = "114";
        int question_number = 0;
        StudentScore oldS = studentScoreDao.selectOne(student_id);
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            if("student_id".equals(name)) {
                continue;
            }

            String answer = request.getParameter(name);
            Question q =secondTestQuestions.get(question_number);
            Integer question_id = q.getQuestionId();

            if (answer == null || answer.isEmpty()) {
                answer = "?";
            } else if (q.getAnswer().equals(answer)){
                secondScore += oneScore;
            }

            StudentAnswer stuA = new StudentAnswer(question_id, student_id,null,answer, q.getAnswer(),q.getAnalyse());
            Question oldQ = test.selectOne(question_id);
            if (oldQ == null) {
                studentAnswerDao.insert(stuA);
            } else {
                studentAnswerDao.update(stuA);
            }
            studentAnswerBeans.add(stuA);
            question_number++;
        }
        Integer totalScore  = (secondScore + oldS.getScore()) / 2;
        String result = "";

        StudentScore q = studentScoreDao.selectOne(student_id);
        if(totalScore >= q.getThreshold()){
            result = "pass";
        } else {
            result = "notPass";
        }

        StudentScore sS = new StudentScore(student_id,oldS.getScore(),secondScore,totalScore,result,q.getThreshold());
        studentScoreDao.update(sS);
        mav.addObject("test","ending");
        mav.addObject("result",result);
        mav.addObject("score", totalScore);
        mav.addObject("student_id",student_id);
        return mav;
    }

    @RequestMapping("/studentStatistics")
    public ModelAndView studentStatistics(HttpServletRequest request, String student_id){
//        String student_id = "114";
        StudentScore studentScore = studentScoreDao.selectOne(student_id);
        List<StudentAnswer> studentAnswers = studentAnswerDao.selectS(student_id);
        List<StudentAnswer> qq = studentAnswerDao.selectQ(53);

        ModelAndView mav=new ModelAndView("studentStatistics");
        mav.addObject("studentScore", studentScore);
        mav.addObject("studentAnswers", studentAnswers);
        mav.addObject("student_id",student_id);
        return mav;
    }

	@RequestMapping("/statistics")
	public ModelAndView getStatisticsResult(HttpServletRequest request){
		List<StudentScore> studentScores = studentScoreDao.selectAll();
		List<StudentAnswer> studentAnswers = studentAnswerDao.selectAll();

		ModelAndView mav=new ModelAndView("statisticsResult");
		mav.addObject("studentScores", studentScores);
		mav.addObject("studentAnswers", studentAnswers);
		return mav;
	}



}
