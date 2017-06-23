package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
public class UpdateOkModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("EUC-KR");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		String pwd=req.getParameter("pwd");
		String no=req.getParameter("no");
		String page=req.getParameter("page");
		
		BoardVO vo=new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		// DAO¿¬°á
		boolean bCheck=BoardDAO.boardUpdate(vo);
		req.setAttribute("bCheck", bCheck);
		req.setAttribute("no", no);
		req.setAttribute("page", page);
		return "board/update_ok.jsp";
	}

}
