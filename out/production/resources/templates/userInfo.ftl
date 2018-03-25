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
        var id=$("#userId").val();
        var username=$("#username").val();
        var age=$("#age").val();
        var personalizedSignature=$("#personalizedSignature").val();
        $.ajax({
            url:"${request.contextPath}/modifyInfo",
            type:"post",
            dataType:"json",
            data:{"id":id,"username":username,"age":age,"personalizedSignature":personalizedSignature},
            success:function (result) {
                /*document.getElementById("username").innerHTML = username;
                document.getElementById("age").innerHTML=age;
                document.getElementById("personalizedSignature").innerHTML=personalizedSignature;*/
                alert(result.message);
                location.href="${request.contextPath}/userInfo?id="+id

            }

        })
        
    }
</script>
<body>
<section id="main">
    <div style="margin: 40px">
        <form class="form-horizontal" role="form">
            <input type="text" value="${user.id}" id="userId" style="display:none">
            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">名字</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" value="${user.username}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">年龄</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="age" value="${user.age}">
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">个性签名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="personalizedSignature" value="${user.personalizedSignature}">
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