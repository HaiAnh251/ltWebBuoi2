<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <table>
  <tr>
    <th>STT</th>
    <th>Images</th>
    <th>Catergory Name</th>
    <th>Status</th>
    <th>Action</th>
  </tr>
	<c:forEach items="${listcate}" var="cate" varStatus="STT">
		<tr >
			<td>${STT.index+1 }</td>
			
			<c:if test="${cate.image.substring(0,5)=='https' }">
			<c:url value="${cate.image }" var="imgUrl"></c:url>
			</c:if>
			
			
			<c:if test="${cate.image.substring(0,5)!='https' }">
			<c:url value="/image?fname=${cate.image }" var="imgUrl"></c:url>
			<p>${cate.image} </p>
			</c:if>
			
			
			<td><img height="150" width="200" src="${imgUrl}" /></td>
			<td>${cate.catergory_name }</td>
			<td> ${cate.status }</td>
			<td><a
				href="<c:url value='/admin/category/edit?id=${cate.catergory_id }'/>">Sửa</a> | <a
				href="<c:url value='/admin/category/delete?id=${cate.catergory_id }'/>">Xóa</a></td>
		</tr>
	</c:forEach>
</table>