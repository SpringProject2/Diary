package com.korea.cyworld;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.DiaryDAO;

import util.Comm;
import vo.DiaryVO;


@Controller
public class CyworldController {

	@Autowired
	ServletContext app;// 현재 프로젝트의 기본정보들을 저장하고 있는 클래스

	@Autowired
	HttpServletRequest request;

	DiaryDAO diary_dao;

public void setDiary_dao(DiaryDAO diary_dao) {
 	this.diary_dao = diary_dao;
}

	// 다이어리 조회
	@RequestMapping(value= {"/","/diary_list.do"} )
	public String list(Integer idx,Model model)
	{

		List<DiaryVO> list = diary_dao.selectList();
//		model.addAttribute("idx", idx);
		model.addAttribute("list", list);// 바인딩 : jsp까지 정보운반
		return Comm.VIEW_PATH + "diary_list.jsp";// 포워딩

	}
	//다이어리 글 삽입 창 이동

	@RequestMapping("/diary_insert_form.do")
	public String insert_form() {
		return Comm.VIEW_PATH + "diary_insert_form.jsp";
	}

	// 새 글쓰기
	@RequestMapping("/diary_insert.do")
	// public String insert(String name, String content, String pwd) {
	public String insert(DiaryVO vo) {
		
		    vo.setDiaryContentRef(1);//인덱스를 받지 않고 임시로 1로 넘김		
		    diary_dao.insert(vo);
			return "redirect:diary_list.do";
	}

	// 게시글 삭제
	@RequestMapping("/diary_delete.do")
	@ResponseBody // Ajax로 요청된 메서드는 결과를 콜백메서드로 돌려주기 위해 반드시 @ResponseBody가 필요!!
	public String delete(DiaryVO vo) {
		// delete.do?idx=1
		int res = diary_dao.delete(vo);

		String result = "no";
		if (res == 1) {
			result = "yes";
		}
		// yes, no값을 가지고 콜백메서드(resultFn)로 돌아간다
		// 콜백으로 리턴되는 값은 영문으로 보내준다
		return result;
	}

	// 글 수정 폼으로 전환
	@RequestMapping("/diary_modify_form.do")
	public String modify_form(Model model, DiaryVO vo) {
		// modify_form.do?idx=2&pwd=1111&c_pwd=1111
		DiaryVO updateVo = diary_dao.selectOne(vo);

		if (updateVo != null) {
			model.addAttribute("vo", updateVo);
		}

		return Comm.VIEW_PATH + "diary_modify_form.jsp";

	}

	// 게시글 수정하기
	@RequestMapping("/diary_modify.do")
	@ResponseBody
	public String modify(DiaryVO vo) {

		int res = diary_dao.update(vo);

		String result = "{'result':'no'}";
		if (res != 0) {
			result = "{'result':'yes'}";
		}

		return result;
	}
}

