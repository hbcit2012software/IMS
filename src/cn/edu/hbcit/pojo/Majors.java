package cn.edu.hbcit.pojo;

/**
 * @author 武佳男
 *
 * 2014-6-14
 */
public class Majors {
	private int PK_majors;
	private String major_name;
	private String major_code;
	private String years;
	private String FK_users_majors;
	private String true_name;
	/**
	.
	 * @return the pK_majors
	 */
	public int getPK_majors() {
		return PK_majors;
	}
	/**
	 * @param pK_majors the pK_majors to set
	 */
	public void setPK_majors(int pK_majors) {
		PK_majors = pK_majors;
	}
	/**
	.
	 * @return the major_name
	 */
	public String getMajor_name() {
		return major_name;
	}
	/**
	 * @param major_name the major_name to set
	 */
	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	/**
	.
	 * @return the major_code
	 */
	public String getMajor_code() {
		return major_code;
	}
	/**
	 * @param major_code the major_code to set
	 */
	public void setMajor_code(String major_code) {
		this.major_code = major_code;
	}
	/**
	.
	 * @return the years
	 */
	public String getYears() {
		return years;
	}
	/**
	 * @param years the years to set
	 */
	public void setYears(String years) {
		this.years = years;
	}
	/**
	.
	 * @return the fK_users_majors
	 */
	public String getFK_users_majors() {
		return FK_users_majors;
	}
	/**
	 * @param fK_users_majors the fK_users_majors to set
	 */
	public void setFK_users_majors(String fK_users_majors) {
		FK_users_majors = fK_users_majors;
	}
	/**
	 * @return the true_name
	 */
	public String getTrue_name() {
		return true_name;
	}
	/**
	 * @param trueName the true_name to set
	 */
	public void setTrue_name(String trueName) {
		true_name = trueName;
	}

}
