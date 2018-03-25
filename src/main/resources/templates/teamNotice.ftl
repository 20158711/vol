<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>团队公告</title>
    <link href="${request.contextPath}/static/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/css/admin.css" rel="stylesheet"/>
</head>
<script>
    function reply(id) {
        $.ajax({
            type:"post",
            url:"${request.contextPath}/reply?id="+id,
            dataType:"json",
            success:function (result){
                if(result.status==200){
                    alert(result.message);
                    location.href="${request.contextPath}/activity";
                }else {
                    alert(result.message);
                    location.href="${request.contextPath}/activity";
                }
            }

        })
    }
</script>
<body>
<section id="main">
    <div style="margin: 40px">
        <button data-toggle="modal" data-target="#myModal">发布公告</button>
        <table class="table">
            <thead>
            <tr>
                <th>公告内容</th>
                <th>发布时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#if notice?? &&(notice?size>0)>
                <#list notice as notice>
                <tr>

                    <td>${notice.content}</td>
                    <td>${notice.insertTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td><a href="${request.contextPath}/delTeamNotice?id=${notice.id}"><button>删除</button></a> </td>
                </#list>
            </tr>
            <#else>
            <tr>
                <td>未发布公告</td>
            </tr>
            </#if>
            </tbody>
        </table>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加团队公告
                    </h4>
                </div>
                <div class="modal-body">
                    <form action="${request.contextPath}/addTeamNotice" method="post">
                        公告内容：<input type="text" name="content">
                        <input type="submit">
                    </form>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>