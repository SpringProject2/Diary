
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다이어리새글쓰기</title>

</head>
<body>
	<!-- 파일전송시 
	enctype="multipart/form-data"
	method="post"
	속성이 필수적으로 추가되어 있어야 한다 -->
	<form method="post" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>새 글 쓰기</caption>
			
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="diaryContent"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글쓰기" onclick="send(this.form);">
					<input type="button" value="취소" onclick="location.href='diary_list.do'">
				</td>
			</tr>
		</table>
	</form>
	<script src="/cyworld/resources/js/httpRequest.js"></script>	
<script>
	function send(f){
		
		var diaryContent = f.diaryContent.value;
		
		//유효성 체크
		if( diaryContent == '' ){
			alert("내용 입력은 필수입니다.");
			return;
		}
		
		f.action = "diary_insert.do";
		f.method = "post";
		f.submit();
	}
</script>
</body>
</html>














