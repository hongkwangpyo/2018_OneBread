package OneBread;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SubwayProcessor {
	private final String KEY = "62567a4e57746c7336347564684c75";

	public SubwayProcessor() {
		// null
	}

	public String getSubway(String line, String location) {
		String subwayUrl = ""; // 지하철 api 호출에 사용되는 url
		String subwayInfo = ""; // 지하철 정보
		String lineCode = ""; // 지하철 노선 코드

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document xmlDoc = null;
			Element root = null;

			subwayUrl += "http://swopenapi.seoul.go.kr/api/subway" + "/";
			subwayUrl += KEY + "/";
			subwayUrl += "xml" + "/";
			subwayUrl += "realtimeStationArrival" + "/";
			subwayUrl += "0" + "/";
			subwayUrl += "20" + "/";
			subwayUrl += URLEncoder.encode(location, "UTF-8");

			xmlDoc = parser.parse(subwayUrl);
			root = xmlDoc.getDocumentElement();

			Node xmlNode1row = null;
			Node xmlNode2subwayId = null; // 지하철 노선 코드
			Node xmlNode2trainLineNm = null; // 도착지 방면
			Node xmlNode2arvlMsg2 = null; // 첫번째 도착 메시지

			if (line.equals("1호선")) {
				lineCode = "1001";
			} else if (line.equals("2호선")) {
				lineCode = "1002";
			} else if (line.equals("3호선")) {
				lineCode = "1003";
			} else if (line.equals("4호선")) {
				lineCode = "1004";
			} else if (line.equals("5호선")) {
				lineCode = "1005";
			} else if (line.equals("6호선")) {
				lineCode = "1006";
			} else if (line.equals("7호선")) {
				lineCode = "1007";
			} else if (line.equals("8호선")) {
				lineCode = "1008";
			} else if (line.equals("9호선")) {
				lineCode = "1009";
			} else if (line.equals("경춘선")) {
				lineCode = "1067";
			} else if (line.equals("경의중앙선")) {
				lineCode = "1063";
			} else if (line.equals("분당선")) {
				lineCode = "1075";
			} else if (line.equals("신분당선")) {
				lineCode = "1077";
			}

			SubwayArrivalInformation subwayArrivalInfo = null; // 도착 정보를 저장하기 위해 사용하는 객체
			ArrayList<SubwayArrivalInformation> subwayArrivalInfoArr = new ArrayList<SubwayArrivalInformation>();

			for (int i = 0; i < root.getElementsByTagName("row").getLength(); i++) {
				xmlNode1row = root.getElementsByTagName("row").item(i);
				xmlNode2subwayId = ((Element) xmlNode1row).getElementsByTagName("subwayId").item(0); // 지하철 노선 코드
				xmlNode2trainLineNm = ((Element) xmlNode1row).getElementsByTagName("trainLineNm").item(0); // 도착지 방면
				xmlNode2arvlMsg2 = ((Element) xmlNode1row).getElementsByTagName("arvlMsg2").item(0); // 첫번째 도착 메시지

				// 사용자가 입력한 노선의 코드와 api 호출을 통해 가져온 지하철 데이터의 노선의 코드가 같은 경우
				// ex) 사용자가 1호선을 입력했다면 1호선에 해당하는 정보만을 가져온다.
				if (lineCode.equals(xmlNode2subwayId.getTextContent())) {
					subwayArrivalInfo = new SubwayArrivalInformation(); // 도착 정보를 저장하는 객체를 생성한다.

					subwayArrivalInfo.setSubwayId(xmlNode2subwayId.getTextContent()); // 지하철 노선 코드 설정
					subwayArrivalInfo.setTrainLineNm(xmlNode2trainLineNm.getTextContent()); // 도착지 방면 설정
					subwayArrivalInfo.setArrlMsg2(xmlNode2arvlMsg2.getTextContent()); // 첫번째 도착 메시지 설정

					subwayArrivalInfoArr.add(subwayArrivalInfo); // 도착 정보를 저장하는 객체를 subwayArrivalInfoArr 배열에 저장한다.
				}
			}

			ArrayList<String> arrlMsg2Arr = null;
			HashMap<String, ArrayList<String>> subwayArrivalInfoHashMap = new HashMap<String, ArrayList<String>>();
			String trainLineNm;

			// 사용자가 요구한 노선의 도착 정보의 개수만큼 반복한다.
			// ex) 사용자가 1호선을 입력했다면 1호선과 관련된 도착 정보의 개수만큼 반복한다.
			for (int i = 0; i < subwayArrivalInfoArr.size(); i++) {
				trainLineNm = subwayArrivalInfoArr.get(i).getTrainLineNm(); // 도착지 방면 정보를 가져온다.
				arrlMsg2Arr = new ArrayList<String>(); // 첫번째 도착 메시지를 저장하기 위한 ArrayList를 생성한다.

				// 다시 처음부터 반복한다.
				for (int j = 0; j < subwayArrivalInfoArr.size(); j++) {
					// 위에서 가져온 도착지 방면 정보와 각 객체에서 도착지 방면 정보가 일치하는 것을 찾는다.
					if (trainLineNm.equals(subwayArrivalInfoArr.get(j).getTrainLineNm())) {
						// 일치하는 객체를 찾으면 객체에서 첫번째 도착 메시지를 가져와서 ArrayList에 저장한다.
						arrlMsg2Arr.add(subwayArrivalInfoArr.get(j).getArrlMsg2());
					}
				}

				// 위에서 만들어진 arrlMsg2Arr에는 중복된 데이터가 들어있다.
				// HashMap은 중복된 key를 허용하지 않기 때문에 중복된 내용(도착 메시지)을 저장하지 않는다.
				// 똑같은 key로 put을 하면 새로 추가되는 것이 아니라 기존의 key에 해당하는 value가 변경되기 때문이다.
				// HashMap에 Key는 "도착지 방면 정보", value는 "첫번째 도착 메시지의 ArrayList"를 저장한다.
				// ex) key는 "성수행 - 방배방면", value는 "[2분 21초 후, 7분 10초 후]"
				subwayArrivalInfoHashMap.put(trainLineNm, arrlMsg2Arr);
			}

			// HashMap에서 value를 가져오려면 key가 필요하지만 위에서 모든 key값을 저장해놓지 않았다.
			// 그래서, HashMap의 ksySet() 메소드를 사용하여 모든 key값을 가져온다.
			Set<String> keySet = subwayArrivalInfoHashMap.keySet();

			// Set에서 데이터를 가져오기 위해 Iterator를 이용한다.
			// Iterator를 이용하면 Set의 처음부터 끝까지 모든 원소에 접근할 수 있다.
			Iterator<String> iterator = keySet.iterator();

			// key값을 저장하기 위한 변수를 선언한다.
			String key = null;

			if (keySet.isEmpty()) {
				subwayInfo += "No Line Error";
				return subwayInfo;
			}

			subwayInfo += "<" + location + "역>" + " 열차 도착 정보" + "\n";

			while (iterator.hasNext()) { // 더 이상 key값이 없을때까지 반복한다.
				key = (String) iterator.next(); // Iterator를 통해 가져온 key 데이터를 String으로 변환한다.
				subwayInfo += key + "\n"; // subwayInfo에 key를 추가한다.

				// 도착지 방면에 따른 첫번째 도착 메시지의 개수만큼 반복한다.
				// 각 key에 따른 value(ArrayList)의 길이만큼 반복한다.
				for (int i = 0; i < subwayArrivalInfoHashMap.get(key).size(); i++) {
					subwayInfo += "> ";
					// subwayInfo에 첫번째 도착 메시지를 추가한다.
					subwayInfo += subwayArrivalInfoHashMap.get(key).get(i) + "\n";
				}
			}

			subwayInfo = subwayInfo.substring(0, subwayInfo.length() - 1); // 마지막 "\n" 문자 제거
		} catch (Exception e) {
			subwayInfo += "현재 지하철 조회 서비스가 응답하지 않고 있습니다." + "\n";
			subwayInfo += "잠시 후에 다시 시도해주세요.";
			return subwayInfo;
		}

		return subwayInfo;
	}
}