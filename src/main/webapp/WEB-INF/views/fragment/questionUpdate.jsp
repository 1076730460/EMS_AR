<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form action="" class="form-horizontal">
	<div class="row">
		<textarea rows="4" id="upQuestionName" name="questionName"
			class=" form-control" placeholder="题目">${question.name }</textarea>
	</div>
	<div class="row">
		<textarea rows="4" id="up_questionOptions" name="questionOption"
			class="form-control" placeholder="选项">${question.options }</textarea>
	</div>
	<div class="row">
		<input type="text" class="form-control" name="up_questionRightOption"
			id="up_questionRightOption" placeholder="答案"
			value="${question.rightOption }">
	</div>

	<div class="form-group" style="margin-top: 5px;">
		<div class="col-xs-6 form-cell">
			<select id="up_post" name="post" class=" form-control">
				<option value="">选择岗位</option>
				<c:forEach items="${posts }" var="post">
					<c:choose>
						<c:when test="${post.id==question.post.id }">
							<option value="${post.id}" selected="selected">${post.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${post.id}">${post.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div class="col-xs-6 form-cell">
			<select id="up_questionType" name="questionType"
				class=" form-control">
				<option class="" value="">选择类型</option>
				<c:forEach items="${typeList }" var="type">
					<c:choose>
						<c:when test="${type.id==question.testquestionType.id }">
							<option value="${type.id}" selected="selected">${type.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${type.id}">${type.name}</option>
						</c:otherwise>
					</c:choose>		
				</c:forEach>
			</select>
		</div>
	</div>
</form>