<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线教学管理系统</title>
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
<!--<script type="text/javascript">
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	/* datatable */
	$('#example').dataTable();
	
	/* expandable rows */
	Administry.expandableRows();
});

</script>-->
<style> 
/*遮罩层*/ 
#tinybox_1 { 
position:relative;
width:700px; 
height:130px; 
background:#FFF;

display: none; 
z-index: 999; 
border:5px solid #CCC; 
display:none; 
text-align:center; 
padding:5px 
} 


</style> 
<script type="text/javascript">
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	/* datatable */
	$('#example').dataTable();
	
	/* expandable rows */
	Administry.expandableRows();
});

function BtHide(id){var Div = document.getElementById(id);if(Div){Div.style.display="none"}} 
function BtShow(id){var Div = document.getElementById(id);if(Div){Div.style.display="block"}} 
function BtPopload(showId){ 
// 高度减去 4px，避免在页面无滚动条时显示遮罩后出现流动条 
var h = (Math.max(document.documentElement.scrollHeight,document.documentElement.clientHeight) - 4) + 'px'; 
var w = document.documentElement.scrollWidth + 'px'; 
var popCss = "background:#000;opacity:0.3;filter:alpha(opacity=30);position:absolute;left:0;top:0;overflow:hidden;border:0"//遮罩背景 
var rePosition_mask = function() { 
pop_Box.style.height = h; 
pop_Box.style.width = w; 
pop_Iframe.style.height = h; 
pop_Iframe.style.width = w; 
if (document.documentElement.offsetWidth < 950) { 
//防止正常宽度下点击时 在 ff 下出现页面滚动到顶部 
document.documentElement.style.overflowX = "hidden"; 
} 
} 
var exsit = document.getElementById("popBox"); 
if (!exsit) { 
var pop_Box = document.createElement("div"); 
pop_Box.id = "popBox"; 
document.getElementsByTagName("body")[0].appendChild(pop_Box); 
pop_Box.style.cssText = popCss; 
pop_Box.style.zIndex = "10"; 
var pop_Iframe = document.createElement("iframe"); // 这里如果用 div 的话，在 ie6 不能把 <select> 遮住 
pop_Iframe.id = "popIframe"; 
document.getElementsByTagName("body")[0].appendChild(pop_Iframe); 
pop_Iframe.style.cssText = popCss; 
pop_Iframe.style.zIndex = "9"; 
rePosition_mask(); 
} 
BtShow("popIframe"); 
BtShow("popBox"); 
BtShow(showId); 
var pop_Win = document.getElementById(showId); 
pop_Win.style.position = "absolute"; 
pop_Win.style.zIndex = "11"; 
var rePosition_pop = function() { 
pop_Win.style.top = document.documentElement.scrollTop + document.body.scrollTop + document.documentElement.clientHeight/6 - pop_Win.offsetHeight/6 + 'px'; 
pop_Win.style.left = document.documentElement.scrollLeft + document.body.scrollLeft + document.documentElement.clientWidth/5 - pop_Win.offsetWidth/5 + 'px'; 
} 
rePosition_pop(); 
window.onresize = function(){ 
w = document.documentElement.offsetWidth + 'px'; // 使用 scrollWidth 不能改变宽度
rePosition_mask(); 
rePosition_pop(); 
} 
window.onscroll = function(){ 
rePosition_pop(); 
} 
} 
function BtPopShow(Bid,Did) { 
var UploadBtn = document.getElementById(Bid); 
if (UploadBtn){UploadBtn.onclick = function() {BtPopload(Did);return false;}} 
} 
function BtPopHide(Bid,Did) { 
var UploadBtn = document.getElementById(Bid); 
if (UploadBtn){UploadBtn.onclick = function() {BtHide(Did);BtHide("popBox");BtHide("popIframe");return false;}} 
} 

