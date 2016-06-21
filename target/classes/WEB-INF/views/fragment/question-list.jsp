<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${questionList }" var="question">
	<tr>
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
		<td><a class="blue" title="查看编辑" href="#" onclick="#"
			data-toggle="modal">查看编辑 <i class="ace-icon fa fa-eye bigger-150"></i>
		</a> <a class="red" title="删除" href="#"
			onclick="deltQuestion('${question.id}')">删除 <i
				class="ace-icon fa fa-trash-o bigger-150"></i>
		</a></td>
	</tr>
</c:forEach>