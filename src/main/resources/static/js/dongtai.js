/*!
  * Bolg main JS.
 * 
 * @since: 1.0.0 2017/3/9
 * @author Way Lau <https://waylau.com>
 */
"use strict";
//# sourceURL=dongtai.js

// DOM 加载完再执行

/* 用户管理开始*/
$(function () {

    var _pageSize; // 存储用于搜索

    // 根据用户名、页面索引、页面大小获取用户列表
    function getArticleByTitle(pageIndex, pageSize) {
        $.ajax({
            url: '/dongtai/list',
            contentType: 'application/json',
            data: {
                "async": true,
                "pageIndex": pageIndex,
                "pageSize": pageSize,
                "title": $("#searchContent").val()
            },
            success: function (data) {
                $("#mainContainer").html(data);
            },
            error: function (xmr) {
                if (xmr.status === 404) {
                    toastr.error("您所请求的资源不存在！");
                } else if (xmr.status === 500) {
                    toastr.error("服务器端程序出错！");
                }
            }
        });
    }

    // 分页
    $.tbpage("#mainContainer", function (pageIndex, pageSize) {
        getArticleByTitle(pageIndex, pageSize);
        _pageSize = pageSize;
    });

    // 搜索
    $("#searchTitleBtn").click(function () {

        getArticleByTitle(0, _pageSize);
    });

    // 获取添加用户的界面
    $("#addJiaoyan").click(function () {
        var url = $(this).attr("url");
        $.ajax({
                url: url,
                success: function (data) {

                    $("#dongtaiFormContainer").html(data);
                },
            error:function (xmr) {
            if (xmr.status === 404) {
                toastr.error("您所请求的资源不存在！");
            } else if (xmr.status === 500) {
                toastr.error("服务器端程序出错！");
            }
        }
    });
});

// 获取编辑用户的界面
$("#rightContainer").on("click", "#editJiaoyan", function () {

    var url = $(this).attr("url");

    $.ajax({
        url: url + $(this).attr("dongtaiId"),
        success: function (data) {

            $("#dongtaiFormContainer").html(data);

        },
        error: function (xmr) {
            if (xmr.status === 404) {
                toastr.error("您所请求的资源不存在！");
            } else if (xmr.status === 500) {
                toastr.error("服务器端程序出错！");
            }


        }
    });
});

// 提交变更后，清空表单
$("#submitEdit").click(function () {
    var url = $(this).attr("url");

    $.ajax({
        url: url,
        type: 'POST',
        data: $('#dongtaiForm').serialize(),
        success: function (data) {
            $('#dongtaiForm')[0].reset();

            if (data.success) {
                // 从新刷新主界面
                getArticleByTitle(0, _pageSize);
            } else {
                toastr.error(data.message);
            }

        },
        error: function (xmr) {
            if (xmr.status === 404) {
                toastr.error("您所请求的资源不存在！");
            } else if (xmr.status === 500) {
                toastr.error("服务器端程序出错！");
            }


        }
    });
});

// 删除用户
$("#rightContainer").on("click", "#deleteJiaoyan", function () {
    //获取 CSRF Token
    // var csrfToken = $("meta[name='_csrf']").attr("content");
    // var csrfHeader = $("meta[name='_csrf_header']").attr("content");

    var url = $(this).attr("url");

    $.ajax({
        url: url + $(this).attr("dongtaiId"),
        type: 'DELETE',
        // beforeSend: function(request) {
        //     request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
        // },
        success: function (data) {
            if (data.success) {
                // 从新刷新主界面
                getArticleByTitle(0, _pageSize);
            } else {
                toastr.error(data.message);
            }
        },
        error: function (xmr) {
            if (xmr.status === 404) {
                toastr.error("您所请求的资源不存在！");
            } else if (xmr.status === 500) {
                toastr.error("服务器端程序出错！");
            }


        }
    });
});
})
;
/* 用户管理结束*/