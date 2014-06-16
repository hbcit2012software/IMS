package cn.edu.hbcit.pojo;

/**
 * @author 武佳男
 *
 * 2014-6-14
 */
public class Listen_plan {
	private int PK_listen_plan;
	private String FK_users_listener;
	private String teacher;
	private String FK_course_listen;
	private String listen_date;
	private String classroom;
	private String classes;
	private int FK_terms_listen;
	/**
	.
	 * @return the pK_listen_plan
	 */
	public int getPK_listen_plan() {
		return PK_listen_plan;
	}
	/**
	 * @param pK_listen_plan the pK_listen_plan to set
	 */
	public void setPK_listen_plan(int pK_listen_plan) {
		PK_listen_plan = pK_listen_plan;
	}
	/**
	.
	 * @return the fK_users_listener
	 */
	public String getFK_users_listener() {
		return FK_users_listener;
	}
	/**
	 * @param fK_users_listener the fK_users_listener to set
	 */
	public void setFK_users_listener(String fK_users_listener) {
		FK_users_listener = fK_users_listener;
	}
	/**
	.
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	.
	 * @return the fK_course_listen
	 */
	public String getFK_course_listen() {
		return FK_course_listen;
	}
	/**
	 * @param fK_course_listen the fK_course_listen to set
	 */
	public void setFK_course_listen(String fK_course_listen) {
		FK_course_listen = fK_course_listen;
	}
	/**
	.
	 * @return the listen_date
	 */
	public String getListen_date() {
		return listen_date;
	}
	/**
	 * @param listen_date the listen_date to set
	 */
	public void setListen_date(String listen_date) {
		this.listen_date = listen_date;
	}
	/**
	.
	 * @return the classroom
	 */
	public String getClassroom() {
		return classroom;
	}
	/**
	 * @param classroom the classroom to set
	 */
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	/**
	.
	 * @return the classes
	 */
	public String getClasses() {
		return classes;
	}
	/**
	 * @param classes the classes to set
	 */
	public void setClasses(String classes) {
		this.classes = classes;
	}
	/**
	.
	 * @return the fK_terms_listen
	 */
	public int getFK_terms_listen() {
		return FK_terms_listen;
	}
	/**
	 * @param fK_terms_listen the fK_terms_listen to set
	 */
	public void setFK_terms_listen(int fK_terms_listen) {
		FK_terms_listen = fK_terms_listen;
	}


}
