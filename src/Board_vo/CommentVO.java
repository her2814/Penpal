package Board_vo;

public class CommentVO {

	private int postNo;
	private String comment;
	private String uploadDay;
	private String writerID;
	private int commentlndax;
	
	
	public int getPostNo() {
		return postNo;
	}
	public CommentVO setPostNo(int postNo) {
		this.postNo = postNo;
		return this;
	}
	public String getComment() {
		return comment;
	}
	public CommentVO setComment(String comment) {
		this.comment = comment;
		return this;
	}
	public String getUploadDay() {
		return uploadDay;
	}
	public CommentVO setUploadDay(String uploadDay) {
		this.uploadDay = uploadDay;
		return this;
	}
	public String getWriterID() {
		return writerID;
	}
	public CommentVO setWriterID(String writerID) {
		this.writerID = writerID;
		return this;
	}
	public int getCommentlndax() {
		return commentlndax;
	}
	public CommentVO setCommentlndax(int commentlndax) {
		this.commentlndax = commentlndax;
		return this;
	}
	
}
