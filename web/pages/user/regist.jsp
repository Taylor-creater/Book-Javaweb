<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
</head>
<body>

<script>
	$(function () {
         $("#username").blur(function () {
              var usernameText=$("#username").val();
              var usernamePatt=/^\w{6,12}$/;
              if (usernamePatt.test(usernameText)){
              	$("span.errorMsg").text("");
			  }else {
				  $("span.errorMsg").text("用户名不合法！");
			  }
		 })
		$("#password").blur(function () {
            var passwordText=$("#password").val();
            var passwordPatt=/^\w{6,12}$/;
            if (passwordPatt.test(passwordText)){
				$("span.errorMsg").text("")
			}else {
				$("span.errorMsg").text("密码不合法！");
			}
		})
		$("#repwd").blur(function () {
			var repwdText=$("#repwd").val();
			if (repwdText==$("#password").val()){
				$("span.errorMsg").text("")
			}else {
				$("span.errorMsg").text("确认密码与密码不一致！");
			}
		})

		$("#email").blur(function () {
			var emailText=$("#email").val();
			var emailPatt=/^\w+([-+.]\w+)*@\w+([-.]\w)*\.\w+([-.]\w)*$/;
			if (emailPatt.test(emailText)){
				$("span.errorMsg").text("")
			}else {
				$("span.errorMsg").text("邮箱不合法！");
			}
		})
		$("#codeimg").click(function () {
             this.src="${basepath}kaptchaServlet?DATE="+new Date();
		})

	})
</script>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"><%=request.getAttribute("usernamemsg")==null?"":"用户名已存在!"%>
								<%=request.getAttribute("codemsg")==null?"":"验证码错误!"%></span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/Book/userservlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   utocomplete="off" tabindex="1" name="email" id="email"
									value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
									<img alt="" src="kaptchaServlet" id="codeimg" style="float: right; margin-right: 40px;width: 100px;height: 28px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>