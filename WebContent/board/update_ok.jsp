<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
  <c:when test="${bCheck==true }">
    <c:redirect url="content.do?no=${no }&page=${page }"/>
  </c:when>
  <c:otherwise>
     <script>
     alert("비밀번호가 틀립니다");
     history.back();
     </script>
  </c:otherwise>
</c:choose>