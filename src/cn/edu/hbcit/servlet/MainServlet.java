package cn.edu.hbcit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hbcit.dao.LoginDao;
import cn.edu.hbcit.dao.MajorDao;
import cn.edu.hbcit.utils.*;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LinkedHashMap<String, Integer> ymdw = CalenderUtil.getYearMonthDaysWeek();
		
		LoginDao ld = new LoginDao();
		MajorDao md = new MajorDao();
		HttpSession session = request.getSession();
		
		request.setAttribute("day", ymdw.get("day"));
		request.setAttribute("week", ymdw.get("week"));// 返回日期所在的星期几
		request.setAttribute("year", ymdw.get("year"));
		request.setAttribute("month", ymdw.get("month"));
		request.setAttribute("w", CalenderUtil.getWeekends(ld.selectBeginDate()));//开学日期
		request.setAttribute("zhouqi", CalenderUtil.getSemester());
		request.setAttribute("Course", md.selectMajorAndCourseByUser((String)session.getAttribute("username")));
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}
