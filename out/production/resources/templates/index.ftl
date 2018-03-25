<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户权限管理系统</title>

    <link href="${request.contextPath}/static/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${request.contextPath}/static/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="${request.contextPath}/static/css/admin.css" rel="stylesheet"/>
    <style>
        /** skins **/
        #zheng-upms-server
        #header {
            background: #29A176;
        }

        #zheng-upms-server .content_tab {
            background: #29A176;
        }

        #zheng-upms-server .s-profile > a {
            background: url(images/zheng-upms.png) left top no-repeat;
        }

        #zheng-cms-admin #header {
            background: #455EC5;
        }

        #zheng-cms-admin .content_tab {
            background: #455EC5;
        }

        #zheng-cms-admin .s-profile > a {
            background: url(images/zheng-cms.png) left top no-repeat;
        }

        #zheng-pay-admin #header {
            background: #F06292;
        }

        #zheng-pay-admin .content_tab {
            background: #F06292;
        }

        #zheng-pay-admin .s-profile > a {
            background: url(images/zheng-pay.png) left top no-repeat;
        }

        #zheng-ucenter-home #header {
            background: #6539B4;
        }

        #zheng-ucenter-home .content_tab {
            background: #6539B4;
        }

        #zheng-ucenter-home .s-profile > a {
            background: url(images/zheng-ucenter.png) left top no-repeat;
        }

        #zheng-oss-web #header {
            background: #0B8DE5;
        }

        #zheng-oss-web .content_tab {
            background: #0B8DE5;
        }

        #zheng-oss-web .s-profile > a {
            background: url(images/zheng-oss.png) left top no-repeat;
        }

        #test #header {
            background: test;
        }

        #test .content_tab {
            background: test;
        }

        #test .s-profile > a {
            background: url(test) left top no-repeat;
        }
    </style>
</head>
<body>
<header id="header">
    <ul id="menu">
        <li id="guide" class="line-trigger">
            <div class="line-wrap">
                <div class="line top"></div>
                <div class="line center"></div>
                <div class="line bottom"></div>
            </div>
        </li>
        <li id="logo" class="hidden-xs">
            <a href="index.html">
                <img src="${request.contextPath}/static/images/logo.png"/>
            </a>
            <span id="system_title">权限管理系统</span>
        </li>
    </ul>
</header>
<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img src="${request.contextPath}/static/images/avatar.jpg"/>
                </div>
                <div class="sp-info">
                ${user.username}，您好!
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">

                <li>
                    <a class="waves-effect"
                       href="javascript:Tab.addTab('个人资料', '${request.contextPath}/userInfo?id=${user.id}');"><i
                            class="zmdi zmdi-account"></i>个人资料</a>
                </li>
            </ul>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu">
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('志愿活动', '${request.contextPath}/activity');"><i
                        class="zmdi zmdi-home"></i> 志愿活动</a>
            </li>
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('志愿组织', '${request.contextPath}/toTeam');"><i
                        class="zmdi zmdi-accounts"></i> 志愿组织</a>
            </li>
            <li class="sub-menu system_menus system_1 0">
                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 公告</a>
                <ul>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('系统公告', '${request.contextPath}/userSeeNotice');">系统公告</a></li>
                    <li><a class="waves-effect"
                           href="javascript:Tab.addTab('团队公告', '${request.contextPath}/userSeeTeamNotice');">团队公告</a>
                    </li>
                </ul>
            </li>

        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">
        <div class="content_tab">
            <div class="tab_left">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
            </div>
            <div class="tab_right">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
            </div>
            <ul id="tabs" class="tabs">
                <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                    <a class="waves-effect waves-light">首页</a>
                </li>
            </ul>
        </div>
        <div class="content_main">
            <div id="iframe_home" class="iframe cur" style="background-color: #f5f7f9">
            <#--<img src="../static/images/zheng-upms.png"/>-->
            </div>
        </div>
    </section>
</section>
<footer id="footer">

</footer>

<script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
<script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${request.contextPath}/static/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${request.contextPath}/static/plugins/BootstrapMenu.min.js"></script>
<script src="${request.contextPath}/static/plugins/device.min.js"></script>
<script src="${request.contextPath}/static/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${request.contextPath}/static/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${request.contextPath}/static/plugins/jquery.cookie.js"></script>

<script src="${request.contextPath}/static/js/admin.js"></script>
</body>
</html>