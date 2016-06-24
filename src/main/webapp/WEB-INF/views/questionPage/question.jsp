<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link
	href="<%=request.getContextPath()%>/resources/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/dist/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-xs-12" style="margin-top: 5px;">
		<form class="form-horizontal">
			<label class="col-sm-1 control-label" for="form-field-select-1">
				岗位</label>
			<div class="col-sm-2 no-padding-left">
				<select name="postSelect" class="form-control" id="postSelect" onchange="onSelectChange()">
					<option value="">所有岗位</option>
					<c:forEach items="${posts }" var="post">
						<option value="${post.id }">${post.name }</option>
					</c:forEach>
				</select>
			</div>

			<label class="col-sm-1 control-label" for="form-field-select-1">
				试题类型</label>
			<div class="col-sm-2 no-padding-left">
				<select name="typeSelect" class="form-control" id="typeSelect" onchange="onSelectChange()">
					<option value="">所有类型</option>
					<c:forEach items="${typeList }" var="type">
						<option value="${type.id }">${type.name }</option>
					</c:forEach>
				</select>
			</div>

			<label class="col-sm-1 control-label" for="form-field-select-1">
				题目数</label>
			<div class="col-sm-1 no-padding-left">
				<input type="text" class="form-control" id="qustionNum">
			</div>

			<label class="col-sm-1 control-label" for="zujuan">
			</label>
			<div class="col-sm-1">
				<button class="btn btn-primary btn-sm"  id="organization">组卷</button>
			</div>
		</form>
		<label class="col-sm-1 control-label" for="form-field-select-3">
		</label>
		<div class="col-sm-1">
			<button class="btn btn-primary btn-sm" data-toggle="modal"
				data-target="#myModal">添加题目</button>
		</div>
	</div>
	<div class="row"></div>
	<input id="searchUrl" type="hidden" value="questionInfoSearch">
	<input id="searchPagination" type="hidden" value="JobInfoPagination">
	<div class="table-responsive" style="margin-top: 5px;">
		<table id="dataSourceTable"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center"><label class="position-relative"> <input
							type="checkbox" class="ace" id="allSelect" onclick="artifical()"/> <span class="lbl"></span>
					</label></th>
					<th>题目名称</th>
					<th>岗位</th>
					<th>类型</th>
					<th>选项</th>
					<th>正确项</th>
					<th>创建人</th>
					<!-- <th>创时间</th> -->
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questionList }" var="question">
					<input id="questionNum" type="hidden" value="${num }">
					<tr>
						<td class="center"><label class="position-relative">
								<input type="checkbox" class="ace"  value="${question.id }"/> <span class="lbl"></span>
						</label></td>
						<td>${question.name }</td>
						<td>${question.post.name }</td>
						<td>${question.testquestionType.name }</td>
						<td>${question.options }</td>
						<td>${question.rightOption }</td>
						<td>${question.create_person }</td>
						<%-- <td>${question.create_time }</td> --%>
						<td><a class="btn btn-primary" title="修改"
							 data-toggle="modal" data-target="#updateQuestion" id="updates" onclick="updateQuestion('${question.id}')">修改</a> 
						<button type="button" class="btn btn-primary" id="deltQuestion" onclick="deletQuestion('${question.id}')">删除</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="table-loader" class="col-xs-12"
			style="text-align: center; margin-top: 6%; display: none; margin-bottom: 6%">
			<img
				src="<%=request.getContextPath()%>/resources/images/ajax-loader.gif" />
		</div>
	</div>


	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加题目</h4>
				</div>
				<div class="modal-body">
					<!-- modal start -->
					<div class="step-pane active">
						<div class="step-pane active">
							<div class="center">
								<form action="" class="form-horizontal">
									<div class="row">
										<textarea rows="4" id="questionName" name="questionName"
											class=" form-control" placeholder="题目"></textarea>
									</div>
									<div class="row">
										<textarea rows="4" id="questionOptions" name="questionOption"
											class="form-control" placeholder="选项"></textarea>
									</div>
									<div class="row">
										<input type="text" class="form-control"
											id="questionRightOption" placeholder="答案">
									</div>

									<div class="form-group" style="margin-top: 5px;">
										<div class="col-xs-6 form-cell">
											<select id="post" name="post" class=" form-control">
												<option value="">选择岗位</option>
												<c:forEach items="${posts }" var="post">
													<option value="${post.id}">${post.name}</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-xs-6 form-cell">
											<select id="questionType" name="questionType"
												class=" form-control">
												<option class="" value="">选择类型</option>
												<c:forEach items="${typeList }" var="type">
													<option value="${type.id}">${type.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
					<!-- model end -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="questionSub">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<!-- 修改model -->
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="updateQuestion" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="text-align: center;">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">题目详情</h4>
				</div>
				<div class="modal-body">
					<!-- modal start -->
					<div class="step-pane active">
						<div class="step-pane active">
							<div class="center" id="center_update">
								
							</div>
						</div>
					</div>
					<!-- model end -->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="up_questionSub">提交</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<script
		src="<%=request.getContextPath()%>/resources/js/testQuestion.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/elements/table.js"></script>
</body>
</html>