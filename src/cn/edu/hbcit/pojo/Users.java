package cn.edu.hbcit.pojo;

/**
 * Books pojo类
 * 简要说明:
 * @author 刘杰
 * @version 1.00  2014-6-16下午09:10:41	新建
 */
public class Users {
 private String PK_users;
 private String password;
 private String true_name;
 private int level;
public String getPK_users() {
	return PK_users;
}
public void setPK_users(String pKUsers) {
	PK_users = pKUsers;
}
public String getTrue_name() {
	return true_name;
}
public void setTrue_name(String trueName) {
	true_name = trueName;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
