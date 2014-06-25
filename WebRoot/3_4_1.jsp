<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
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
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" 

src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
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
//动态表格设置
		$(document).ready(function(){
			/* setup navigation, content boxes, etc... */
			Administry.setup();
			/* datatable */
			$('#example').dataTable();
			/* expandable rows */
			Administry.expandableRows();
		});
//弹出框样式设置
		$(function(){  
			   $.nyroModalSettings({  
				   width: 720, // width  
				   minHeight: 80 // height  
			   });  
		   }); 
		   
		   
		   $(function(){
		   
		   	   $("#yhm").blur(function(){
		   	   if($("#yhm").val()==""){
		   $("#yhm").val("用户名禁止为空");}
		   });
		   $("#yhm").focus(function(){
		   
		        if($("#yhm").val()=="用户名禁止为空"){
		         $("#yhm").val("");
		                  }
		             });
		     
		      $("#pwd").blur(function(){
		      if($("#pwd").val()==""){
		      (this).type='text';
		   $("#pwd").val("密码禁止为空");}
		   });
		   $("#pwd").focus(function(){
		   
		        if($("#pwd").val()=="密码禁止为空"){      
		         $("#pwd").val("");
		         (this).type='password';
		                  }
		             });
		     
		      $("#t_name").blur(function(){
		      if($("#t_name").val()==""){
		   $("#t_name").val("真实姓名禁止为空");}
		   });
		   $("#t_name").focus(function(){
		   
		        if($("#t_name").val()=="真实姓名禁止为空"){
		         $("#t_name").val("");
		                  }
		             });
		     
		     });
	

function reg(){
if($("#yhm").val()!=""&&$("#pwd").val()!=""&&$("#t_name").val()!=""&&$("#yhm").val()!="用户名禁止为空"&&$("#pwd").val()!="密码禁止为空"&&$("#t_name").val()!="真实姓名禁止为空")
{  
    $.ajax({
    	url :"${pageContext.request.contextPath }/servlet/SelectUsersIsExist",
				type : 'post',
				data : 'pk_user=' + $("#yhm").attr("value"),
				success : function(mm){ 
					var revalue=mm.replace(/\r\n/g,'');
					if(revalue=="yes")
					{
                             add();
        				
					}else{
								alert('用户已存在');
					}
				}
    });
    }
    else
    alert('信息禁止为空');
			
		}
		function add(){
		  $.ajax({
				url :"${pageContext.request.contextPath }/servlet/AddUsers",
				type : 'post',
				data : 'pk_user=' + $("#yhm").attr("value") + 
					   '&password=' + $("#pwd").attr("value") + 
					   '&true_name=' + $("#t_name").attr("value") + 
					   '&level=' + $("#level").val(),
				success : function(mm){ 
					var revalue=mm.replace(/\r\n/g,'');
					if(revalue=="success")
					{
								location.replace("${pageContext.request.contextPath}/servlet/SelectUsers");
					}else{
								window.location.reload();
					}
				}
			});
		}
</script>

</head>
<body>
	pos<!-- Header -->
<header id="top">
		<div class="wrapper">
			<!-- Title/Logo - can use text instead of image -->
			<div id="title"><img SRC="${pageContext.request.contextPath }/img/logo_new.png" 

alt="Administry" /><!--<span>Administry</span> demo--></div>
			<!-- Top navigation -->
			<jsp:include page="topnav.jsp"></jsp:include>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<jsp:include page="menu.jsp">
            	<jsp:param name="menu" value="3" />
            </jsp:include>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			<aside><b>常用链接</b> &middot; <a href="http://www.hbcit.edu.cn">学院网站</a> &middot; <a 

href="http://jsjx.hbcit.edu.cn">系部网站</a></aside>
			<!-- End of Aside links -->
		</div>
	</header><!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>系统管理 &rarr; <span>用户管理</span></h1>
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
					
					
<fieldset>
<legend>用户管理</legend>
</fieldset>
<div class="box">
    <!-- /* <table border='0' cellpadding='0' cellspacing='0'>*/-->
    <form action="" method="get">
    <table>
        <tr>
          <td width='70' align='center'>用户名：</td>
          <td width='160'>
          <input type="text" id="yhm"  style='width:150px'>        </td>
        <td width='70' align="center">密码：
        </td>
        <td width='160'>
          	<input type='password' id='pwd'  style='width:150px' />
        </td>
          <td width='80' align='center'>真实姓名：</td>
          <td width='90'>
           <input type="text" id="t_name"  style='width:150px'> 
        </td>
        <td width='60' align="center">权限：</td>
        <td width='160'><select id="level" class="full" name="productcat">
											<option value="负责人" selected>负责人</option>
											<option value="系领导">系领导</option>
                                            <option value="最高管理员">最高管理员</option>
                                            <option value="普通老师">普通老师</option>
										</select>&nbsp; </td>
      <td align="right"> <input type="button" id="addUsers" onClick="reg();" class="btn btn-green big" value="添加">
</td>
       </tr>
     
   

</table></form>
</div>
	
				</section>
                
                <section class="column width8">	
                <fieldset>
<legend>所有专业</legend>
</fieldset>

<div class="box">
				<!-- End of Left column/section -->
				<table class="display stylized" id="example">
						<thead>
							<tr>
								<th width="25%"><div align="center">用户名</div></th>
								<th width="20%"><div align="center">密码</div></th>
								<th width="15%"><div align="center">真实姓名</div></th>
								<th width="10%"><div align="center">权限</div></th>
                                <th width="10%"><div align="center">操作</div></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${requestScope.userList}" var="temp">
						<tr>
							<td class="center">${temp.PK_users }  </td>
							<td class="center">********</td>
							<td class="center">${temp.true_name }</td>
							<td class="center"><c:if test="${temp.level == '1'}">负责人</c:if><c:if test="${temp.level == '0'}">系主任/超级管理员</c:if><c:if test="${temp.level == '2'}">普通老师</c:if></td>
                            <td class="center">
                               <a HREF="${pageContext.request.contextPath }/servlet/SelectUsersByName?name=${temp.PK_users }" id="xiugai" class="nyroModal" title="修改" > <img 

src="${pageContext.request.contextPath }/img/pencil.png" alt="Edit Meta" /></a></a>
                               &nbsp; &nbsp; &nbsp; <a href="${pageContext.request.contextPath }/servlet/DeleteUsers?name=${temp.PK_users }" title="删除"><img 

src="${pageContext.request.contextPath }/img/cross.png" alt="Delete" /></a>
&nbsp; &nbsp; &nbsp; <a href="${pageContext.request.contextPath }/servlet/ResetPasswd?name=${temp.PK_users }" title="重置密码"><img src="${pageContext.request.contextPath }/img/hammer_screwdriver.png" alt="Ops" /></a>
                            </td>
						</tr>
							</c:forEach>
                            </tbody>
                            </table>
				
				
		</div>
        </section>
        
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