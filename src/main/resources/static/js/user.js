/*!
  * Bolg main JS.
 * 
 * @since: 1.0.0 2017/3/9
 * @author Way Lau <https://waylau.com>
 */
"use strict";
//# sourceURL=jiaoyan.js
 
// DOM 加载完再执行

/* 用户管理开始*/
$(function() {
	
	var _pageSize; // 存储用于搜索
	
	// 根据用户名、页面索引、页面大小获取用户列表
	function getUersByName(pageIndex, pageSize) {
		 $.ajax({ 
			 url: "/user/list",
			 contentType : 'application/json',
			 data:{
				 "async":true, 
				 "pageIndex":pageIndex,
				 "pageSize":pageSize,
				 "name":$("#searchName").val()
			 },
			 success: function(data){
				 $("#mainContainer").html(data);
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	}
	
	// 分页
	$.tbpage("#mainContainer", function (pageIndex, pageSize) {
		getUersByName(pageIndex, pageSize);
		_pageSize = pageSize;
	});
   
	// 搜索
	$("#searchNameBtn").click(function() {
		getUersByName(0, _pageSize);
	});
	
	// 获取添加用户的界面
	$("#addUser").click(function() {
		$.ajax({ 
			 url: "/user/add",
			 success: function(data){

				 $("#userFormContainer").html(data);
		     },
		     error : function(data) {
		    	 toastr.error("error!");
		     }
		 });
	});
	
	// 获取编辑用户的界面
    // 这里通过用on方法来给动态生成的控件添加监听函数，也只能用on方法，不能用click方法
    $("#rightContainer").on("click","#edit-user", function () {
		$.ajax({
			 url: "/user/edit/" + $(this).attr("userId"),
			 success: function(data){
				 $("#userFormContainer").html(data);
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});
	
	// 提交变更后，清空表单
    // 给提交表单按钮添加监听函数，这个表单按钮所处理的表单内容由上面的ajax函数获取得来，是动态生成的
	$("#submitEdit").click(function() {
		$.ajax({ 
			 url: "/user/update",
			 type: 'POST',
			 data:$('#userForm').serialize(),
			 success: function(data){
			 	// 清空表单的方法
				 $('#userForm')[0].reset();  
				 
				 if (data.success) {
					 // 重新刷新主界面
					 getUersByName(0, _pageSize);
				 } else {
					 toastr.error(data.message);
				 }

		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});
	
	// 删除用户
	$("#rightContainer").on("click","#delete-user", function () {
		//获取 CSRF Token
		// var csrfToken = $("meta[name='_csrf']").attr("content");
		// var csrfHeader = $("meta[name='_csrf_header']").attr("content");


		$.ajax({ 
			 url: "/user/delete/" + $(this).attr("userId") ,
			 type: 'DELETE', 
             // beforeSend: function(request) {
             //     request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
             // },
			 success: function(data){
				 if (data.success) {
					 // 从新刷新主界面
					 getUersByName(0, _pageSize);
				 } else {
					 toastr.error(data.message);
				 }
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});
});
/* 用户管理结束*/