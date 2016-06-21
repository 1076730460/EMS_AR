<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${questionList }" var="question">
	<tr>
		<input id="questionId" type="hidden" value="${question.id }">
		<td class="center"><label class="position-relative"> <input
				type="checkbox" class="ace" /> <span class="lbl"></span>
		</label></td>
		<td>${question.name }</td>
		<td>${question.post.name }</td>
		<td>${question.testquestionType.name }</td>
		<td>${question.options }</td>
		<td>${question.rightOption }</td>
		<td>${question.create_person }</td>
		<td>${question.create_time }</td>
		<td><a class="btn btn-primary" title="修改" data-toggle="modal"
			data-target="#updateQuestion" id="updates">修改</a>
			<button type="button" class="btn btn-primary" id="deltQuestion">删除</button>
		</td>
	</tr>
</c:forEach>