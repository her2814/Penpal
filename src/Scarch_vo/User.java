package Scarch_vo;


public class User {
	private String id; 				// 아이디
	private String password;		// 패스워드
	private String name;			// 이름
	private int age; 				// 나이
	private String hobby	;		// 취미
	private String nationality; 	// 국적 
	private String message; 		// 자기소개
	private String address;  		// 주소
	private String language; 		// 언어
	private String religion; 		// 종교
	private String job;				// 직업
	private String admin_flag; 		// 관리자 판단
	private String email; 			// 이메일
	private int question; 			// 비밀번호 찾기 질문
	private String answer;			// 비밀번호 찾기 답
	private String suspension;		// 정지
	private String photo; 			// 사진
		
	
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public User setAge(int age) {
		this.age = age;
		return this;
	}
	public String getHobby() {
		return hobby;
	}
	public User setHobby(String hobby) {
		this.hobby = hobby;
		return this;
	}
	public String getNationality() {
		return nationality;
	}
	public User setNationality(String nationality) {
		this.nationality = nationality;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public User setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public User setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getLanguage() {
		return language;
	}
	public User setLanguage(String language) {
		this.language = language;
		return this;
	}
	public String getReligion() {
		return religion;
	}
	public User setReligion(String religion) {
		this.religion = religion;
		return this;
	}
	public String getJob() {
		return job;
	}
	public User setJob(String job) {
		this.job = job;
		return this;
	}
	public String getAdmin_flag() {
		return admin_flag;
	}
	public User setAdmin_flag(String admin_flag) {
		this.admin_flag = admin_flag;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public int getQuestion() {
		return question;
	}
	public User setQuestion(int question) {
		this.question = question;
		return this;
	}
	public String getAnswer() {
		return answer;
	}
	public User setAnswer(String answer) {
		this.answer = answer;
		return this;
	}
	public String getSuspension() {
		return suspension;
	}
	public User setSuspension(String suspension) {
		this.suspension = suspension;
		return this;
	}
	public String getPhoto() {
		return photo;
	}
	public User setPhoto(String photo) {
		this.photo = photo;
		return this;
	}
		
}
