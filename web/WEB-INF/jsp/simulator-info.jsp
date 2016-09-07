<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link type="text/css" rel="stylesheet" href="/resources/bundle/reset.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/bundle/common.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/bundle/simulator-info.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/plugin/font-awesome-4.6.3/css/font-awesome.min.css"/>

    <script>
        var simulator_info = ${simulator};
        var state = ${simulator.state};
        var simulator_id = ${simulator.tradeid};
        console.log(simulator_info);
    </script>

    <!-- Insert this line above script imports -->
    <script>if (typeof module === 'object') {window.module = module; module = undefined;}</script>

    <script type="text/javascript" rel="script" src="resources/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" rel="script" src="resources/js/simulator-info.js"></script>

    <!-- Insert this line after script imports  -->
    <script>if (window.module) module = window.module;</script>

    <title>Ascending</title>
</head>
<body>
<jsp:include page="usernav.jsp">
    <jsp:param name="userInfo" value="${userInfo}"/>
</jsp:include>
<div id="main-page">
    <div class="simulator-info-container">
        <a href="user/simulator-list.do" id="back_to_list"><i class="fa fa-arrow-left"></i> 返回列表</a>
        <br>
        <br>
        <h1 style="display: inline">模拟交易1</h1>
        &nbsp;&nbsp;
        <button id="stop" class="edit-button"><i class="fa fa-stop"></i> 结束</button>
        <button id="start" class="edit-button"><i class="fa fa-play"></i> 开始</button>
        <div class="data-bar">
            <div class="data-bar-item">
                <div class="data-value">${simulator.earning}</div>
                <div class="data-name">累计收益</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">${simulator.MaxDrawdown}</div>
                <div class="data-name">最大回撤</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">${simulator.startfund}</div>
                <div class="data-name">起始资金</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">¥${simulator.rightfund}</div>
                <div class="data-name">当前资金</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">${simulator.Alpha}0</div>
                <div class="data-name">Alpha</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">${simulator.Beta}0</div>
                <div class="data-name">Beta</div>
            </div>
            <div class="data-bar-item">
                <div class="data-value">${simulator.Sharpe}0</div>
                <div class="data-name">Sharpe</div>
            </div>
        </div>
        <br>
        <div class="column">
            <div class="column-item">
                <span>开始时间</span>
                <span>${simulator.startdate}</span>
            </div>
            <div class="column-item">
                <span>结束时间</span>
                <span>${simulator.enddate}</span>
            </div>
            <div class="column-item">
                <span>股票池</span>
                <span>${simulator.poolid}</span>
            </div>
            <div class="column-item">
                <span>策略</span>
                <span>${simulator.strategyid}</span>
            </div>
        </div>
        <br>
        <div class="info-wrapper column">
            <div class="overview column-item">

            </div>
            <div class="splitter-pane column-item">
                <div class="holding-info">

                </div>
                <div class="list-info">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
