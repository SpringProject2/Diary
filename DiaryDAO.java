package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import vo.DiaryVO;

public class DiaryDAO{
	
	SqlSession sqlSession; //Mapper접근
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//다이어리 전체목록 조회
	public List<DiaryVO> selectList(){
		List<DiaryVO> list = sqlSession.selectList("cw.diary_list");
		return list;
	}
	
	//새 글 추가
	public int insert(DiaryVO vo) {
		//맵퍼로 딱 한개의 객체만 넘겨줄 수 있다.
		int res = sqlSession.insert("cw.diary_insert", vo);
		return res;
	}
	
	//글 삭제
	public int delete(DiaryVO vo ) {
		int res = sqlSession.delete("cw.diary_delete", vo);
		return res;
	}
	
	//수정을 위한 게시글 한 건 조회
	public DiaryVO selectOne( DiaryVO vo ) {
		DiaryVO updateVo = sqlSession.selectOne("cw.diary_one", vo);
		return updateVo;
	}
	
	//게시글 수정
	public int update( DiaryVO vo ) {
		int res = sqlSession.update("cw.diary_update", vo);
		return res;
	}
	
	
}
