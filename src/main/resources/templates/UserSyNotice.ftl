<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人资料</title>
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
        <table class="table">
            <thead>
            <tr>
                <th>公告内容</th>
                <th>发布时间</th>
            </tr>
            </thead>
            <tbody>
            <#if notice?? &&(notice?size>0)>
                <#list notice as notice>
                <tr>

                    <td>${notice.content}</td>
                    <td>${notice.insert_time?string("yyyy-MM-dd HH:mm:ss")}</td>
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
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>