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
            <caption>现有活动</caption>
            <thead>
            <tr>
                <th>活动名称</th>
                <th>活动内容</th>
                <th>团队名称</th>
                <th>创建时间</th>
                <th>申请加入</th>
            </tr>
            </thead>
            <tbody>
            <#if article?? &&(article?size>0)>
                <#--<#list article as article>-->
                <tr>

                    <td>${article.title}</td>
                    <td>${article.content}</td>
                    <td>${article.teamName}</td>
                    <td>${article.insertTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <#if (article.isInsert=="0")>
                        <td>不可申请</td>
                    <#else>
                        <td><#--<a href="${request.contextPath}/reply?id="+${article.id}>--><button onclick="reply(${article.id})">申请</button><#--</a>--></td>
                    </#if>
                <#--</#list>-->
            </tr>
            <#else>
            <tr>
                <td>未发现活动</td>
            </tr>
            </#if>
            </tbody>
        </table>
    </div>
    <#--<div style="margin: 40px">
        <table class="table">
            <caption>已参加活动</caption>
            <thead>
            <tr>
                <th>活动名称</th>
                <th>活动内容</th>
                <th>团队名称</th>
                <th>创建时间</th>
                <th>是否加入</th>
            </tr>
            </thead>
            <tbody>
            <#if articles?? &&(articles?size>0)>
                <#list articles as articles>
                <tr>

                    <td>${articles.title}</td>
                    <td>${articles.content}</td>
                    <td>${articles.teamName}</td>
                    <td>${articles.insertTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <#if (articles.isInsert=="0")>
                        <td>还未同意</td>
                    <#else>
                        <td>申请成功</td>
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
    </div>-->
</section>
<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</body>
</html>