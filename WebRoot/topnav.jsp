<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topnav">
				<a href="#"><img class="avatar" SRC="${pageContext.request.contextPath }/img/user_32.png" alt="" /></a>
				当前用户 <b>${sessionScope.username}</b>
				<span>|</span> <a href="${pageContext.request.contextPath }/edit_pwd.jsp" class="nyroModal">修改密码</a>
				<span>|</span> <a href="${pageContext.request.contextPath }/servlet/LogoutServlet">安全退出</a><br />
				<small>现在是 <a href="#" class="high">${sessionScope.Semester}</a></small>
</div>