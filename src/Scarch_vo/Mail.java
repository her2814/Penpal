package Scarch_vo;

public class Mail {

	private int mailNo; 			// 硫붿씪 踰덊샇 	
	private String senderld;		// 蹂대궡�뒗 �궗�엺
	private String recverld; 	// 諛쏅뒗 �궗�엺
	private String mailName; 	// 硫붿씪�젣
	private String mailContent; // �궡�슜
	private String date; 		// �뜲�씠�꽣
	
	public int getMailNo() {
		return mailNo;
	}
	public Mail setMailNo(int mailNo) {
		this.mailNo = mailNo;
		return this;
	}
	public String getSenderld() {
		return senderld;
	}
	public Mail setSenderld(String senderld) {
		this.senderld = senderld;
		return this;
	}
	public String getRecverld() {
		return recverld;
	}
	public Mail setRecverld(String recverld) {
		this.recverld = recverld;
		return this;
	}
	public String getMailName() {
		return mailName;
	}
	public Mail setMailName(String mailName) {
		this.mailName = mailName;
		return this;
	}
	public String getMailContent() {
		return mailContent;
	}
	public Mail setMailContent(String mailContent) {
		this.mailContent = mailContent;
		return this;
	}
	public String getDate() {
		return date;
	}
	public Mail setDate(String date) {
		this.date = date;
		return this;
	}
	
	
	

}
