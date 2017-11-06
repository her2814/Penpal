package Board_vo;

public class BoardVO {

	private int postNo;
	private String hits;
	private String writerID;
	private String like;
	private String postname;
	private String uploadDay;
	private String postContent;
	private String photo;
	
	
	public int getPostNo() {
		return postNo;
	}
	public BoardVO setPostNo(int postNo) {
		this.postNo = postNo;
		return this;
	}
	public String getHits() {
		return hits;
	}
	public BoardVO setHits(String hits) {
		this.hits = hits;
		return this;
	}
	public String getWriterID() {
		return writerID;
	}
	public BoardVO setWriterID(String writerID) {
		this.writerID = writerID;
		return this;
	}
	public String getLike() {
		return like;
	}
	public BoardVO setLike(String like) {
		this.like = like;
		return this;
	}
	public String getPostname() {
		return postname;
	}
	public BoardVO setPostname(String postname) {
		this.postname = postname;
		return this;
	}
	public String getUploadDay() {
		return uploadDay;
	}
	public BoardVO setUploadDay(String uploadDay) {
		this.uploadDay = uploadDay;
		return this;
	}
	public String getPostContent() {
		return postContent;
	}
	public BoardVO setPostContent(String postContent) {
		this.postContent = postContent;
		return this;
	}
	public String getPhoto() {
		return photo;
	}
	public BoardVO setPhoto(String photo) {
		this.photo = photo;
		return this;
	}
}
