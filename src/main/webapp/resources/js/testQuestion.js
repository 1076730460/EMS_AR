//搜索局部刷新表
function onSelectChange(){
	var postSelect = $("#postSelect").val();
	var typeSelect = $("#typeSelect").val();
	var pageNum =1;
	var searchmap={
			pageNum : pageNum,
			postSelect:postSelect,
			typeSelect:typeSelect		
	};
	reflashTable(searchmap);
	//refreshPagination(searchmap);
}
/**
 * @author gjp
 * @param pagePerNumber 每页显示数
 * @param pageNum
 */
function pageTurn(pagePerNumber,pageNum){
	var CompanyName = $("#CompanyName").val();
	var JobStatus = $("#JobStatus").val();
	var jobType = $("#JobType").val();
	var searchmap={
			pagePerNumber : pagePerNumber,
			pageNum : pageNum,
			company:CompanyName,
			status:JobStatus,
			jobType:jobType			
	};
	reflashTable(searchmap);
	refreshPagination(searchmap);
}


/**
 * create time 2016.6.21
 * @author gjp
 * 添加题目
 */
$(document).ready(function() {
	$("#questionSub").click(function() {
		var questionName = $("#questionName").val();
		var questionOptions = $("#questionOptions").val();
		var RightOption = $("#questionRightOption").val();
		var post = $("#post option:selected").val();
		var questionType = $("#questionType option:selected").val();
		if(questionName=="" || questionOptions=="" || RightOption=="" || post=="" || questionType==""){
			alert("请输入相应内容！");
			return;
			
		}
		$.ajax({
			type : "POST",
			url : "testQuestPage/AddQuestion",
			async : false,
			data : JSON.stringify({
				"questionName":questionName,
				"questionOptions":questionOptions,
				"RightOption":RightOption,
				"post":post,
				"questionType":questionType
			}),
			dataType : "json",
			contentType : "application/json",
			success : function(data) {
				if(data.success){
					$("#myModal").modal('hide');
					//刷新表格	
				    onSelectChange();
				}else{
					alert(data.message);
				}
			}
		});	
	});
});

//删除
function deltQuestion(id){
	$.ajax({
		type : "POST",
		url : "testQuestPage/delet",
		async : false,
		data : JSON.stringify({
			"id":id
		}),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			if(data.success){
			    alert(data.message);
				//刷新表格	
			    onSelectChange();
			}else{
				alert(data.message);
			}
		}
	});	
}