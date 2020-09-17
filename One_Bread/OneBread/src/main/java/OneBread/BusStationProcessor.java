package OneBread;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BusStationProcessor {
	private final String KEY = "MLhkYkhdgPL%2B8C1eLxqkgbl9mpt8hJ0kQCNydi2Uram5VvzqdQPik5xT5%2B7%2Fiy42qLtSl%2BgryEcvs6%2FtGsPCxA%3D%3D";

	public BusStationProcessor() {
		// null
	}

	public ArrayList<String> getBusStation(String location) {
		String busStationUrl = ""; // 버스 정류장 api 호출에 사용되는 url
		String busStationInfo = ""; // 버스 정류장 정보
		ArrayList<String> busStationArray = new ArrayList<String>(); // 버스 정류장 정보를 담기위해 사용

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document xmlDoc = null;
			Element root = null;

			busStationUrl += "http://ws.bus.go.kr/api/rest/stationinfo/getStationByName?";
			busStationUrl += "serviceKey=" + KEY + "&";
			busStationUrl += "stSrch=" + location;

			xmlDoc = parser.parse(busStationUrl);
			root = xmlDoc.getDocumentElement();

			Node xmlNode1itemList = null;
			Node xmlNode2arsId = null; // 버스 정류장 고유번호
			Node xmlNode2stNm = null; // 버스 정류장 명

			for (int i = 0; i < root.getElementsByTagName("itemList").getLength(); i++) { // 검색된 버스 정류장 개수만큼 반복한다.
				xmlNode1itemList = root.getElementsByTagName("itemList").item(i);
				xmlNode2stNm = ((Element) xmlNode1itemList).getElementsByTagName("stNm").item(0); // 버스 정류장 명
				busStationInfo += xmlNode2stNm.getTextContent();
				busStationInfo += " 정류장 (";
				xmlNode2arsId = ((Element) xmlNode1itemList).getElementsByTagName("arsId").item(0); // 버스 정류장 고유번호
				busStationInfo += xmlNode2arsId.getTextContent();
				busStationInfo += ")";
				busStationArray.add(busStationInfo); // 버스 정류장 정보를 배열에 추가한다.
				busStationInfo = ""; // 새로운 버스 정류장 정보를 입력 받기 위해 초기화한다.
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		return busStationArray;
	}
}