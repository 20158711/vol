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
            <caption>现有团队</caption>
            <thead>
            <tr>
                <th>团队名称</th>
                <th>团队介绍</th>
                <th>团队队长</th>
                <th>申请加入</th>
            </tr>
            </thead>
            <tbody>
            <#if teams1?? &&(teams1?size>0)>
                <#list teams1 as team>
                <tr>
                    <td>${team.teamName}</td>
                    <td>${team.introduce}</td>
                    <td>${team.username}</td>
                    <td><button>申请加入</button></td>
                </#list>
            </tr>
            <#else>
            <tr>
                <td>没有发现团队</td>
            </tr>
            </#if>
            </tbody>
        </table>
    </div>
    <div style="margin: 40px">
        <table class="table">
            <caption>已加入团队</caption>
            <thead>
            <tr>
                <th>团队名称</th>
                <th>团队介绍</th>
                <th>团队队长</th>
                <th>是否加入</th>
            </tr>
            </thead>
            <tbody>
            <#if teams1?? &&(teams1?size>0)>
                <#list teams1 as team>
                <tr>

                    <td>${team.teamName}</td>
                    <td>${team.introduce}</td>
                    <td>${team.username}</td>
                    <#if (team.state==0)>
                        <td>还未通过审核</td>
                    <#else>
                        <td>已加入</td>
                    </#if>

                </#list>
            </tr>
            <#else>
            <tr>
                <td>还没申请任何活动</td>
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