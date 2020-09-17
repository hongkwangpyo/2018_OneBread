package OneBread;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class OneBread implements RequestHandler<JSONObject, JSONObject> {
	@Override
	public JSONObject handleRequest(JSONObject input, Context context) {
		// ===== 플러스친구 API v2.0 =====
		// *** Keyboard Response ***
		// "type" : "buttons"
		// "buttons" : (String Array)
		// ******************************

		// *** Message Response ***
		// "message"
		// >> "text" : (String)
		// >> "photo"
		// >> "url" : (String)
		// >> "width" : (Integer)
		// >> "height" : (Integer)
		// >> "message_button"
		// >> "label" : (String)
		// >> "url" : (String)
		// "keyboard"
		// >> "type" : "buttons"
		// >> "buttons" : (String Array)
		// *****************************
		// =======================

		NaturalLanguageProcessor naturalLangProc = new NaturalLanguageProcessor();
		WeatherProcessor weatherProc = new WeatherProcessor();
		BusStationProcessor busStationProc = new BusStationProcessor();
		BusProcessor busProc = new BusProcessor();
		SubwayStationProcessor subwayStationProc = new SubwayStationProcessor();
		SubwayProcessor subwayProc = new SubwayProcessor();

		JSONObject message = new JSONObject(); // message에 text, photo, message_button 입력시 사용
		JSONObject keyboard = new JSONObject(); // keyboard에 type, buttons 입력시 사용
		JSONObject photo = new JSONObject(); // photo에 url, width, height 입력시 사용
		JSONObject message_button = new JSONObject(); // message_button에 label, url 입력시 사용
		JSONObject output = new JSONObject();

		JSONArray jArray = new JSONArray();
		
		Random random = new Random();

		ArrayList<String> refinementArr = new ArrayList<String>();
		ArrayList<String> busStationArr = new ArrayList<String>();
		ArrayList<String> subwayStationArr = new ArrayList<String>();

		String strInput = (String) input.get("content");
		String strOutput = "";
		int randomNum;

		if (strInput == null) { // 사용자가 플러스친구에 접속한 경우
			jArray.add("안녕?");
			output.put("type", "buttons");
			output.put("buttons", jArray);
			return output;
		}

		if (strInput.contains("안녕")) { // "안녕?"이 입력된 경우
			randomNum = random.nextInt(3); // 0 ~ 2의 랜덤 숫자 생성

			if (randomNum == 0) {
				message.put("text", "(미소)안녕하세요? 빵한조각입니다 (컵케이크b)\n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" +"구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			} else if (randomNum == 1) {
				message.put("text", "(윙크)또 어떤 정보를 찾아 오셨나요~ 제가 도와드릴게요~\n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" + "구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			} else if (randomNum == 2) {
				message.put("text", "(방긋)자주 보네요~ 빵 한조각에 (커피)한잔?\n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" + "구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			}
			return output;
		}

		if (strInput.contains("처음")) { // "처음"이 입력된 경우
			randomNum = random.nextInt(3); // 0 ~ 2의 랜덤 숫자 생성

			if (randomNum == 0) {
				message.put("text", "(씨익)자! 처음부터 다시다시☆ \n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" + "구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			} else if (randomNum == 1) {
				message.put("text", "(훌쩍)우리 처음부터 다시해봐요⊙.⊙\n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" + "구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			} else if (randomNum == 2) {
				message.put("text", "(멘붕)새로운 정보를 찾아보자!\n " + "★저는 이런 서울정보를 알려드려요★\n"  
						+ "       (해) 날씨 (비) \n " + "      (음표) 버스 (음표)\n" +  "      (굿) 지하철 (꺄아) \n\n" + "      어떤게 궁금하세요?"
						+ "\n" + "궁금한 지역 + 원하는 정보 순으로 입력해주세요\n" + " ======== 간단 예시 ======== \n     ◆ [강남 날씨]\n     ◆ [서초동 버스]\n     ◆ [신림 지하철]\n" 
						+ " ========================\n" + "구체적인 설명서가 필요하시다면 '설명서'라고 입력해보세요.");
				output.put("message", message);
			}
			return output;
		}

		if (strInput.contains("설명")) {
			message.put("text", "     (해)(구름)날씨 정보 가이드 (비)(눈)\n" + "\n'강남 날씨'나 '신림동 날씨'처럼 입력해보세요!\n" + "\n" + "     (음표)버스 정보 가이드(음표)\n"
					+ "\n'서초동 버스'처럼 입력해보세요!\n" + "버스 정류장 번호를 알고 있으시다면 '22579 정류장'처럼 입력하시면 해당 정류장에 대한 버스 정보를 받아보실 수 있어요.\n"
					+ "\n" + "     (굿)지하철 정보 가이드 (꺄아)\n" + "\n'사당역 지하철'처럼 입력해보세요!\n" + "지하철 노선을 알고 있으시다면 '사당역 4호선'처럼 입력해보세요.");
			output.put("message", message);
			return output;
		}

		// 복잡한 메시지인 경우에는 자연어를 처리하는 객체에 메시지를 보내 처리한다.
		// 입력된 메시지에서 중요한 단어를 찾아낸다.
		refinementArr = naturalLangProc.getWord(strInput);

		if (refinementArr.size() == 1) {
			message.put("text", "제가 답변해드릴수 없는 질문이네요.\n" +  " '설명서'를 치셔서 정확한 사용법을 체크해보세요");
			output.put("message", message);
			return output;
		}

		if (refinementArr.get(0).equals("날씨")) { // "날씨"가 있는 경우
			strOutput = weatherProc.getWeather(refinementArr.get(1));

			if (strOutput.equals("No Location Error")) {
				message.put("text", "제가 답변해드릴수 없는 질문이네요.\n" +  " '설명서'를 치셔서 정확한 사용법을 체크해보세요");
				output.put("message", message);

				jArray.add("<처음으로>");

				keyboard.put("type", "buttons");
				keyboard.put("buttons", jArray);
				output.put("keyboard", keyboard);
			} else {
				message.put("text", strOutput);
				output.put("message", message);
			}
		} else if (refinementArr.get(0).equals("버스")) { // "버스"가 있는 경우
			busStationArr = busStationProc.getBusStation(refinementArr.get(1));
			if (busStationArr.size() == 0) {
				message.put("text", "    (심각)처음 듣는 정보군요(심각)"+ "\n질문을 다시 확인해주시겠어요?" + "\n\n사용법을 잘 모르시는 경우 '설명서' 라고 입력해주시면 자세히 알려드릴게요 (쑥스)");
				output.put(("message"), message);
			}
			else {message.put("text", refinementArr.get(1) + "(으)로 검색하셨네요 ? 제가 주변을 찾아본 결과 총 " + busStationArr.size()
					+ "건 검색되었어요. \n찾고 계시는 정류장 버튼을 클릭해주세요.");
				output.put("message", message);
				for (int i = 0; i < busStationArr.size(); i++) {
					jArray.add(busStationArr.get(i));
				}
			}

			jArray.add("<처음으로>");

			keyboard.put("type", "buttons");
			keyboard.put("buttons", jArray);
			output.put("keyboard", keyboard);
		} else if (refinementArr.get(0).equals("정류장")) { // "정류장"이 있는 경우
			strOutput = busProc.getBus(refinementArr.get(1));
			
			if (strOutput.equals("No Bus Error")) {
				message.put("text", "    (심각)처음 듣는 정보군요(심각)"+ "\n질문을 다시 확인해주시겠어요?" + "\n\n사용법을 잘 모르시는 경우 '설명서' 라고 입력해주시면 자세히 알려드릴게요 (쑥스)");
				output.put(("message"), message);

				jArray.add("<처음으로>");

				keyboard.put("type", "buttons");
				keyboard.put("buttons", jArray);
				output.put("keyboard", keyboard);
			} else {
				message.put("text", strOutput);
				output.put("message", message);
			}
		} else if (refinementArr.get(0).equals("지하철")) { // "지하철"이 있는 경우
			subwayStationArr = subwayStationProc.getSubwayStation(refinementArr.get(1));
			
			if (subwayStationArr.size() == 0) {
				message.put("text", "    (심각)처음 듣는 정보군요(심각)"+ "\n질문을 다시 확인해주시겠어요?" + "\n\n사용법을 잘 모르시는 경우 '설명서' 라고 입력해주시면 자세히 알려드릴게요 (쑥스)");
				output.put("message", message);
			}
			
			else {
				message.put("text", "해당 지하철역에는 " + subwayStationArr.size() + "개의 호선이 있어요\n"
				+ "몇 호선 정보가 필요하세요?");
				output.put("message", message);	
	
				for (int i = 0; i < subwayStationArr.size(); i++) {
					jArray.add(subwayStationArr.get(i));
				}
			}
			
			jArray.add("<처음으로>");
			
			keyboard.put("type", "buttons");
			keyboard.put("buttons", jArray);
			output.put("keyboard", keyboard);

		} else if (refinementArr.get(0).equals("노선")) { // "노선"이 있는 경우
			strOutput = subwayProc.getSubway(refinementArr.get(1), refinementArr.get(2));
					
			if (strOutput.equals("No Line Error")) {
				message.put("text", "검색하신 역에는 없는 호선이에요(좌절).\n" + "다시 한번 확인해주세요");
				output.put("message", message);

				jArray.add("<처음으로>");

				keyboard.put("type", "buttons");
				keyboard.put("buttons", jArray);
				output.put("keyboard", keyboard);
			} else {
				message.put("text", strOutput);
				output.put("message", message);
			}
		}

		return output;
	}
}