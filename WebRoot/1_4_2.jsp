<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线教学管理系统</title>
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
	
	/* tabs */
	$("#tabs").tabs();
	
	/* progress bar animations - setting initial values */
//	Administry.progress("#progress1", 10, 100);
//	Administry.progress("#progress2", 25, 100);
//	Administry.progress("#progress3", 50, 100);
	
	/* datatable */
	$("#txt1").dataTable();
	$("#txt2").dataTable();
	$("#txt3").dataTable();
Administry.expandableRows();

	
	
});

</script>

<!--<script type="text/javascript" SRC="js/flot/jquery.flot.min.js"></script>-->
<!-- jQuery data tables -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/jquery.dataTables.min.js"></script>



</head>
<body>
	<header id="top">
		<div class="wrapper">
			<!-- Title/Logo - can use text instead of image -->
			<div id="title"><img SRC="${pageContext.request.contextPath }/img/logo_new.png" alt="Administry" /><!--<span>Administry</span> demo--></div>
			<!-- Top navigation -->
			<jsp:include page="topnav.jsp"></jsp:include>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<jsp:include page="menu.jsp">
            	<jsp:param name="menu" value="1" />
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
			<h1>专业管理 &rarr; <span>下学期开课计划</span></h1>
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
				<section class="column width8 first">					
					
					<div id="tabs">
						<ul>
							<li><a class="corner-tl" href="#tabs-1">软件技术</a></li>
							<li><a class="corner-tl" href="#tabs-2">图形图像</a></li>
							<li><a class="corner-t1" href="#tabs-3">网络专业</a></li>
						</ul>
<!--tabs-1 begin-->                        
<div id="tabs-1">
 						<div>  
                       <form id="sampleform2" method="post" action="#">
                          <fieldset>
                              <legend>下学期开课计划</legend>
                                  <table class="no-style" width="100%">
                                    <tr>
                                    <td><span class="label label-gray">专业名称</span> &nbsp;&nbsp; 软件技术专业</td>
                                    <td><span class="label label-gray">专业代码</span> &nbsp;&nbsp; 590108</td>
                                    <td><span class="label label-gray">学制</span> &nbsp;&nbsp; 三年</td>
                                    <td><span class="label label-gray">当前学期</span> &nbsp;&nbsp; 2013-2014学年第二学期</td>
                                  </tr>
                                  <tr> 
                                    <td colspan="4">
                                    <p class="box">
                                    选择文件:&nbsp;&nbsp;
                                    <input type="file" style="width:auto;">
                                    <input type="submit" class="btn btn-green big" value="上传"/>
                                    </p>
                                    </td>
                                  </tr>
                                </table>
                        </fieldset>
                        </form>
						<fieldset>
                            <legend>历年开课计划</legend>
                             <table class="display stylized" id="txt1">
                                      <thead>
                                          <tr>
                                            <th><div align="center">专业名称</div></th>
                                            <th><div align="center">专业代码</div></th>
                                            <th><div align="center">学制</div></th>
                                            <th><div align="center">附件文件</div></th>
                                            <th><div align="center">操作</div></th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td class="center"  style="width:20%;">软件技术专业</td>
                                            <td class="center" style="width:20%;">12345678</td>
                                            <td class="center" style="width:20%;">三年制</td>
                                            <td class="center" style="width:30%;">2014_03_06_654654654644664.doc</td>
                                            <td class="center" style="width:10%;">
                                                <a href="${mct.begin_term_ppt}" title="下载">
                                                <img width="16" height="16" alt="另存文件" src="${pageContext.request.contextPath }/img/page_save.png"></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="#" title="删除">
                                                <img src="${pageContext.request.contextPath }/img/cross.png" />
                                                </a>
                                            </td>
                                          </tr>
                                        </tbody>
                                    </table>  
                             </fieldset> 
                                    </div>
  
