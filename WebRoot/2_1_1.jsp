<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage=""  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线教学管理系统</title>
<meta name="description" content="Administry - Admin Template by www.865171.cn" />
<meta name="keywords" content="Admin,Template" />
<!-- We need to emulate IE7 only when we are to use excanvas -->
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<![endif]-->
<!-- Favicons --> 
<link rel="shortcut icon" type="image/png" HREF="${pageContext.request.contextPath }/img/favicons/favicon.png"/>
<link rel="icon" type="image/png" HREF="${pageContext.request.contextPath }/img/favicons/favicon.png"/>
<link rel="apple-touch-icon" HREF="${pageContext.request.contextPath }/img/favicons/apple.png" />
<!-- Main Stylesheet --> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" />
<!-- Colour Schemes
Default colour scheme is blue. Uncomment prefered stylesheet to use it.
<link rel="stylesheet" href="css/brown.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/gray.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/green.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/pink.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/red.css" type="text/css" media="screen" />
-->
<!-- Your Custom Stylesheet --> 
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/custom.css" type="text/css" />
<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/swfobject.js"></script>
<!-- jQuery with plugins -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.ui.tabs.min.js"></script>
<!-- jQuery tooltips -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.tipTip.min.js"></script>
<!-- Superfish navigation -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.supersubs.min.js"></script>
<!-- jQuery form validation -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.validate_pack.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.nyroModal.pack.js"></script>
<!-- jQuery graph plugins -->
<!--[if IE]><script type="text/javascript" src="js/flot/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/flot/jquery.flot.min.js"></script>
<!-- jQuery data tables -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>
<!-- Internet Explorer Fixes --> 
<!--[if IE]>
<link rel="stylesheet" type="text/css" media="all" href="css/ie.css"/>
<script src="js/html5.js"></script>
<![endif]-->
<!--Upgrade MSIE5.5-7 to be compatible with MSIE8: http://ie7-js.googlecode.com/svn/version/2.1(beta3)/IE8.js -->
<!--[if lt IE 8]>
<script src="js/IE8.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	/* datatable */
	$('#example').dataTable();
	
	/* expandable rows */
	Administry.expandableRows();
});
</script>
</head>
<body>
	<!-- Header -->
	<header id="top">
		<div class="wrapper">
			<!-- Title/Logo - can use text instead of image -->
			<div id="title"><img SRC="${pageContext.request.contextPath }/img/logo_new.png" alt="Administry" /><!--<span>Administry</span> demo--></div>
			<!-- Top navigation -->
			<jsp:include page="topnav.jsp"></jsp:include>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<jsp:include page="menu.jsp">
            	<jsp:param name="menu" value="2" />
            </jsp:include>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			<aside><b>常用链接</b> &middot; <a href="http://www.hbcit.edu.cn">学院网站</a> &middot; <a href="http://jsjx.hbcit.edu.cn">系部网站</a></aside>
			<!-- End of Aside links -->
		</div>
	</header>
	<!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>课程管理 &rarr;期初PPT</h1>
			<!-- Quick search box -->
			<form action="" method="get"><input class="" type="text" id="q" name="q" /></form>
		</div>
	</div>
	<!-- End of Page title -->
	
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
		  <!-- Left column/section -->
		  <section class="column width8">
		    <!--	<h3>新增教研室活动计划</h3>-->
		    <form id="sampleform"  name="kcid" method="post" action="${pageContext.request.contextPath }/servlet/UploadBeginPPT" ENCTYPE="multipart/form-data">
		      <fieldset>
		        <legend>期初PPT</legend>
		        <table class="no-style" width="100%">
		        <c:forEach items="${requestScope.majorList}" var="majorlist">
		          <tr>
		            <td><span class="label label-gray">专业名称</span> &nbsp;&nbsp;${majorlist.major_name}</td>
		            <td><span class="label label-gray">专业代码</span> &nbsp;&nbsp;${majorlist.major_code}</td>
		            <td><span class="label label-gray">学制</span> &nbsp;&nbsp; ${majorlist.years}</td>
		            <td><span class="label label-gray">当前学期</span> &nbsp;&nbsp; ${sessionScope.Semester}</td>
	              </tr>
	              </c:forEach>
		          <tr>
		            <td colspan="4">
                    <p class="box"> <span>课程名称：</span>
                    <input type="hidden" value="AAAAAAA" name="test01">
                    <input type="hidden" value="BBBBBBB" name="test02">
                    <input type="hidden" value="CCCCCCC" name="test03">
		              <select id="kcid" name="kcid" style="width:150px;">
		                <c:forEach items="${requestScope.MajorCourseTerms}" var="major">
							<optgroup label="${major.major_name}">
								<c:forEach items="${requestScope.MajorCourseTerms}" var="course">
									<c:if test="${course.FK_majors_course == major.PK_majors}"> 
										<option value="${course.PK_course}">${course.course_name}</option>
									</c:if>
								</c:forEach>
							</optgroup>
		                </c:forEach>
	                  </select>
		              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	              选择文件:&nbsp;&nbsp;
		              <input type="file" style="width:auto;" name="accessories">
		              <input type="submit" id="beginppt"  class="btn btn-green big" value="上传"/>
		              </p></td>  
	              </tr>
	            </table>
	          </fieldset>
	        </form>
		    <fieldset>
		      <legend>历年期初PPT</legend>
		      <table class="display stylized" id="example">
		        <thead>
		          <tr>
		            <th width="25%"><div align="center">所在学期</div></th>
		            <th width="20%"><div align="center">专业名称</div></th>
		            <th width="20%"><div align="center">课程名称</div></th>
		            <th width="45%"><div align="center">所在年级</div></th>
                    <th width="45%"><div align="center">PPT附件</div></th>
		            <th width="10%"><div align="center">操作</div></th>
	              </tr>
	            </thead>
		        <tbody>
		        <c:forEach items="${requestScope.MajorCourseTerms}" var="mct">
		          <tr>
		            <td class="center"><input type="hidden" value="${mct.PK_course }" name="test01">${mct.term}</td>	
		            <td class="center">${mct.major_name}</td>
		            <td class="center">${mct.course_name}</td>
                    <td class="center">${mct.grade}</td>
		            <td class="center">${fn:substringAfter(mct.begin_term_ppt,"userfiles/")}</td>
		            <td class="center"><a href="${mct.begin_term_ppt}" title="下载"><img width="16" height="16" alt="另存文件" src="${pageContext.request.contextPath }/img/page_save.png"></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/servlet/deleteBeginPPTById?id=${mct.PK_course }" title="删除"><img src="${pageContext.request.contextPath }/img/cross.png" alt="删除" /></a></td>
	              </tr>
		        </c:forEach>
	            </tbody>
	          </table>
	        </fieldset>
	      </section>
		  <!-- End of Left column/section -->
	  </div>
		<!-- End of Wrapper -->
</div>
	<!-- End of Page content -->
	
	<!-- Page footer -->
	<footer id="bottom">
		<div class="wrapper">
<!--			<nav>
				<a href="#">Dashboard</a> &middot;
				<a href="#">Content</a> &middot;
				<a href="#">Reports</a> &middot;
				<a href="#">Users</a> &middot;
				<a href="#">Media</a> &middot;
				<a href="#">Events</a> &middot;
				<a href="#">Newsletter</a> &middot;
				<a href="#">Settings</a>
			</nav>-->
			<p>Copyright &copy; 2014 HBCIT.EDU</p>
		</div>
	</footer>
	<!-- End of Page footer -->
	
	<!-- Animated footer -->
<!--	<footer id="animated">
		<ul>
			<li><a href="#">Dashboard</a></li>
			<li><a href="#">Content</a></li>
			<li><a href="#">Reports</a></li>
			<li><a href="#">Users</a></li>
			<li><a href="#">Media</a></li>
			<li><a href="#">Events</a></li>
			<li><a href="#">Newsletter</a></li>
			<li><a href="#">Settings</a></li>
		</ul>
	</footer>-->
	<!-- End of Animated footer -->
	
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

<!-- User interface javascript load -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/administry.js"></script>
</body>
</html>