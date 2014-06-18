<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线教学管理系统</title>

</head>
<body>
<form action="" method="get">
<table class="no-style">
		<tr>
          	<td align='center'>专业编号：</td>
          	<td><input type="text" name="th" value='' style='width:150px'></td>
          	<td>&nbsp;</td>
        	<td align="center">专业名称：</td>
            <td><input type='text' name='name' value='' style='width:150px' /></td>
        </tr>    
        <tr>
          	<td align='center'>学制：</td>
          	<td>
              <select id="productcat" class="full" name="productcat">
                                                <option value="三年制" selected>三年制</option>
                                                <option value="3+2">3+2</option>
                                                <option value="两年制">两年制</option>
                                                <option value="四年制">四年制</option>
                </select>
        	</td>
        	<td>&nbsp;</td>
        	<td align="center">专业负责人：</td>
        	<td>
                <select id="productcat" class="full" name="productcat">
                    <c:forEach items="${requestScope.leaderList}" var="temp">   
                        <option value="${temp.PK_users }">${temp.true_name }</option>
                    </c:forEach>
                </select>
			</td>
         </tr>
         <tr>
             <td colspan="5" style="text-align:right;">
             <input type="submit" class="btn btn-green big" value="修改">&nbsp;
             <input id="close_1" type="button" class="nyroModalClose btn btn-red big" value="取消"></td>
         </tr>
</table>
</form>
</body>
</html>