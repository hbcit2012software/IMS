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
	
	/* progress bar animations - setting initial values */
	Administry.progress("#progress1", 1, 5);
	Administry.progress("#progress2", 2, 5);
	Administry.progress("#progress3", 2, 5);

	/* flot graphs */
	var sales = [{
		label: 'Total Paid',
		data: [[1, 0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,900],[8,0],[9,0],[10,0],[11,0],[12,0]]
	},{
		label: 'Total Due',
		data: [[1, 0],[2,0],[3,0],[4,0],[5,0],[6,422.10],[7,0],[8,0],[9,0],[10,0],[11,0],[12,0]]
	}
	];

	var plot = $.plot($("#placeholder"), sales, {
		bars: { show: true, lineWidth: 1 },
		legend: { position: "nw" },
		xaxis: { ticks: [[1, "Jan"], [2, "Feb"], [3, "Mar"], [4, "Apr"], [5, "May"], [6, "Jun"], [7, "Jul"], [8, "Aug"], [9, "Sep"], [10, "Oct"], [11, "Nov"], [12, "Dec"]] },
		yaxis: { min: 0, max: 1000 },
		grid: { color: "#666" },
		colors: ["#0a0", "#f00"]			
    });


});
</script>

<!---->
<style type="text/css">
.calender{ width:100%; overflow:hidden;}
 .selectmouth{ background-color:#2D2D2B; width:94%; overflow:hidden;padding:2% 3%;border-radius:5px 5px 0 0;}
  .selectmouth p{ float:left;  color:#FFF; font-weight:700; }
  
 .data_table{ width:100%;border:1px solid #cccccc;border-collapse:collapse; }
  .data_table thead{ background-color:#266DBB;}
  .data_table thead td{ color:#FFF; text-align:center;border:1px solid #333;border-collapse:collapse; padding:1% 0;}
  .data_table thead td{ color:#FFF; text-align:center;border:1px solid #333;border-collapse:collapse; padding:1% 0;}
  .data_table tbody td{border:1px solid #cccccc;border-collapse:collapse; text-align:center;color:#666;padding:1% 0;}
  .data_table tbody td.orderdate{ color:#000;}
  .data_table tbody td.tdselect{ color:#fff;background-color:#999}
</style>
<!--日历js-->
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.js"></script>-->
<script type="text/javascript">
	window.onload = function() {
		var day = "${day}";
		var week = "${week}";
		var mydate=new Date();
		var Dnow=mydate.getDate();
		var tbody=document.getElementById("tbody");
		var d=0;
		
	
		for(var i=1;i<7;i++)
	    {
			var tr=document.createElement("tr");
			for(var j=1;j<8;j++)
			{	
				var td=document.createElement("td");
				if(j<=week)
				td.innerHTML="";
				else
				{   d=d+1;
					td.innerHTML=d;
					if(d==Dnow)
					{
						td.style.color="red";
						td.style.fontWeight="bold";
					}
				}if(d>day)
					td.innerHTML="";
				tr.appendChild(td);
				tbody.appendChild(tr);
			};
					week=-1;	
	    };
	};
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
				<small>You have <a href="#" class="high"><b>1</b> new message!</a></small>
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
				<ul class="sf-menu">
					<li  class="current"><a HREF="main.jsp">系统首页</a></li>
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
                    <li>
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
			<h1>系统首页</h1>
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
				<section class="column width6 first">
					<div class="colgroup leading">
						<div class="column width6 first">
							<h4>您的授课情况:</h4>
							<hr/>
							<table class="no-style full">
								<tbody>
									<tr>
										<td>Total Invoices</td>
										<td class="ta-right"><a href="#">10</a></td>
										<td class="ta-right">1,322.10 &euro;</td>
									</tr>
									<tr>
										<td>Total Paid</td>
										<td class="ta-right"><a href="#">9</a></td>
										<td class="ta-right">900.00 &euro;</td>
									</tr>
									<tr>
										<td>Total Due</td>
										<td class="ta-right"><a href="#">1</a></td>
										<td class="ta-right">422.10 &euro;</td>
									</tr>
									<tr>
										<td>Total Overdue</td>
										<td class="ta-right">0</td>
										<td class="ta-right">0.00 &euro;</td>
									</tr>
								</tbody>
							</table>
						</div>
						
					</div>
				
					<div class="colgroup leading">
						<div class="column width6 first">
							<h4>本学期校历</h4>
							<hr/>
							<!--校历在此-->
                            <div class="calender">
         <div class="selectmouth">
                <p title="上学期" style="text-align:right;width:25%; "class="lastmonth">&lt;</p>
                <p style="text-align:center;width:50%;" id="showdate">${year }年${month}月&nbsp;&nbsp;<span id="zhouqi" class="x">${zhouqi }</span>&nbsp;${w }</p>
                <p title="下学期" style="text-align:left;cursor: width:25%; " id="next" class="nextmonth">&gt;</p>
          </div>
           
	<table class="data_table" cellspacing="0px" >
	<thead readonly=readonly>
		<tr>
			<td>日</td>
			<td>一</td>
			<td>二</td>
			<td>三</td>
			<td>四</td>
			<td>五</td>
			<td>六</td>
		</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
	 </div>
                            <!---->
						</div>
					</div>
					<div class="clear">&nbsp;</div>
				
				</section>
				<!-- End of Left column/section -->
				
				<!-- Right column/section -->
				<aside class="column width2">
					<div id="rightmenu">
						<header>
							<h3>账户信息</h3>
						</header>
						<dl class="first">
							<dt><img width="16" height="16" alt="" SRC="${pageContext.request.contextPath }/img/key.png"></dt>
							<dd><a href="#">用户名</a></dd>
							<dd class="last">Free Account.</dd>
							
							<dt><img width="16" height="16" alt="" SRC="${pageContext.request.contextPath }/img/help.png"></dt>
							<dd><a href="#">登录IP</a></dd>
							<dd class="last">Documentation and FAQ</dd>
						</dl>
					</div>
					<div class="content-box">
						<header>
							<h3>Latest in the Community</h3>
						</header>
						<section>
							<dl>
								<dt>Maximize every interaction with a client</dt>
								<dd><a href="#">Read more</a></dd>
								<dt>Diversification for Small Business Owners</dt>
								<dd><a href="#">Read more</a></dd>
							</dl>
						</section>
					</div>
				</aside>
				<!-- End of Right column/section -->
				
		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	
	<!-- Page footer -->
	<footer id="bottom">
		<div class="wrapper">
			<nav>
				<a href="#">Dashboard</a> &middot;
				<a href="#">Content</a> &middot;
				<a href="#">Reports</a> &middot;
				<a href="#">Users</a> &middot;
				<a href="#">Media</a> &middot;
				<a href="#">Events</a> &middot;
				<a href="#">Newsletter</a> &middot;
				<a href="#">Settings</a>
			</nav>
			<p>Copyright &copy; 2010</p>
		</div>
	</footer>
	<!-- End of Page footer -->
	
	<!-- Animated footer -->
	<footer id="animated">
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
	</footer>
	<!-- End of Animated footer -->
	
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

<!-- Admin template javascript load -->
<script type="text/javascript" SRC="${pageContext.request.contextPath }/js/administry.js"></script>
</body>
</html>