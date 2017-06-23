<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
   <center>
     <h3>게시판 목록</h3>
     <table id="table_content" width=700>
      <tr>
       <td align=left>
        <a href="insert.do">새글</a>
       </td>
      </tr>
     </table>
     <table id="table_content" width=700>
       <tr>
        <th width=10%>번호</th>
        <th width=45%>제목</th>
        <th width=15%>이름</th>
        <th width=20%>작성일</th>
        <th width=10%>조회수</th>
       </tr>
       <c:forEach var="vo" items="${list }">
         <tr class="dataTr">
          <td width=10% align=center>${vo.no }</td>
          <td width=45%>
          <c:if test="${vo.group_tab>0 }">
            <c:forEach var="i" begin="1" end="${vo.group_tab }">
              &nbsp;&nbsp;
            </c:forEach>
            <img src="image/icon_reply.gif">
          </c:if>
           <c:if test="${vo.subject!=msg}">
           <a href="content.do?no=${vo.no }&page=${curpage}">${vo.subject }</a>
           </c:if>
           <c:if test="${vo.subject==msg }">
            <span style="color:gary">${vo.subject }</span>
           </c:if>
           <c:if test="${today==vo.day }">
             <sup><img src="image/new.gif"></sup>
           </c:if>
          </td>
          <td width=15% align=center>${vo.name }</td>
          <td width=20% align=center>
           <fmt:formatDate value="${vo.regdate }" 
            pattern="yyyy-MM-dd"
           />
          </td>
          <td width=10% align=center>${vo.hit }</td>
         </tr>
       </c:forEach>
     </table>
     <table border=0 width=700>
       <tr>
        <td align=left>
        <form method=post action="find.do">
         Search:<select name=fs>
           <option value="name">이름</option>
           <option value="subject">제목</option>
           <option value="content">내용</option>
         </select>
         <input type=text name=ss size=10>
         <input type=submit value="검색">
         </form>
        </td>
        <td align=right>
         <a href="list.do?page=${curpage>1?curpage-1:curpage }">
         <img src="image/prev_a.gif"></a>&nbsp;
         <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }">
         <img src="image/next_a.gif"></a>&nbsp;&nbsp;
         ${curpage } page / ${totalpage } pages
        </td>
       </tr>
     </table>
   </center>
</body>
</html>






