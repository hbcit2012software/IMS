<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%pageContext.setAttribute("current",request.getParameter("menu"));%>
			<nav id="menu">
				<ul class="sf-menu">
					<li  <c:if test="${current == '0'}">class="current" </c:if> ><a HREF="${pageContext.request.contextPath }/servlet/MainServlet">系统首页</a></li>
<c:if test="${sessionScope.MajorsManager == true || sessionScope.DepartmentManager == true}">
					<li <c:if test="${current == '1'}">class="current" </c:if> ><a HREF="#">专业管理</a>
						<ul>
							<li>
								<a href="#">期初工作</a>
								<ul>
									<li><a HREF="samples-files.html">教研室活动计划</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">期中工作</a>
								<ul>
									<li><a HREF="samples-files.html">教研室活动记录</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">期末工作</a>
								<ul>
									<li><a HREF="samples-files.html">本学期工作总结</a></li>
									<li><a HREF="samples-products.html">下学期工作计划</a></li>
								</ul>
							</li>
                             <li>
								<a href="#">开课设置</a>
								<ul>
									<li><a HREF="samples-files.html">下学期课程设置</a></li>
									<li><a HREF="samples-products.html">下学期开课计划</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">专业统计</a>
								<ul>
									<li><a HREF="samples-files.html">期初统计</a></li>
									<li><a HREF="samples-files.html">期中统计</a></li>
                                    <li><a HREF="samples-files.html">期末统计</a></li>
                                    <li><a HREF="samples-files.html">学期统计</a></li>
								</ul>
							</li>
						</ul>
					</li>
</c:if>
					
                    <li <c:if test="${current == '2'}">class="current" </c:if> ><a HREF="#">课程管理</a>
                    <ul>
							<li>
								<a href="#">期初工作</a>
								<ul>
									<li><a HREF="samples-files.html">期初PPT</a></li>
                                    <li><a HREF="samples-files.html">期初教案</a></li>
                                    <li><a HREF="samples-files.html">期初教案首页</a></li>
                                    <li><a HREF="samples-files.html">授课计划</a></li>
                                    <li><a HREF="samples-files.html">听课计划</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">期中工作</a>
								<ul>
                                    <li><a HREF="samples-files.html">期中教案</a></li>
                                    <li><a HREF="samples-files.html">期中教案首页</a></li>
                                    <li><a HREF="samples-files.html">期中PPT</a></li>
                                    <li><a HREF="samples-files.html">答疑记录</a></li>
                                    <li><a HREF="samples-files.html">学生作业</a></li>
                                    <li><a HREF="samples-files.html">实践指导书</a></li>
                                    <li><a HREF="samples-files.html">实践任务书</a></li>
                                    <li><a HREF="samples-files.html">实践教学计划</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">期末工作</a>
								<ul>
									<li><a HREF="samples-files.html">期末试卷</a></li>
									<li><a HREF="samples-products.html">期末成绩</a></li>
                                    <li><a HREF="samples-products.html">成绩分析</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">课程统计</a>
								<ul>
									<li><a HREF="samples-files.html">期初统计</a></li>
									<li><a HREF="samples-files.html">期中统计</a></li>
                                    <li><a HREF="samples-files.html">期末统计</a></li>
                                    <li><a HREF="samples-files.html">学期统计</a></li>
								</ul>
							</li>
						</ul>
                    </li>	
<c:if test="${sessionScope.DepartmentManager == true}">                    
                    <li <c:if test="${current == '3'}">class="current" </c:if> ><a HREF="#">系统管理</a>
                    <ul>
							<li>
								<a href="#">专业维护</a>
								<ul>
									<li><a HREF="${pageContext.request.contextPath }/servlet/SelectMajors">专业管理</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">数据维护</a>
								<ul>
                                    <li><a HREF="samples-files.html">数据备份</a></li>
                                    <li><a HREF="samples-files.html">数据恢复</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">全局设置</a>
								<ul>
									<li><a HREF="xqms.html">学期管理</a></li>
								</ul>
							</li>
                            <li>
								<a href="#">用户设置</a>
								<ul>
									<li><a HREF="newuse.html">用户管理</a></li>
								</ul>
							</li>
						</ul>
                    </li>
</c:if>
				</ul>
			</nav>