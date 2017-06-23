<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
  <center>
    <h3>글쓰기</h3>
    <form method=post action="insert_ok.do">
    <table id="table_content" width=500>
      <tr>
       <td width=15%>이름</td>
       <td width=85%>
        <input type=text name=name size=12>
       </td>
      </tr>
      <tr>
       <td width=15%>제목</td>
       <td width=85%>
        <input type=text name=subject size=50>
       </td>
      </tr>
      <tr>
       <td width=15%>내용</td>
       <td width=85%>
        <textarea rows="10" cols="55" name=content></textarea>
       </td>
      </tr>
      <tr>
       <td width=15%>비밀번호</td>
       <td width=85%>
        <input type="password" name=pwd size=10>
       </td>
      </tr>
      <tr>
       <td colspan="2" align="center">
        <input type=submit value="글쓰기">
        <input type=button value="취소" 
          onclick="javascript:history.back()">
       </td>
      </tr>
    </table>
    </form>
  </center>
</body>
</html>








