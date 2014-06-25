<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title></title>
<script type="text/javascript">   
   //修改用户ajax函数
		function update(){
			$.ajax({
				url :"${pageContext.request.contextPath }/servlet/UpdateUsersInPasswd",
				type : 'post',
				data : 'user=' + $("#u_name").attr("value") + 
					   '&password=' + $("#u_pwd").attr("value"),
				success : function(mm){ 
					var revalue=mm.replace(/\r\n/g,'');
					if(revalue=="success")
					{
								location.replace("${pageContext.request.contextPath}/servlet/LogoutServlet");
					}else{
								window.location.reload();
					}
				}
			});	
		}
		
</script>
</head>

<body>
<div id="xiugai"> 

 <div style="width:600px; height:130px;margin-left:40px; margin-right:auto;" >
<from action="" method="get">
               <table class="no-style" width="100%" style="margin-top:10px" >
		         <tr>
          <td width='70' align='center'>用户名：</td>
          <td width='160'>
          <input type="text" id="u_name" value='${sessionScope.username}' readonly style='width:150px'>        </td>
          <td>&nbsp;</td>

          <td width='80' align='center'>密码：</td>
          <td width='90'>
          <input type="password" id="u_pwd"  style='width:150px'>
        </td>

                                        </tr>
                                        <tr>
                                        <td></td>
                                        <td></td>
                                        <td>&nbsp;</td ><td></td>
      <td align="right"><input  type="button"  class="btn btn-green big" onclick="update();"value="修改"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input  id="close_1" type="button" class="nyroModalClose btn btn-red big" value="取消"/>
        
</td>
       </tr>
</table>
</from>
     </div> 
</div>

</body>
</html>
