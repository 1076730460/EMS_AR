<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align: center;">${post }试卷</h3>
	<ol style="list-style-type: upper-roman">
		<li>单选题</li>
		</br>
		<ol>
			<c:forEach items="${questions }" var="question">
				<c:choose>
					<c:when test="${question.testquestionType.name=='单选题' }">

						<li>${question.name }</br> </br>${question.options }
						</li></br>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</c:forEach>
		</ol>
		</br>
		<li>多选题</li>
		</br>
		<ol>
			<c:forEach items="${questions }" var="question">
				<c:choose>
					<c:when test="${question.testquestionType.name=='多选题' }">

						<li>${question.name }</br> ${question.options }
						</li>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</c:forEach>
		</ol>
		</br>
		<li>判断题</li>
		</br>
		<ol>
			<c:forEach items="${questions }" var="question">
				<c:choose>
					<c:when test="${question.testquestionType.name=='判断题' }">

						<li>${question.name }</br> ${question.options }
						</li>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose>
			</c:forEach>
		</ol>
	</ol>
</body>
</html>