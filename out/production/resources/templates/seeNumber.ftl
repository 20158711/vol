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
                <th>队员姓名</th>
                <th>队员年龄</th>
                <th>队员个性签名</th>
                <th>是否同意</th>

            </tr>
            </thead>
            <tbody>
            <#if user?? &&(user?size>0)>
                <#list user as user>
                <tr>
                    <td>${user.username}</td>
                    <td>${user.personalizedSignature}</td>
                    <td>${user.age}</td>
                    <td><a href="/checkApply?userId="+${user.id}+"&isAllow=1">同意</a></td>
                    <td><a href="/checkApply?userId="+${user.id}+"&isAllow=2">不同意</button></td>
                </#list>
            </tr>
            <#else>
            <tr>
                <td>暂时没人加入</td>
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