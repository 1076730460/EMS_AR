$(document).ready(function() {
	addQuestion();
	organizationParper();
});
// 搜索局部刷新表
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

//自动组卷
function organizationParper() {
	$("#organization").click(function() {
		var questionNum = $("#qustionNum").val();
		var postSelect = $("#postSelect").val();
		var typeSelect = $("#typeSelect").val();
		if(questionNum==""){
			alert("请输入题目数或手动选择题目！");
			return;
		}else {
			if(postSelect!="" &&　typeSelect!=""){
				var curentNum = $("#questionNum").val();
				if(questionNum<=curentNum){
					//ajax发送数据
					$.ajax({
						type : "POST",
						url : "testQuestPage/automaticParper",
						async : false,
						data : JSON.stringify({
							"postId" : postSelect,
							"questionNum":questionNum,
							"typeId" : typeSelect
							
						}),
						dataType : "json",
						contentType : "application/json",
						success : function(data) {
							if (data.success) {
								alert(data.Msg);
								onSelectChange();
							} else {
								alert(data.errorMsg);
							}
						}
					});
				}else{
					alert("题目数大于当前题数,请重新输入题数！");
					return;
				}
			}else{
				alert("请选择岗位和题目类型");
			}		
		}
			
	});
	
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
function deletQuestion(Id) {
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
}

// 修改
function updateQuestion(Id) {
	$.ajax({
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
			$("#up_questionSub")
					.click(
							function() {
								var questionName = $("#upQuestionName").val();
								var questionOptions = $("#up_questionOptions")
										.val();
								var RightOption = $("#up_questionRightOption")
										.val();
								var post = $("#up_post option:selected").val();
								var questionType = $(
										"#up_questionType option:selected")
										.val();
								if (questionName == "" || questionOptions == ""
										|| RightOption == "" || post == ""
										|| questionType == "") {
									alert("请输入相应内容！");
									return;

								}

								$.ajax({
									type : "POST",
									url : "testQuestPage/updateOrSave",
									async : false,
									data : JSON.stringify({
										"questionId" : Id,
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
											$("#updateQuestion").modal('hide');
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

}
