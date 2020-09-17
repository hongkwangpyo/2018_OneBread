package OneBread;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SubwayStationProcessor {
	private final String KEY = "6c456c4657746c733630686b436d48";

	public SubwayStationProcessor() {
		// null
	}

	public ArrayList<String> getSubwayStation(String location) {
		String subwayStationUrl = ""; // 지하철역 api 호출에 사용되는 url
		String subwayStationInfo = ""; // 지하철역 정보
		ArrayList<String> subwayStationArr = new ArrayList<String>(); // 지하철역 정보를 담기위해 사용

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document xmlDoc = null;
			Element root = null;

			subwayStationUrl += "http://openapi.seoul.go.kr:8088" + "/";
			subwayStationUrl += KEY + "/";
			subwayStationUrl += "xml" + "/";
			subwayStationUrl += "SearchInfoBySubwayNameService" + "/";
			subwayStationUrl += "1" + "/";
			subwayStationUrl += "10" + "/";
			subwayStationUrl += URLEncoder.encode(location, "UTF-8");

			xmlDoc = parser.parse(subwayStationUrl);
			root = xmlDoc.getDocumentElement();

			Node xmlNode1row = null;
			Node xmlNode2LINE_NUM = null;

			for (int i = 0; i < root.getElementsByTagName("row").getLength(); i++) {
				xmlNode1row = root.getElementsByTagName("row").item(i);
				xmlNode2LINE_NUM = ((Element) xmlNode1row).getElementsByTagName("LINE_NUM").item(0);

				if (xmlNode2LINE_NUM.getTextContent().equals("1")) {
					subwayStationInfo += location + "역 1호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("2")) {
					subwayStationInfo += location + "역 2호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("3")) {
					subwayStationInfo += location + "역 3호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("4")) {
					subwayStationInfo += location + "역 4호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("5")) {
					subwayStationInfo += location + "역 5호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("6")) {
					subwayStationInfo += location + "역 6호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("7")) {
					subwayStationInfo += location + "역 7호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("8")) {
					subwayStationInfo += location + "역 8호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("9")) {
					subwayStationInfo += location + "역 9호선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("G")) {
					subwayStationInfo += location + "역 경춘선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("K")) {
					subwayStationInfo += location + "역 경의중앙선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("B")) {
					subwayStationInfo += location + "역 분당선";
					subwayStationArr.add(subwayStationInfo);
				} else if (xmlNode2LINE_NUM.getTextContent().equals("S")) {
					subwayStationInfo += location + "역 신분당선";
					subwayStationArr.add(subwayStationInfo);
				}

				subwayStationInfo = "";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		return subwayStationArr;
	}
}