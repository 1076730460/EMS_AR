function reflashTable(searchmap) {
	$("#dataSourceTable tbody").empty();
	//$("#JobListDiv").empty();
	//$("#page").empty();
	$("#table-loader").css("display","block"); 
	var searchUrl =$("#searchUrl").val();
	$.ajax({
		url :"/EMS_AR/SearchData/"+searchUrl,
		type : "POST",
		data : JSON.stringify(searchmap),
		dataType : "html",
		contentType : "application/json",
		success : function(data) {
			$("#table-loader").css("display","none");
			$("#dataSourceTable tbody").html(data);		
		},
		error : function(msg) {
			 alert("显示列表失败！"+msg);
		}
	});
	
}




function refreshPagination(searchmap) {
	//alert($("#searchSql").val());
	var searchPagination =$("#searchPagination").val();
	$.ajax({
		url : "/EMS_AR/SearchData/"+searchPagination,
		type : "POST",
		data : JSON.stringify(searchmap),
		dataType : "html",
		contentType : "application/json",
		success : function(data) {
			//alert(data);
			var carNum=document.getElementById("page"); 
			carNum.innerHTML=data;			
		},
		error : function(msg) {
			 alert("分页失败！"+msg);
		}
	});
	
}

function tablePageTurn(searchmap) {
	reflashTable(searchmap);
	refreshPagination(searchmap);	
}