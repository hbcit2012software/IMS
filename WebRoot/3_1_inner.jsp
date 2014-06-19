<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>在线教学管理系统</title>

</head>
<body>
<form action="" method="get">
<c:forEach items="${requestScope.majorList}" var="temp01"> 
<table class="no-style">
		<tr>
          	<td align="center">专业编号：</td>
          	<td><input type="text" name="th" value="${temp01.major_code}" style="width:150px" id="zybh" /></td>
          	<td>&nbsp;</td>
        	<td align="center">专业名称：</td>
            <td><input type="text" name="name" value="${temp01.major_name}" style="width:150px" id="zymc" /></td>
        </tr>    
        <tr>
          	<td align="center">学制：</td>
          	<td>
             <select id="xz" class="full" name="productcat">
                <option value="三年制" <c:if test="${temp01.years == '三年制'}">selected </c:if> >三年制</option>
                <option value="3+2" <c:if test="${temp01.years == '3+2'}">selected </c:if> >3+2</option>
                <option value="两年制" <c:if test="${temp01.years == '两年制'}">selected </c:if> >两年制</option>
                <option value="四年制" <c:if test="${temp01.years == '四年制'}">selected </c:if> >四年制</option>
             </select>
        	</td>
        	<td>&nbsp;</td>
        	<td align="center">专业负责人：</td>
        	<td>
                <select id="zyfzr" class="full" name="productcat">
                    <c:forEach items="${requestScope.leaderList}" var="temp02">
                    	<c:if test="${temp01.FK_users_majors == temp02.PK_users}">   
                        <option value="${temp02.PK_users }" selected>${temp02.true_name }</option>
                        </c:if>
                        <c:if test="${temp01.FK_users_majors != temp02.PK_users}">   
                        <option value="${temp02.PK_users }">${temp02.true_name }</option>
                        </c:if>
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
</c:forEach> 
</form>
</body>
</html>