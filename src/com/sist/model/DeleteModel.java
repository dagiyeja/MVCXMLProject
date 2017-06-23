package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
// delete(String pwd,int no,int page)
// insert(BoardVO vo)
public class DeleteModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String pwd=req.getParameter("pwd");
		String no=req.getParameter("no");
		String page=req.getParameter("page");
		//DAO¿¬°á 
		boolean bCheck=BoardDAO.
			boardDelete(Integer.parseInt(no), pwd);
		req.setAttribute("page", page);
		req.setAttribute("bCheck", bCheck);
		return "board/delete.jsp";
	}

}