</div>
<!--tabs-1 end-->
<!--tabs-2 begin-->
<div id="tabs-2">
 						<div>  
                       <form id="sampleform2" method="post" action="#">
                          <fieldset>
                              <legend>下学期开课计划</legend>
                                  <table class="no-style" width="100%">
                                    <tr>
                                    <td><span class="label label-gray">专业名称</span> &nbsp;&nbsp; 计算机网络技术专业</td>
                                    <td><span class="label label-gray">专业代码</span> &nbsp;&nbsp; 590108</td>
                                    <td><span class="label label-gray">学制</span> &nbsp;&nbsp; 三年</td>
                                    <td><span class="label label-gray">当前学期</span> &nbsp;&nbsp; 2013-2014学年第二学期</td>
                                  </tr>
                                  <tr> 
                                    <td colspan="4">
                                    <p class="box">
                                    选择文件:&nbsp;&nbsp;
                                    <input type="file" style="width:auto;">
                                    <input type="submit" class="btn btn-green big" value="上传"/>
                                    </p>
                                    </td>
                                  </tr>
                                </table>
                        </fieldset>
                        </form>
						<fieldset>
                            <legend>历年开课计划</legend>
                             <table class="display stylized" id="txt2">
                                      <thead>
                                          <tr>
                                            <th><div align="center">专业名称</div></th>
                                            <th><div align="center">专业代码</div></th>
                                            <th><div align="center">学制</div></th>
                                            <th><div align="center">附件文件</div></th>
                                            <th><div align="center">操作</div></th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td class="center"  style="width:20%;">软件技术专业</td>
                                            <td class="center" style="width:20%;">12345678</td>
                                            <td class="center" style="width:20%;">三年制</td>
                                            <td class="center" style="width:30%;">2014_03_06_654654654644664.doc</td>
                                            <td class="center" style="width:10%;">
                                                <a href="${mct.begin_term_ppt}" title="下载">
                                                <img width="16" height="16" alt="另存文件" src="${pageContext.request.contextPath }/img/page_save.png"></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="#" title="删除">
                                                <img src="${pageContext.request.contextPath }/img/cross.png" />
                                                </a>
                                            </td>
                                          </tr>
                                        </tbody>
                                    </table> 
                             </fieldset> 
                                    </div>
  
</div>
<!--tabs-2 end-->
<!--tabs-3 begin-->
<div id="tabs-3">
 						<div>  
                       <form id="sampleform2" method="post" action="#">
                          <fieldset>
                              <legend>下学期开课计划</legend>
                                  <table class="no-style" width="100%">
                                    <tr>
                                    <td><span class="label label-gray">专业名称</span> &nbsp;&nbsp; 图形图像制作专业</td>
                                    <td><span class="label label-gray">专业代码</span> &nbsp;&nbsp; 590108</td>
                                    <td><span class="label label-gray">学制</span> &nbsp;&nbsp; 三年</td>
                                    <td><span class="label label-gray">当前学期</span> &nbsp;&nbsp; 2013-2014学年第二学期</td>
                                  </tr>
                                  <tr> 
                                    <td colspan="4">
                                    <p class="box">
                                    选择文件:&nbsp;&nbsp;
                                    <input type="file" style="width:auto;">
                                    <input type="submit" class="btn btn-green big" value="上传"/>
                                    </p>
                                    </td>
                                  </tr>
                                </table>
                        </fieldset>
                        </form>
						<fieldset>
                            <legend>历年开课计划</legend>
                            <table class="display stylized" id="txt3">
                                      <thead>
                                          <tr>
                                            <th><div align="center">专业名称</div></th>
                                            <th><div align="center">专业代码</div></th>
                                            <th><div align="center">学制</div></th>
                                            <th><div align="center">附件文件</div></th>
                                            <th><div align="center">操作</div></th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                          <tr>
                                            <td class="center"  style="width:20%;">软件技术专业</td>
                                            <td class="center" style="width:20%;">12345678</td>
                                            <td class="center" style="width:20%;">三年制</td>
                                            <td class="center" style="width:30%;">2014_03_06_654654654644664.doc</td>
                                            <td class="center" style="width:10%;">
                                                <a href="${mct.begin_term_ppt}" title="下载">
                                                <img width="16" height="16" alt="另存文件" src="${pageContext.request.contextPath }/img/page_save.png"></a>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="#" title="删除">
                                                <img src="${pageContext.request.contextPath }/img/cross.png" />
                                                </a>
                                            </td>
                                          </tr>
                                        </tbody>
                                    </table> 
                             </fieldset> 
                                    </div>
  
</div>
<!--tabs-3 end-->
					</div> 
								</section>
							</div>
						
						</div>
						
					</div>
					
			
	<!-- Page footer -->
	<footer id="bottom">
		<div class="wrapper">
			<p>Copyright &copy; 2014 HBCIT.EDU</p>
		</div>
	</footer>
	<!-- End of Page footer -->
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

<!-- Admin template javascript load -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/administry.js"></script></body>
</html>
