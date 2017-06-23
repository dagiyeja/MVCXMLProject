package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class ContentModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String no=req.getParameter("no");
		String page=req.getParameter("page");
		//DAO¿¬°á ==> VO
		BoardVO vo=BoardDAO.boardContentData(Integer.parseInt(no));
		req.setAttribute("vo", vo);
		req.setAttribute("page",page);
		return "board/content.jsp";
	}

}