</script>
</head>
<body>
	<!-- Header -->
	<header id="top">
		<div class="wrapper">
			<!-- Title/Logo - can use text instead of image -->
			<div id="title"><img SRC="${pageContext.request.contextPath }/img/logo_new.png" alt="Administry" /><!--<span>Administry</span> demo--></div>
			<!-- Top navigation -->
			<div id="topnav">
				<a href="#"><img class="avatar" SRC="${pageContext.request.contextPath }/img/user_32.png" alt="" /></a>
				当前用户 <b>Admin</b>
				<span>|</span> <a href="#">修改密码</a>
				<span>|</span> <a href="#">安全退出</a><br />
				<small>现在是 <a href="#" class="high">2013-2014学年第二学期 第<b>1</b>周</a></small>
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
				<ul class="sf-menu">
					<li><a HREF="main.html">系统首页</a></li>
					<li >
						<a HREF="styles.html">专业管理</a>
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
                    <li>
                    <a HREF="graphs.html">课程管理</a>
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
                    <li  class="current">
                    <a HREF="graphs.html">系统管理</a>
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
				</ul>
			</nav>
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
			<h1>系统管理 &rarr; <span>专业管理</span></h1>
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
<legend>专业管理</legend>
</fieldset>
<div class="box">
    <!-- /* <table border='0' cellpadding='0' cellspacing='0'>*/-->
    <table>
        <tr>
          <td width='70' align='center'>专业编号：</td>
          <td width='160'>
          <input type="text" id="zybh" value='' style='width:150px'>        </td>
        <td width='70' align="center">专业名称：        </td>
        <td width='160'>
          	<input type='text' id='zymc' value='' style='width:150px' />        </td>
          <td width='80' align='center'>学制：</td>
          <td width='90'>
          <select class="full" id="xz">
                <option value="三年制" selected>三年制</option>
                <option value="3+2">3+2</option>
                <option value="两年制">两年制</option>
                <option value="四年制">四年制</option>
		</select>        </td>
        <td width='60' align="center">负责人：</td>
        <td width='160'>
        <select id="zyfzr" class="full" name="productcat2">
          <c:forEach items="${requestScope.leaderList}" var="temp">   
				<option value="${temp.PK_users }">${temp.true_name }</option>
			</c:forEach>
        </select>
        </td>
      <td align="right"> <input type="button" class="btn btn-green big" value="添加"></td>
       </tr>
</table>
</div>
	
				</section>
                
                <section class="column width8">	
                <fieldset>
<legend>所有专业</legend>
</fieldset>

<!-- 弹出层 BEGIN -->
<div id="tinybox_1"> 
 <div style="width:600px; height:130px;margin-left:40px; margin-right:auto;" >
               <table class="no-style" width="100%" style="margin-top:10px" >
		         <tr>
          <td width='70' align='center'>专业代号：</td>
          <td width='160'>
          <input type="text" name="th" value='' style='width:150px'>        </td>
          <td>&nbsp;</td>
        <td width='70' align="center">专业名称：
        </td>
        <td width='160'>
          	<input type='text' name='name' value='' style='width:150px' />
        </td>
        <tr>
          <td width='80' align='center'>学制：</td>
          <td width='90'>
          <select id="productcat" class="full" name="productcat">
											<option value="1" selected>三年制</option>
											<option value="2">两年制</option>
                                            <option value="2">四年制</option>
                                            <option value="2">3+2</option>
		</select>
        </td>
        <td>&nbsp;</td>
        <td width='60' align="center">负责人：</td>
        <td width='160'>
        <select id="productcat" class="full" name="productcat">
	        <c:forEach items="${requestScope.leaderList}" var="temp">   
				<option value="${temp.PK_users }">${temp.true_name }</option>
			</c:forEach>
		</select>
		</td>
                                        </tr>
                                        <tr>
                                        <td></td>
                                        <td></td>
                                        <td>&nbsp;</td ><td></td>
      <td align="right"> <input id="close_1" type="submit"
 class="btn btn-green" value="提交">
</td>
       </tr>
</table>
     </div> 
</div>
<!-- 弹出层 END -->

<div class="box">
				<!-- End of Left column/section -->
				<table class="display stylized" id="example">
						<thead>
							<tr>
								<th width="25%"><div align="center">专业编号</div></th>
								<th width="20%"><div align="center">专业名称</div></th>
								<th width="15%"><div align="center">学制</div></th>
								<th width="10%"><div align="center">负责人</div></th>
                                <th width="10%"><div align="center">操作</div></th>
							</tr>
						</thead>
						<tbody>
<c:forEach items="${requestScope.majorList}" var="temp">                        
						<tr>
							<td class="center">${temp.major_code }</td>
							<td class="center">${temp.major_name }</td>
							<td class="center">${temp.years }</td>
							<td class="center">${temp.true_name }</td>
                            <td class="center">
                               <a href="?${temp.PK_majors }" id="B" title="修改" style="border:0px;"> <img src="${pageContext.request.contextPath }/img/pencil.png" alt="Edit Meta" /></a>&nbsp; &nbsp; &nbsp; 
                               <a href="?${temp.PK_majors }" title="删除"><img src="${pageContext.request.contextPath }/img/cross.png" alt="Delete" /></a> 
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
<script type="text/javascript"> 
BtPopShow("B","tinybox_1"); 
BtPopHide("close_1","tinybox_1") 
</script> 

</body>
</html>