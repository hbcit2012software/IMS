package cn.edu.hbcit.pojo;

/**
 * @author 武佳男
 *
 * 2014-6-14
 */
public class Listen_record {
	private int PK_listen_record;
	private String listen_record;
	private String FK_users_listenrec;
	private int FK_terms_listenrec;
	/**
	.
	 * @return the pK_listen_record
	 */
	public int getPK_listen_record() {
		return PK_listen_record;
	}
	/**
	 * @param pK_listen_record the pK_listen_record to set
	 */
	public void setPK_listen_record(int pK_listen_record) {
		PK_listen_record = pK_listen_record;
	}
	/**
	.
	 * @return the listen_record
	 */
	public String getListen_record() {
		return listen_record;
	}
	/**
	 * @param listen_record the listen_record to set
	 */
	public void setListen_record(String listen_record) {
		this.listen_record = listen_record;
	}
	/**
	.
	 * @return the fK_users_listenrec
	 */
	public String getFK_users_listenrec() {
		return FK_users_listenrec;
	}
	/**
	 * @param fK_users_listenrec the fK_users_listenrec to set
	 */
	public void setFK_users_listenrec(String fK_users_listenrec) {
		FK_users_listenrec = fK_users_listenrec;
	}
	/**
	.
	 * @return the fK_terms_listenrec
	 */
	public int getFK_terms_listenrec() {
		return FK_terms_listenrec;
	}
	/**
	 * @param fK_terms_listenrec the fK_terms_listenrec to set
	 */
	public void setFK_terms_listenrec(int fK_terms_listenrec) {
		FK_terms_listenrec = fK_terms_listenrec;
	}
	
}
