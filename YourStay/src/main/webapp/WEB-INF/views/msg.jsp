<%@ page contentType="text/html; charset=UTF-8" import="yourstay.md.domain.LoginConst"%>
<script>
	if(${result} == <%=LoginConst.NO_ID%>){
		alert("해당 이메일 또는 비밀번호를 가진 회원이 없어요");
		location.href="loginPage";
	}else if(${result} == <%=LoginConst.NO_PWD%>){
		alert("해당 이메일 또는 비밀번호를 가진 회원이 없어요");
		location.href="loginPage";
	}else{
		location.href="/";
	}
</script>