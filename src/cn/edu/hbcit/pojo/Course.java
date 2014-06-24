/**
 * 
 */
package cn.edu.hbcit.pojo;

/**
 * @author 杨松
 * @version
 * 创建时间2014-6-14
 */
public class Course {
	private int PK_course;
	private String course_name;
	private String course_code;
	private String credit;
	private int class_hour;
	private String practice_rate;
	private String FK_users_course;
	private String grade;
	private int FK_terms_course;
	private String begin_term_ppt;
	private String begin_term_plan;
	private String begin_term_plan_index;
	private String teach_plan;
	private String mid_term_plan_index;
	private String mid_term_plan;
	private int homework;
	private String mid_term_ppt;
	private String qa;
	private String practice_note;
	private String practice_mission_note;
	private String practice_plan;
	private String paper;
	private String score;
	private String analyse;
	private int course_type;
	private int is_practice;
	private int FK_majors_course;
	private int FK_books_course_01;
	private int FK_books_course_02;
	private String begin_end_week;
	private String major_name;
	private String term;
	private String PK_majors;
	/**
	 * @return the pK_course 
	 */
	public int getPK_course() {
		return PK_course;
	}
	/**
	 * @param pK_course the pK_course to set
	 */
	public void setPK_course(int pK_course) {
		PK_course = pK_course;
	}
	/**
	 * @return the course_name 
	 */
	public String getCourse_name() {
		return course_name;
	}
	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	/**
	 * @return the course_code 
	 */
	public String getCourse_code() {
		return course_code;
	}
	/**
	 * @param course_code the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	/**
	 * @return the credit 
	 */
	public String getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(String credit) {
		this.credit = credit;
	}
	/**
	 * @return the class_hour 
	 */
	public int getClass_hour() {
		return class_hour;
	}
	/**
	 * @param class_hour the class_hour to set
	 */
	public void setClass_hour(int class_hour) {
		this.class_hour = class_hour;
	}
	/**
	 * @return the practice_rate 
	 */
	public String getPractice_rate() {
		return practice_rate;
	}
	/**
	 * @param practice_rate the practice_rate to set
	 */
	public void setPractice_rate(String practice_rate) {
		this.practice_rate = practice_rate;
	}
	/**
	 * @return the fK_users_course 
	 */
	public String getFK_users_course() {
		return FK_users_course;
	}
	/**
	 * @param fK_users_course the fK_users_course to set
	 */
	public void setFK_users_course(String fK_users_course) {
		FK_users_course = fK_users_course;
	}
	/**
	 * @return the grade 
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the fK_terms_course 
	 */
	public int getFK_terms_course() {
		return FK_terms_course;
	}
	/**
	 * @param fK_terms_course the fK_terms_course to set
	 */
	public void setFK_terms_course(int fK_terms_course) {
		FK_terms_course = fK_terms_course;
	}
	/**
	 * @return the begin_term_ppt 
	 */
	public String getBegin_term_ppt() {
		return begin_term_ppt;
	}
	/**
	 * @param begin_term_ppt the begin_term_ppt to set
	 */
	public void setBegin_term_ppt(String begin_term_ppt) {
		this.begin_term_ppt = begin_term_ppt;
	}
	/**
	 * @return the begin_term_plan 
	 */
	public String getBegin_term_plan() {
		return begin_term_plan;
	}
	/**
	 * @param begin_term_plan the begin_term_plan to set
	 */
	public void setBegin_term_plan(String begin_term_plan) {
		this.begin_term_plan = begin_term_plan;
	}
	/**
	 * @return the begin_term_plan_index 
	 */
	public String getBegin_term_plan_index() {
		return begin_term_plan_index;
	}
	/**
	 * @param begin_term_plan_index the begin_term_plan_index to set
	 */
	public void setBegin_term_plan_index(String begin_term_plan_index) {
		this.begin_term_plan_index = begin_term_plan_index;
	}
	/**
	 * @return the teach_plan 
	 */
	public String getTeach_plan() {
		return teach_plan;
	}
	/**
	 * @param teach_plan the teach_plan to set
	 */
	public void setTeach_plan(String teach_plan) {
		this.teach_plan = teach_plan;
	}
	/**
	 * @return the mid_term_plan_index 
	 */
	public String getMid_term_plan_index() {
		return mid_term_plan_index;
	}
	/**
	 * @param mid_term_plan_index the mid_term_plan_index to set
	 */
	public void setMid_term_plan_index(String mid_term_plan_index) {
		this.mid_term_plan_index = mid_term_plan_index;
	}
	/**
	 * @return the mid_term_plan 
	 */
	public String getMid_term_plan() {
		return mid_term_plan;
	}
	/**
	 * @param mid_term_plan the mid_term_plan to set
	 */
	public void setMid_term_plan(String mid_term_plan) {
		this.mid_term_plan = mid_term_plan;
	}
	/**
	 * @return the homework 
	 */
	public int getHomework() {
		return homework;
	}
	/**
	 * @param homework the homework to set
	 */
	public void setHomework(int homework) {
		this.homework = homework;
	}
	/**
	 * @return the mid_term_ppt 
	 */
	public String getMid_term_ppt() {
		return mid_term_ppt;
	}
	/**
	 * @param mid_term_ppt the mid_term_ppt to set
	 */
	public void setMid_term_ppt(String mid_term_ppt) {
		this.mid_term_ppt = mid_term_ppt;
	}
	/**
	 * @return the qa 
	 */
	public String getQa() {
		return qa;
	}
	/**
	 * @param qa the qa to set
	 */
	public void setQa(String qa) {
		this.qa = qa;
	}
	/**
	 * @return the practice_note 
	 */
	public String getPractice_note() {
		return practice_note;
	}
	/**
	 * @param practice_note the practice_note to set
	 */
	public void setPractice_note(String practice_note) {
		this.practice_note = practice_note;
	}
	/**
	 * @return the practice_mission_note 
	 */
	public String getPractice_mission_note() {
		return practice_mission_note;
	}
	/**
	 * @param practice_mission_note the practice_mission_note to set
	 */
	public void setPractice_mission_note(String practice_mission_note) {
		this.practice_mission_note = practice_mission_note;
	}
	/**
	 * @return the pracitce_plan 
	 */
	public String getPractice_plan() {
		return practice_plan;
	}
	/**
	 * @param pracitce_plan the pracitce_plan to set
	 */
	public void setPractice_plan(String practice_plan) {
		this.practice_plan = practice_plan;
	}
	/**
	 * @return the paper 
	 */
	public String getPaper() {
		return paper;
	}
	/**
	 * @param paper the paper to set
	 */
	public void setPaper(String paper) {
		this.paper = paper;
	}
	/**
	 * @return the score 
	 */
	public String getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * @return the analyse 
	 */
	public String getAnalyse() {
		return analyse;
	}
	/**
	 * @param analyse the analyse to set
	 */
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
	/**
	 * @return the course_type 
	 */
	public int getCourse_type() {
		return course_type;
	}
	/**
	 * @param course_type the course_type to set
	 */
	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}
	/**
	 * @return the is_practice 
	 */
	public int getIs_practice() {
		return is_practice;
	}
	/**
	 * @param is_practice the is_practice to set
	 */
	public void setIs_practice(int is_practice) {
		this.is_practice = is_practice;
	}
	/**
	 * @return the fK_majors_course 
	 */
	public int getFK_majors_course() {
		return FK_majors_course;
	}
	/**
	 * @param fK_majors_course the fK_majors_course to set
	 */
	public void setFK_majors_course(int fK_majors_course) {
		FK_majors_course = fK_majors_course;
	}
	/**
	 * @return the fK_books_course_01 
	 */
	public int getFK_books_course_01() {
		return FK_books_course_01;
	}
	/**
	 * @param fK_books_course_01 the fK_books_course_01 to set
	 */
	public void setFK_books_course_01(int fK_books_course_01) {
		FK_books_course_01 = fK_books_course_01;
	}
	/**
	 * @return the fK_books_course_02 
	 */
	public int getFK_books_course_02() {
		return FK_books_course_02;
	}
	/**
	 * @param fK_books_course_02 the fK_books_course_02 to set
	 */
	public void setFK_books_course_02(int fK_books_course_02) {
		FK_books_course_02 = fK_books_course_02;
	}
	public String getBegin_end_week() {
		return begin_end_week;
	}
	public void setBegin_end_week(String begin_end_week) {
		this.begin_end_week = begin_end_week;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}
	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	/**
	 * @return the pK_majors
	 */
	public String getPK_majors() {
		return PK_majors;
	}
	/**
	 * @param pKMajors the pK_majors to set
	 */
	public void setPK_majors(String pKMajors) {
		PK_majors = pKMajors;
	}
	
}
