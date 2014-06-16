package cn.edu.hbcit.pojo;

/**
 * @author 武佳男
 *
 * 2014-6-14
 */
public class Major_doc {
	private int  PK_major_doc;
	private int FK_majors_major_doc;
	private int FK_terms_major_doc;
	private String summarize;
	private String plan;
	private String  activity_plan;
	private String activity_record;
	private String set_plan;
	/**
	.
	 * @return the pK_major_doc
	 */
	public int getPK_major_doc() {
		return PK_major_doc;
	}
	/**
	 * @param pK_major_doc the pK_major_doc to set
	 */
	public void setPK_major_doc(int pK_major_doc) {
		PK_major_doc = pK_major_doc;
	}
	/**
	.
	 * @return the fK_majors_major_doc
	 */
	public int getFK_majors_major_doc() {
		return FK_majors_major_doc;
	}
	/**
	 * @param fK_majors_major_doc the fK_majors_major_doc to set
	 */
	public void setFK_majors_major_doc(int fK_majors_major_doc) {
		FK_majors_major_doc = fK_majors_major_doc;
	}
	/**
	.
	 * @return the fK_terms_major_doc
	 */
	public int getFK_terms_major_doc() {
		return FK_terms_major_doc;
	}
	/**
	 * @param fK_terms_major_doc the fK_terms_major_doc to set
	 */
	public void setFK_terms_major_doc(int fK_terms_major_doc) {
		FK_terms_major_doc = fK_terms_major_doc;
	}
	/**
	.
	 * @return the summarize
	 */
	public String getSummarize() {
		return summarize;
	}
	/**
	 * @param summarize the summarize to set
	 */
	public void setSummarize(String summarize) {
		this.summarize = summarize;
	}
	/**
	.
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}
	/**
	 * @param plan the plan to set
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}
	/**
	.
	 * @return the activity_plan
	 */
	public String getActivity_plan() {
		return activity_plan;
	}
	/**
	 * @param activity_plan the activity_plan to set
	 */
	public void setActivity_plan(String activity_plan) {
		this.activity_plan = activity_plan;
	}
	/**
	.
	 * @return the activity_record
	 */
	public String getActivity_record() {
		return activity_record;
	}
	/**
	 * @param activity_record the activity_record to set
	 */
	public void setActivity_record(String activity_record) {
		this.activity_record = activity_record;
	}
	/**
	.
	 * @return the set_plan
	 */
	public String getSet_plan() {
		return set_plan;
	}
	/**
	 * @param set_plan the set_plan to set
	 */
	public void setSet_plan(String set_plan) {
		this.set_plan = set_plan;
	}

}
