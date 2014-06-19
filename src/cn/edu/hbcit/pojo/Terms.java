package cn.edu.hbcit.pojo;

/**
 * @author 武佳男
 *
 * 2014-6-14
 */
public class Terms {
	private int PK_term;
	private String begin_date;
	private String term;
	/**
	.
	 * @return the pK_term
	 */
	public int getPK_term() {
		return PK_term;
	}
	/**
	 * @param pK_term the pK_term to set
	 */
	public void setPK_term(int pK_term) {
		PK_term = pK_term;
	}
	/**
	.
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
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

}
