<html>
<head>
</head>
<body>
<#--TODO:目前该页实现了提交授权请求，可用作登陆时的过渡-->
<#--完成验证需要有一次表单提交，暂时没想到好办法来取消这个提交，所以先设计成会自动提交的隐形表单，如果被抓包就暴露了-->
<#--<div class="container">
    <h2>Please Confirm</h2>
    <p>
        Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your
        protected resources
        with scope ${authorizationRequest.scope?join(", ")}.
    </p>
    <form id="confirmationForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <input name="user_oauth_approval" value="true" type="hidden"/>
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Approve</button>
    </form>
    <form id="denyForm" name="confirmationForm"
          action="../oauth/authorize" method="post">
        <input name="user_oauth_approval" value="false" type="hidden"/>
        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Deny</button>
    </form>
</div>-->
<form id="confirmationForm" name="confirmationForm"
      action="../oauth/authorize" method="post">
    <input name="user_oauth_approval" value="true" type="hidden"/>
    <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<script language="JavaScript">
    console.log('submit');
    document.getElementById('confirmationForm').submit();
</script>
</body>
</html>
