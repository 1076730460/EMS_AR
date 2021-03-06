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
<title>考试管理系统</title>
<link
	href="<%=request.getContextPath()%>/resources/easyui/css/default.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/easyui/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/easyui/js/themes/icon.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/easyui/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/easyui/js/jquery.easyui.js"></script>

<script type="text/javascript"
	src='<%=request.getContextPath()%>/resources/easyui/js/outlook2.js'>
	
</script>
<script type="text/javascript">
	//设置登录窗口
	function openPwd() {
		$('#w').window({
			title : '修改密码',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 160,
			resizable : false
		});
	}
	//关闭登录窗口
	function close() {
		$('#w').window('close');
	}

	//修改密码
	function serverLogin() {
		var $newpass = $('#txtNewPass');
		var $rePass = $('#txtRePass');

		if ($newpass.val() == '') {
			msgShow('系统提示', '请输入密码！', 'warning');
			return false;
		}
		if ($rePass.val() == '') {
			msgShow('系统提示', '请在一次输入密码！', 'warning');
			return false;
		}

		if ($newpass.val() != $rePass.val()) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}

		$.post('/ajax/editpassword.ashx?newpass=' + $newpass.val(), function(
				msg) {
			msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
			$newpass.val('');
			$rePass.val('');
			close();
		})

	}

	$(function() {

		openPwd();
		//
		$('#editpass').click(function() {
			$('#w').window('open');
		});

		$('#btnEp').click(function() {
			serverLogin();
		})

		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

				if (r) {
					location.href = '/ajax/loginout.ashx';
				}
			});

		})

	});
</script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img
				src="<%=request.getContextPath()%>/resources/easyui/images/noscript.gif"
				alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px;
        background: url(<%=request.getContextPath()%>/resources/easyui/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
		<span style="float: right; padding-right: 20px;" class="head">欢迎
			<a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
		</span> <span style="padding-left: 10px; font-size: 16px;"><img
			src="<%=request.getContextPath()%>/resources/easyui/images/blocks.gif"
			width="20" height="20" align="absmiddle" /> 考试管理系统</span>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2;">
		<div class="footer">
			<span class="blue bolder">云南航信空港网络</span> 研发部<strong class="green">&copy;</strong>
			2016 </span>
		</div>
	</div>
	<div region="west" split="true" title="导航菜单" style="width: 180px;"
		id="west">
		<div class="easyui-accordion" fit="true" border="false">
			<!--  导航内容 -->
			<div title="岗位管理" style="overflow: auto;" icon="icon-sys">
				<ul>
					<li><c:forEach items="${posts}" var="post">
							<div>
								<a target="mainFrame" href="http://www.bioou.com/"> <span class="icon icon-nav"></span>${post.name}
								</a>
							</div>
						</c:forEach></li>
				</ul>
			</div>
			<!-- 试题类型管理 -->
			<div title="试题类型管理" style="overflow: auto;" icon="icon-sys">
				<ul>
					<li><c:forEach items="${typeList}" var="type">
							<div>
								<a target="mainFrame" href="#"> <span class="icon icon-nav"></span>${type.name}
								</a>
							</div>
						</c:forEach></li>
				</ul>
			</div>
			<!-- 试题题目动态管理 -->
			<div title="试题题目管理" style="overflow: auto;" icon="icon-sys">
				<ul>
					<li>
							<div>
								<a target="mainFrame" href="testQuestPage/question.html"> <span class="icon icon-nav"></span>题目列表
								</a>
							</div>
					</li>
				</ul>
			</div>
			<!-- 试卷动态管理 -->
			<div title="试卷管理" style="overflow: auto;" icon="icon-sys">
				<ul>
					<li>
						<c:forEach items="${posts}" var="post">
							<div>
								<a target="mainFrame" href="parperPage/parper.html?post=${post.name }"> <span class="icon icon-nav"></span>${post.name}试卷
								</a>
							</div>
						</c:forEach>
					</li>
				</ul>
			</div>
			
			
		</div>

	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">

				<h1>欢迎使用考试管理系统</h1>

			</div>
		</div>
	</div>

	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> <a class="easyui-linkbutton"
					icon="icon-cancel" href="javascript:void(0)" onclick="closeLogin()">取消</a>
			</div>
		</div>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>


</body>
</html>