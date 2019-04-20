/**
 * admin管理页面主页index的js，为页面相关内容添加监听器
 */
"use strict";

$(function() {

    // 菜单事件
    $(".mcd-menu li a").click(function() {

        var url = $(this).data("url");

        // 先移除其他的点击样式，再添加当前的点击样式
        // 这里 前面那个不能用$(this)
        $(".mcd-menu li a").removeClass("active");
        $(this).addClass("active");
        if(url==='/'){
            // 内容区域清空
            $("#rightContainer").html('');
        }else{
            // 加载其他模块的页面到右侧工作区
            $.ajax({
                url: url,
                success: function(data){
                    $("#rightContainer").html(data);
                },
                error : function() {
                    alert("error");
                }
            });
        }

    });

    $("#editProfile").click(function() {

        var url = $(this).attr("url");


        // 加载其他模块的页面到右侧工作区
        $.ajax({

            url: url,
            success: function(data){
                $("#rightContainer").html(data);
            },
            error : function() {
                alert("error");
            }
        });
    });


    // 选中菜单第一项
    //  $(".blog-menu .list-group-item:first").trigger("click");
});
