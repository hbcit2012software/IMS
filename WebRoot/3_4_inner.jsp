<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title></title>
<script type="text/javascript">   
    $(function(){
		   
		
		      $("#tnames").blur(function(){
		      if($("#tnames").val()==""){
		   $("#tnames").val("真实姓名禁止为空");}
		   });
		   $("#tnames").focus(function(){
		   
		        if($("#tnames").val()=="真实姓名禁止为空"){
		         $("#tnames").val("");
		                  }
		             });
		     
		     });
   //修改用户ajax函数
		function update(){
		if($("#tnames").val()!=""&&$("#tnames").val()!="真实姓名禁止为空")
{ 
			$.ajax({
				url :"${pageContext.request.contextPath }/servlet/UpdateUsers",
				type : 'post',
				data : 'user=' + $("#p_user").attr("value") + 
					   '&t_name=' + $("#tnames").attr("value") + 
					   '&level=' + $("#levels").val(),
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
			else
			alert('信息禁止为空');
		}
		
</script>
</head>

<body>
<div id="xiugai"> 

 <div style="width:720px; height:130px;margin-left:1px; margin-right:auto;" >
<from action="" method="get">
<c:forEach items="${requestScope.userList}" var="temp">
               <table class="no-style" width="100%" style="margin-top:10px" >
		         <tr>
          <td width='90' align='center'>用户名：</td>
          <td width='120'>
          <input type="text" id="p_user" value='${temp.PK_users}' readonly style='width:150px'>        </td>

          <td width='120' align='center'>真实姓名：</td>
          <td width='90'>
          <input type="text" id="tnames" value='${temp.true_name}' style='width:150px'>
        </td>
        <td width='60' align="center">权限：</td>
        <td width='180'><select id="levels" class="full" name="productcat">
											<option value="负责人" <c:if test="${temp.level == '1'}">selected </c:if>>负责人</option>
											<option value="最高管理员" <c:if test="${temp.level == '0'}">selected </c:if>>系领导/最高管理员</option>
                                            <option value="普通老师" <c:if test="${temp.level == '2'}">selected </c:if>>普通老师</option>
										</select>&nbsp; </td>
                                        </tr>
                                        <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td ><td></td><td></td>
      <td align="right"><input  type="button"  class="btn btn-green big" onclick="update();"value="修改"/>&nbsp;&nbsp;
        <input  id="close_1" type="button" class="nyroModalClose btn btn-red big" value="取消"/>
        
</td>
       </tr>
</table>
</c:forEach> 
</from>
     </div> 
</div>

</body>
</html>
