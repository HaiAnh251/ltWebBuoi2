<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
 
<form action="<c:url value=/admin/catergory/update"/> "method=post" 
	<label for="fname">Catergory name: </label><br>
	<input type="text" id="catergory_name" name="catergory_name"><br>
	<label for="lname">Image: </label><br>
	
	<input type="file" id="image" name="image"><br>
	<p>Status: </p>
	<input type="radio" id="ston" name="status" value="1">
  <label for="html">Dang hoatj dong</label><br>
  <input type="radio" id="stoff" name="statuse" value="0">
  <label for="css">Khoa</label><br>
<input type="submit" values="update">

</form>