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
    function modify() {
        var id=$("#teamId").val();
        var teamName=$("#teamName").val();
        var introduce=$("#introduce").val();
        $.ajax({
            url:"${request.contextPath}/modifyInfo",
            type:"post",
            dataType:"json",
            data:{"id":id,"teamName":teamName,"introduce":introduce},
            success:function (result) {
                alert(result.message);
                location.href="${request.contextPath}/teamIn?id="+id
            }

        })
        
    }
</script>
<body>
<section id="main">
    <div style="margin: 40px">
        <form class="form-horizontal" role="form">
            <input type="text" value="${team.id}" id="teamId" style="display:none">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">团队名称</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="teamName" value="${team.teamName}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">团队介绍</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="introduce" value="${team.introduce}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onclick="modify()" class="btn btn-default">修改</button>
                </div>
            </div>
        </form>
    </div>
</section>
</div>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>