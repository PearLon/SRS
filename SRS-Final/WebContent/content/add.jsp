<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">



</head>
<body>

	<form action="" method="post" class="definewidth m20">
	    <table class="table table-bordered table-hover definewidth m10">
	        <tr>
	            <td class="tableleft">课程号</td>
	            <td><input type="text" name="courseNo"/></td>
	        </tr>
	        <tr>
	            <td class="tableleft">周次</td>
	            <td>
	            	<select name="week">
	            	<option value="1">周一</option>
		           <option value="1">周二</option>
		           <option value="1">周三</option>
		           <option value="1">周四</option>
		           <option value="1">周五</option>
		           <option value="1">周六</option>
		           <option value="1">周日</option>
		            </select>
	            </td>
	        </tr>
	      
	         <tr>
	            <td class="tableleft">教室</td>
	            <td><input type="text" name="room"/></td>
	        </tr> 
	        <tr>
	            <td class="tableleft">容量</td>
	            <td><input type="text" name="seat"/></td>
	        </tr> 
	        <tr>
	            <td class="tableleft"></td>
	            <td>
	                <input type="submit"  value="提交">
	                <input type="submit"  value="重置">
	            </td>
	        </tr>
	    </table>
	</form>
</body>
</html>
