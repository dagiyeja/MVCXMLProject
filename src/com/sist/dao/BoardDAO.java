package com.sist.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.*;
// {}
// ibatis(opensource) / mybatis(google)
public class BoardDAO {
  private static SqlSessionFactory ssf;
  static
  {
	  try
	  {
		  Reader reader=Resources.getResourceAsReader("Config.xml");
		  ssf=new SqlSessionFactoryBuilder().build(reader);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
  }
  public static List<BoardVO> boardListData(Map map)
  {
	  List<BoardVO> list=
			  new ArrayList<BoardVO>();
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  list=session.selectList("boardListData",map);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
	  return list;
  }
  // �������� 
  public int boardTotalPage()
  {
	  int total=0;
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  total=session.selectOne("boardTotalPage");
	  }catch(Exception ex)
	  {
		  System.out.println("boardTotalPage():"+ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
	  
	  return total;
  }
  // ���뺸��
  public static BoardVO boardContentData(int no)
  {
	  BoardVO vo=new BoardVO();
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  session.update("boardHitIncrement",no);
		  session.commit();
		  
		  vo=session.selectOne("boardContentData", no);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close(); //ConnectionPool ��ȯ
	  }
	  return vo;
  }
  // ����
  public static void boardInsert(BoardVO vo)
  {
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession(true);
		  session.insert("boardInsert",vo);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
  }
  // �亯
  public static void replyInsert(int pno,BoardVO vo)
  {
	  // pno => gi,gs,gt
	  // sql (*)
	  // insert
	  // depth ����
	  /*                   gi  gs  gt
	   *    AAAAA           1   0   0
	   *      =>DDDDD       1   1   1
	   *      =>BBBBB       1   2   1
	   *     
	   *       =>CCCCCC     1   3   2
	   *      
	   */
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  BoardVO pvo=session.selectOne("boardGroupInfoData", pno);
		  session.update("boardGroupStepIncrement",pvo);
		  
		  vo.setGroup_id(pvo.getGroup_id());
		  vo.setGroup_step(pvo.getGroup_step()+1);
		  vo.setGroup_tab(pvo.getGroup_tab()+1);
		  vo.setRoot(pno);
		  
		  session.insert("boardReplyInsert",vo);
		  session.update("boardDepthIncrement",pno);
		  session.commit();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
  }
  // ���� 
  public static BoardVO boardUpdateData(int no)
  {
	  BoardVO vo=new BoardVO();
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  
		  vo=session.selectOne("boardContentData", no);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close(); //ConnectionPool ��ȯ
	  }
	  return vo;
  }
  public static boolean boardUpdate(BoardVO vo)
  {
	  boolean bCheck=false;
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  String db_pwd=session.
				  selectOne("boardGetPwd",vo.getNo());
		  if(db_pwd.equals(vo.getPwd()))
		  {
			  bCheck=true;
			  session.update("boardUpdate",vo);
			  session.commit();
		  }
		
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
	  return bCheck;
  }
  // ���� 
  public static boolean boardDelete(int no,String pwd)
  {
	  boolean bCheck=false;
	  SqlSession session=null;
	  try
	  {
		  //��й�ȣ �˻�
		  session=ssf.openSession();
		  String db_pwd=session.selectOne("boardGetPwd",no);
		  if(db_pwd.equals(pwd))
		  {
			  bCheck=true;
			  BoardVO vo=session.selectOne("boardGetDepth", no);
			  if(vo.getDepth()==0)
			  {
				  session.delete("boardDelete",no);
			  }
			  else
			  {
				 session.update("boardSubjectUpdate",no); 
			  }
			  session.update("boardDepthDecrement",vo.getRoot());
		  }
		  //depth => d,u
		  //depth ����
		  session.commit();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
	  return bCheck;
  }
  // ã��
  public static List<BoardVO> boardFindData(Map map)
  {
	  List<BoardVO> list=
			  new ArrayList<BoardVO>();
	  SqlSession session=null;
	  try
	  {
		  session=ssf.openSession();
		  list=session.selectList("boardFindData",map);
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  session.close();
	  }
	  return list;
  }
}





