<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
var i=0;
$(function(){
	
	$('#a_del').click(function(){
		if(i==0)
		{
			$('#del').show();
			i=1;
		}
		else
		{
			$('#del').hide();
			i=0;
		}
	});
	$('#delBtn').click(function(){
		var pwd=$('#pwd').val();
		// document.frm pwd.value
		if(pwd.trim()=="")
		{
			alert("비밀번호를 입력하세요");
			$('#pwd').focus();
			return;
		}
		$('#delFrm').submit();
	});
});
</script>
</head>
<body>
   <center>
     <h3>내용보기</h3>
     <table id="table_content" width=500>
       <tr>
        <th width=20%>번호</th>
        <td width=30% align=center>${vo.no }</td>
        <th width=20%>작성일</th>
        <td width=30% align=center>${vo.day }</td>
       </tr>
       <tr>
        <th width=20%>이름</th>
        <td width=30% align=center>${vo.name }</td>
        <th width=20%>조회수</th>
        <td width=30% align=center>${vo.hit }</td>
       </tr>
       <tr>
        <th width=20%>제목</th>
        <td colspan="3" align=left>${vo.subject }</td>
       </tr>
       <tr>
        <td colspan="4" align=left valign="top" height=200>${vo.content }</td>
       </tr>
     </table>
     <table id="table_content" width=500>
       <tr>
        <td align=right>
         <a href="reply.do?no=${vo.no }&page=${page}">답변</a>&nbsp;
         <a href="update.do?no=${vo.no }&page=${page}">수정</a>&nbsp;
         <a href="#" id="a_del">삭제</a>&nbsp;
         <a href="list.do?page=${page }">목록</a>
        </td>
       </tr>
       <tr id="del" style="display:none">
         <td align=right>
         <form method=post action="delete.do" id="delFrm">
                     비밀번호:<input type=password name=pwd size=10 id="pwd">
               <input type=hidden name=no value="${vo.no }">
               <input type=hidden name=page value="${page }">
               <input type=button value="삭제" id="delBtn">
         </form>
         </td>
       </tr>
     </table>
   </center>
</body>
</html>









