/**
* Copyright(C) 2014
*
* 模块名称：     
* 子模块名称：   
*
* 备注：
*
* 修改历史：
* 2014-6-13	1.0		李玮		新建
*/
package cn.edu.hbcit.pojo;

/**
 * Books pojo类
 * 简要说明:
 * @author 李玮
 * @version 1.00  2014-6-13下午05:10:41	新建
 */

public class Books {

	private int PK_books;
	private String book_name;
	private String author;
	private String press;
	private String isbn;
	/**
	 * @return the pK_books
	 */
	public int getPK_books() {
		return PK_books;
	}
	/**
	 * @param pKBooks the pK_books to set
	 */
	public void setPK_books(int pKBooks) {
		PK_books = pKBooks;
	}
	/**
	 * @return the book_name
	 */
	public String getBook_name() {
		return book_name;
	}
	/**
	 * @param bookName the book_name to set
	 */
	public void setBook_name(String bookName) {
		book_name = bookName;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the press
	 */
	public String getPress() {
		return press;
	}
	/**
	 * @param press the press to set
	 */
	public void setPress(String press) {
		this.press = press;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
