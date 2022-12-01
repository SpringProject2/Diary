package vo;

import org.springframework.web.multipart.MultipartFile;

public class DiaryVO {
	private String diaryContent;// 다이어리 내용
	private String diaryRegdate;// 댓글 작성시간
	private int diaryContentRef;// 다이어리 작성글 번호
	private int diaryIdx;// 인덱스
	
		public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	public String getDiaryRegdate() {
		return diaryRegdate;
	}
	public void setDiaryRegdate(String diaryRegdate) {
		this.diaryRegdate = diaryRegdate;
	}
	public int getDiaryContentRef() {
		return diaryContentRef;
	}
	public void setDiaryContentRef(int diaryContentRef) {
		this.diaryContentRef = diaryContentRef;
	}
	public int getDiaryIdx() {
		return diaryIdx;
	}
	public void setDiaryIdx(int diaryIdx) {
		this.diaryIdx = diaryIdx;
	}

	}



