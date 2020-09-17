package OneBread;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BusProcessor {
	private final String KEY = "MLhkYkhdgPL%2B8C1eLxqkgbl9mpt8hJ0kQCNydi2Uram5VvzqdQPik5xT5%2B7%2Fiy42qLtSl%2BgryEcvs6%2FtGsPCxA%3D%3D";

	public BusProcessor() {
		// null
	}

	public String getBus(String arsId) {
		String busUrl = ""; // 버스 api 호출에 사용되는 url
		String busInfo = ""; // 버스 정보

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document xmlDoc = null;
			Element root = null;

			busUrl += "http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid?";
			busUrl += "serviceKey=" + KEY + "&";
			busUrl += "arsId=" + arsId;

			xmlDoc = parser.parse(busUrl);
			root = xmlDoc.getDocumentElement();

			Node xmlNode1itemList = null;
			Node xmlNode2arrmsg1 = null; // 도착 정보
			Node xmlNode2rtNm = null; // 버스 번호
			Node xmlNode2stNm = null; // 버스 정류장 명

			if(root.getElementsByTagName("itemList").getLength() == 0) {
				busInfo += "No Bus Error";
				return busInfo;
			}
			
			xmlNode1itemList = root.getElementsByTagName("itemList").item(0);
			xmlNode2stNm = ((Element) xmlNode1itemList).getElementsByTagName("stNm").item(0); // 버스 정류장 명
			busInfo += xmlNode2stNm.getTextContent() + " (" + arsId + ")\n";
			
			for (int i = 0; i < root.getElementsByTagName("itemList").getLength(); i++) {
				xmlNode1itemList = root.getElementsByTagName("itemList").item(i);
				xmlNode2rtNm = ((Element) xmlNode1itemList).getElementsByTagName("rtNm").item(0); // 버스 번호
				xmlNode2arrmsg1 = ((Element) xmlNode1itemList).getElementsByTagName("arrmsg1").item(0); // 도착 정보
				
				busInfo += xmlNode2rtNm.getTextContent() + "번 ";
				busInfo += xmlNode2arrmsg1.getTextContent() + "\n";
			}
			
			busInfo = busInfo.substring(0, busInfo.length() - 1);   // 마지막 "\n" 문자 제거
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		return busInfo;
	}
}