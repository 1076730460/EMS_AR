$(document).ready(function() {
	addQuestion();
	deletQuestion();
	updateQuestion();
});
//搜索局部刷新表
function onSelectChange() {
	var postSelect = $("#postSelect").val();
	var typeSelect = $("#typeSelect").val();
	var pageNum = 1;
	var searchmap = {
		pageNum : pageNum,
		postSelect : postSelect,
		typeSelect : typeSelect
	};
	reflashTable(searchmap);
	// refreshPagination(searchmap);
}
/**
 * @author gjp
 * @param pagePerNumber
 *            每页显示数
 * @param pageNum
 */
function pageTurn(pagePerNumber, pageNum) {
	var CompanyName = $("#CompanyName").val();
	var JobStatus = $("#JobStatus").val();
	var jobType = $("#JobType").val();
	var searchmap = {
		pagePerNumber : pagePerNumber,
		pageNum : pageNum,
		company : CompanyName,
		status : JobStatus,
		jobType : jobType
	};
	reflashTable(searchmap);
	refreshPagination(searchmap);
}

/**
 * create time 2016.6.21
 * 
 * @author gjp 添加题目
 */
function addQuestion() {
	$("#questionSub").click(
			function() {
				var questionName = $("#questionName").val();
				var questionOptions = $("#questionOptions").val();
				var RightOption = $("#questionRightOption").val();
				var post = $("#post option:selected").val();
				var questionType = $("#questionType option:selected").val();
				if (questionName == "" || questionOptions == ""
						|| RightOption == "" || post == ""
						|| questionType == "") {
					alert("请输入相应内容！");
					return;

				}
				$.ajax({
					type : "POST",
					url : "testQuestPage/AddQuestion",
					async : false,
					data : JSON.stringify({
						"questionName" : questionName,
						"questionOptions" : questionOptions,
						"RightOption" : RightOption,
						"post" : post,
						"questionType" : questionType
					}),
					dataType : "json",
					contentType : "application/json",
					success : function(data) {
						if (data.success) {
							$("#myModal").modal('hide');
							// 刷新表格
							onSelectChange();
						} else {
							alert(data.message);
						}
					}
				});
			});
}

// 删除
function deletQuestion() {
	$("#deltQuestion").click(function() {
		var Id = $("#questionId").val();
		$.ajax({
			type : "POST",
			url : "testQuestPage/delet",
			async : false,
			data : JSON.stringify({
				"id" : Id
			}),
			dataType : "json",
			contentType : "application/json",
			success : function(data) {
				if (data.success) {
					// 刷新表格
					onSelectChange();
				} else {
					alert(data.message);
				}
			}
		});
	});
}

// 修改
function updateQuestion() {
	$("#updates")
			.click(
					function() {
						var Id = $("#questionId").val();
						$
								.ajax({
									type : "POST",
									url : "testQuestPage/update",
									async : false,
									data : JSON.stringify({
										"id" : Id
									}),
									dataType : "html",
									contentType : "application/json",
									success : function(data) {
										// add html
										$("#center_update").html(data);
										// reset and get vale
										$("up_questionSub")
												.click(
														function() {
															var questionName = $(
																	"#upQuestionName")
																	.val();
															var questionOptions = $(
																	"#up_questionOptions")
																	.val();
															var RightOption = $(
																	"#up_questionRightOption")
																	.val();
															var post = $(
																	"#up_post option:selected")
																	.val();
															var questionType = $(
																	"#up_questionType option:selected")
																	.val();
															if (questionName == ""
																	|| questionOptions == ""
																	|| RightOption == ""
																	|| post == ""
																	|| questionType == "") {
																alert("请输入相应内容！");
																return;

															}

															$
																	.ajax({
																		type : "POST",
																		url : "testQuestPage/AddQuestion",
																		async : false,
																		data : JSON
																				.stringify({
																					"questionName" : questionName,
																					"questionOptions" : questionOptions,
																					"RightOption" : RightOption,
																					"post" : post,
																					"questionType" : questionType
																				}),
																		dataType : "json",
																		contentType : "application/json",
																		success : function(
																				data) {
																			if (data.success) {
																				$(
																						"#updateQuestion")
																						.modal(
																								'hide');
																				// 刷新表格
																				onSelectChange();
																			} else {
																				alert(data.message);
																			}
																		}
																	});

														});

									},
									error : function(msg) {
										alert("数据错误！" + msg);
									}
								});
					});
}

