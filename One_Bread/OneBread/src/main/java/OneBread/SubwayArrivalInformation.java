package OneBread;

public class SubwayArrivalInformation {
	private String subwayId; // 지하철 노선 코드
	private String trainLineNm; // 도착지 방면
	private String arrlMsg2; // 첫번째 도착 메시지
	
	public SubwayArrivalInformation() {
		this.subwayId = "";
		this.trainLineNm = "";
		this.arrlMsg2 = "";
	}
	
	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}
	
	public String getSubwayId() {
		return this.subwayId;
	}
	
	public void setTrainLineNm(String traninLineNm) {
		this.trainLineNm = traninLineNm;
	}
	
	public String getTrainLineNm() {
		return this.trainLineNm;
	}
	
	public void setArrlMsg2(String arrlMsg2) {
		this.arrlMsg2 = arrlMsg2;
	}
	
	public String getArrlMsg2() {
		return this.arrlMsg2;
	}
}