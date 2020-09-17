package OneBread;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class WeatherProcessor {
	private final String KEY = "PkGMdSIFCcSJ3j5I9CYvK0pyoganM2H7Rt4bj0JI6YaS9Io%2FLIfV9XzYU%2FgBXnJoKLTHN3CW91RmkcNnVWmPlg%3D%3D";
	
	public WeatherProcessor() {
		// null
	}

	public String getWeather(String location) {
		String sidoName = "서울"; // 시도 명
		String dustUrl = ""; // 미세먼지 api 호출에 사용되는 url
		String weatherUrl = ""; // 날씨 api 호출에 사용되는 url
		String weatherInfo = ""; // 날씨 정보

		// ========== 강남구 ========== //
		if (location.contains("강남")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168060000"; // 서울특별시 강남구 대치1동 날씨
		} else if(location.contains("개포1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168066000"; // 서울특별시 강남구 개포1동 날씨
		} else if(location.contains("개포2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168067000"; // 서울특별시 강남구 개포2동 날씨
		} else if(location.contains("개포4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168069000"; // 서울특별시 강남구 개포4동 날씨
		} else if(location.contains("개포")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168066000"; // 서울특별시 강남구 개포1동 날씨
		} else if(location.contains("논현1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168052100"; // 서울특별시 강남구 논현1동 날씨
		} else if(location.contains("논현2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168053100"; // 서울특별시 강남구 논현2동 날씨
		} else if(location.contains("논현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168053100"; // 서울특별시 강남구 논현1동 날씨
		} else if(location.contains("대치1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168060000"; // 서울특별시 강남구 대치1동 날씨
		} else if(location.contains("대치2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168061000"; // 서울특별시 강남구 대치2동 날씨
		} else if(location.contains("대치4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168063000"; // 서울특별시 강남구 대치4동 날씨
		} else if(location.contains("대치")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168060000"; // 서울특별시 강남구 대치1동 날씨
		} else if(location.contains("도곡1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168065500"; // 서울특별시 강남구 도곡1동 날씨
		} else if(location.contains("도곡2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168065600"; // 서울특별시 강남구 도곡2동 날씨
		} else if(location.contains("도곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168065500"; // 서울특별시 강남구 도곡1동 날씨
		} else if(location.contains("삼성1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168058000"; // 서울특별시 강남구 삼성1동 날씨
		} else if(location.contains("삼성2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168059000"; // 서울특별시 강남구 삼성2동 날씨
		} else if(location.contains("삼성")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168058000"; // 서울특별시 강남구 삼성1동 날씨
		} else if(location.contains("세곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168070000"; // 서울특별시 강남구 세곡동 날씨
		} else if(location.contains("수서")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168075000"; // 서울특별시 강남구 수서동 날씨
		} else if(location.contains("신사")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168051000"; // 서울특별시 강남구 신사동 날씨
		} else if(location.contains("압구정")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168054500"; // 서울특별시 강남구 압구정동 날씨
		} else if(location.contains("역삼1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168064000"; // 서울특별시 강남구 역삼1동 날씨
		} else if(location.contains("역삼2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168065000"; // 서울특별시 강남구 역삼2동 날씨
		} else if(location.contains("역삼")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168064000"; // 서울특별시 강남구 역삼1동 날씨
		} else if(location.contains("일원1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168073000"; // 서울특별시 강남구 일원1동 날씨
		} else if(location.contains("일원2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168074000"; // 서울특별시 강남구 일원2동 날씨
		} else if(location.contains("일원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168073000"; // 서울특별시 강남구 일원1동 날씨
		} else if(location.contains("일원본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168072000"; // 서울특별시 강남구 일원본동 날씨
		} else if(location.contains("청담")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1168056500"; // 서울특별시 강남구 청담동 날씨
		// ========================= //
			
		// ========== 강동구 ========== //
		} else if(location.contains("강동")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174051500"; // 서울특별시 강동구 강일동 날씨
		} else if(location.contains("강일")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174051500"; // 서울특별시 강동구 강일동 날씨
		} else if(location.contains("고덕1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174055000"; // 서울특별시 강동구 고덕1동 날씨
		} else if(location.contains("고덕2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174056000"; // 서울특별시 강동구 고덕2동 날씨
		} else if(location.contains("길")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174068500"; // 서울특별시 강동구 길동 날씨
		} else if(location.contains("둔촌1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174069000"; // 서울특별시 강동구 둔촌1동 날씨
		} else if(location.contains("둔촌2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174070000"; // 서울특별시 강동구 둔촌2동 날씨
		} else if(location.contains("둔촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174069000"; // 서울특별시 강동구 둔촌1동 날씨
		} else if(location.contains("명일1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174053000"; // 서울특별시 강동구 명일1동 날씨
		} else if(location.contains("명일2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174054000"; // 서울특별시 강동구 명일2동 날씨
		} else if(location.contains("명일")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174053000"; // 서울특별시 강동구 명일1동 날씨
		} else if(location.contains("상일")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174052000"; // 서울특별시 강동구 상일1동 날씨
		} else if(location.contains("성내1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174064000"; // 서울특별시 강동구 성내1동 날씨
		} else if(location.contains("성내2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174065000"; // 서울특별시 강동구 성내2동 날씨
		} else if(location.contains("성내3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174066000"; // 서울특별시 강동구 성내1동 날씨
		} else if(location.contains("성내")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174064000"; // 서울특별시 강동구 성내1동 날씨
		} else if(location.contains("암사1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174057000"; // 서울특별시 강동구 암사1동 날씨
		} else if(location.contains("암사2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174058000"; // 서울특별시 강동구 암사2동 날씨
		} else if(location.contains("암사3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174059000"; // 서울특별시 강동구 암사3동 날씨
		} else if(location.contains("암사")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174057000"; // 서울특별시 강동구 암사1동 날씨
		} else if(location.contains("천호1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174060000"; // 서울특별시 강동구 천호1동 날씨
		} else if(location.contains("천호2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174060000"; // 서울특별시 강동구 천호2동 날씨
		} else if(location.contains("천호3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174061000"; // 서울특별시 강동구 천호3동 날씨
		} else if(location.contains("천호")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1174062000"; // 서울특별시 강동구 천호1동 날씨
		// ========================= //
		
		// ========== 강북구 ========== //		
		} else if(location.contains("강북")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130553500"; // 서울특별시 강북구 미아동 날씨
		} else if(location.contains("미아")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130553500"; // 서울특별시 강북구 미아동 날씨
		} else if(location.contains("번제1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130559000"; // 서울특별시 강북구 변제1동 날씨
		} else if(location.contains("번제2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130560000"; // 서울특별시 강북구 변제2동 날씨
		} else if(location.contains("번제3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130560600"; // 서울특별시 강북구 변제3동 날씨
		} else if(location.contains("번제")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130559000"; // 서울특별시 강북구 변제1동 날씨
		} else if(location.contains("삼각산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130557500"; // 서울특별시 강북구 삼각산동 날씨
		} else if(location.contains("삼양")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130553400"; // 서울특별시 강북구 삼양동 날씨
		} else if(location.contains("송중")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130554500"; // 서울특별시 강북구 송중동 날씨
		} else if(location.contains("송천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130554500"; // 서울특별시 강북구 송천동 날씨
		} else if(location.contains("수유1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130561000"; // 서울특별시 강북구 수유1동 날씨
		} else if(location.contains("수유2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130562000"; // 서울특별시 강북구 수유2동 날씨
		} else if(location.contains("수유3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130563000"; // 서울특별시 강북구 수유3동 날씨
		} else if(location.contains("수유")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130561000"; // 서울특별시 강북구 수유1동 날씨
		} else if(location.contains("우이")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130564500"; // 서울특별시 강북구 우이동 날씨
		} else if(location.contains("인수")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1130566000"; // 서울특별시 강북구 인수동 날씨
		// ========================= //
			
		// ========== 강서구 ========== //	
		} else if(location.contains("강서")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150060300"; // 서울특별시 강서구 가양1동 날씨
		} else if(location.contains("가양1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150060300"; // 서울특별시 강서구 가양1동 날씨
		} else if(location.contains("가양2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150060400"; // 서울특별시 강서구 가양2동 날씨
		} else if(location.contains("가양3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150060500"; // 서울특별시 강서구 가양3동 날씨
		} else if(location.contains("가양")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150060300"; // 서울특별시 강서구 가양1동 날씨
		} else if(location.contains("공항")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150062000"; // 서울특별시 강서구 공힝동 날씨
		} else if(location.contains("등촌1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150052000"; // 서울특별시 강서구 등촌1동 날씨
		} else if(location.contains("등촌2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150053000"; // 서울특별시 강서구 등촌2동 날씨
		} else if(location.contains("등촌3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150053500"; // 서울특별시 강서구 등촌3동 날씨
		} else if(location.contains("등촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150052000"; // 서울특별시 강서구 등촌1동 날씨
		} else if(location.contains("발산1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150061100"; // 서울특별시 강서구 발산1동 날씨
		} else if(location.contains("발산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150061100"; // 서울특별시 강서구 발산1동 날씨
		} else if(location.contains("방화1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150063000"; // 서울특별시 강서구 방화1동 날씨
		} else if(location.contains("방화2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150064000"; // 서울특별시 강서구 방화2동 날씨
		} else if(location.contains("방화3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150064100"; // 서울특별시 강서구 방화3동 날씨
		} else if(location.contains("방화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150063000"; // 서울특별시 강서구 방화1동 날씨
		} else if(location.contains("염창")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150051000"; // 서울특별시 강서구 염창동 날씨
		} else if(location.contains("우장산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150061500"; // 서울특별시 강서구 우장산동 날씨
		} else if(location.contains("화곡본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150059000"; // 서울특별시 강서구 화곡본동 날씨
		} else if(location.contains("화곡1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150054000"; // 서울특별시 강서구 화곡1동 날씨
		} else if(location.contains("화곡2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150055000"; // 서울특별시 강서구 화곡2동 날씨
		} else if(location.contains("화곡3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150056000"; // 서울특별시 강서구 화곡3동 날씨
		} else if(location.contains("화곡4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150057000"; // 서울특별시 강서구 화곡4동 날씨
		} else if(location.contains("화곡6")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150059100"; // 서울특별시 강서구 화곡6동 날씨
		} else if(location.contains("화곡8")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150059300"; // 서울특별시 강서구 화곡8동 날씨
		} else if(location.contains("화곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1150054000"; // 서울특별시 강서구 화곡1동 날씨
		// ========================= //

		// ========== 관악구 ========== //	
		} else if(location.contains("관악")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162058500"; // 서울특별시 관악구 낙성대동 날씨
		} else if(location.contains("낙성대")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162058500"; // 서울특별시 관악구 낙성대동 날씨
		} else if(location.contains("난곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162077500"; // 서울특별시 관악구 난곡동 날씨
		} else if(location.contains("난향")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162071500"; // 서울특별시 관악구 난향동 날씨
		} else if(location.contains("남현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162063000"; // 서울특별시 관악구 남현동 날씨
		} else if(location.contains("대학")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162073500"; // 서울특별시 관악구 대학동 날씨
		} else if(location.contains("미성")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162076500"; // 서울특별시 관악구 미성동 날씨
		} else if(location.contains("보라매")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162052500"; // 서울특별시 관악구 보라매동 날씨
		} else if(location.contains("삼성")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162074500"; // 서울특별시 관악구 삼성동 날씨
		} else if(location.contains("서림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162066500"; // 서울특별시 관악구 서림동 날씨
		} else if(location.contains("서원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162064500"; // 서울특별시 관악구 서원동 날씨
		} else if(location.contains("성현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162056500"; // 서울특별시 관악구 성현동 날씨
		} else if(location.contains("신림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162069500"; // 서울특별시 관악구 신림동 날씨
		} else if(location.contains("신사")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162068500"; // 서울특별시 관악구 신사동 날씨
		} else if(location.contains("신원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162065500"; // 서울특별시 관악구 신원동 날씨
		} else if(location.contains("은천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162060500"; // 서울특별시 관악구 은천동 날씨
		} else if(location.contains("인헌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162062500"; // 서울특별시 관악구 인헌동 날씨
		} else if(location.contains("조원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162072500"; // 서울특별시 관악구 조헌동 날씨
		} else if(location.contains("중앙")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162061500"; // 서울특별시 관악구 중앙동 날씨
		} else if(location.contains("청룡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162059500"; // 서울특별시 관악구 청룡동 날씨
		} else if(location.contains("청림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162054500"; // 서울특별시 관악구 청림동 날씨
		} else if(location.contains("행운")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1162057500"; // 서울특별시 관악구 행운동 날씨
		// ========================= //
		
		// ========== 광진구 ========== //	
		} else if(location.contains("광진")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121581000"; // 서울특별시 광진구 광장동 날씨
		} else if(location.contains("광장")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121581000"; // 서울특별시 광진구 광장동 날씨
		} else if(location.contains("구의1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121585000"; // 서울특별시 광진구 구의1동 날씨
		} else if(location.contains("구의2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121586000"; // 서울특별시 광진구 구의2동 날씨
		} else if(location.contains("구의3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121587000"; // 서울특별시 광진구 구의3동 날씨
		} else if(location.contains("구의")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121585000"; // 서울특별시 광진구 구의1동 날씨
		} else if(location.contains("군자")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121573000"; // 서울특별시 광진구 군자동 날씨
		} else if(location.contains("능")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121578000"; // 서울특별시 광진구 능동 날씨
		} else if(location.contains("자양1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121582000"; // 서울특별시 광진구 자양1동 날씨
		} else if(location.contains("자양2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121583000"; // 서울특별시 광진구 자양2동 날씨
		} else if(location.contains("자양3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121584000"; // 서울특별시 광진구 자양3동 날씨
		} else if(location.contains("자양4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121584700"; // 서울특별시 광진구 자양4동 날씨
		} else if(location.contains("자양")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121582000"; // 서울특별시 광진구 자양동 날씨
		} else if(location.contains("중곡1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121574000"; // 서울특별시 광진구 중곡1동 날씨
		} else if(location.contains("중곡2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121575000"; // 서울특별시 광진구 중곡2동 날씨
		} else if(location.contains("중곡3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121576000"; // 서울특별시 광진구 중곡3동 날씨
		} else if(location.contains("중곡4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121577000"; // 서울특별시 광진구 중곡4동 날씨
		} else if(location.contains("중곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121574000"; // 서울특별시 광진구 중곡1동 날씨
		} else if(location.contains("화양")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1121571000"; // 서울특별시 광진구 화양동 날씨
		// ========================= //

		// ========== 구로구 ========== //	
		} else if(location.contains("구로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153059500"; // 서울특별시 구로구 가리봉동 날씨
		} else if(location.contains("가리봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153059500"; // 서울특별시 구로구 가리봉동 날씨
		} else if(location.contains("개봉1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153074000"; // 서울특별시 구로구 개봉1동 날씨
		} else if(location.contains("개봉2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153075000"; // 서울특별시 구로구 개봉2동 날씨
		} else if(location.contains("개봉3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153076000"; // 서울특별시 구로구 개봉3동 날씨
		} else if(location.contains("개봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153074000"; // 서울특별시 구로구 개봉1동 날씨
		} else if(location.contains("고척1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153072000"; // 서울특별시 구로구 고척1동 날씨
		} else if(location.contains("고척2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153073000"; // 서울특별시 구로구 고척2동 날씨
		} else if(location.contains("고척")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153072000"; // 서울특별시 구로구 고척1동 날씨
		} else if(location.contains("구로1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153052000"; // 서울특별시 구로구 구로1동 날씨
		} else if(location.contains("구로2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153053000"; // 서울특별시 구로구 구로2동 날씨
		} else if(location.contains("구로3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153054000"; // 서울특별시 구로구 구로3동 날씨
		} else if(location.contains("구로4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153055000"; // 서울특별시 구로구 구로4동 날씨
		} else if(location.contains("구로5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153056000"; // 서울특별시 구로구 구로5동 날씨
		} else if(location.contains("구로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153052000"; // 서울특별시 구로구 구로1동 날씨
		} else if(location.contains("수궁")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153079000"; // 서울특별시 구로구 수궁동 날씨
		} else if(location.contains("신도림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153051000"; // 서울특별시 구로구 신도림동 날씨
		} else if(location.contains("오류1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153077000"; // 서울특별시 구로구 오류1동 날씨
		} else if(location.contains("오류2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153078000"; // 서울특별시 구로구 오류2동 날씨
		} else if(location.contains("오류")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1153077000"; // 서울특별시 구로구 오류1동 날씨
		// ========================= //

		// ========== 금천구 ========== //	
		} else if(location.contains("금천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154551000"; // 서울특별시 금천구 가산동 날씨
		} else if(location.contains("가산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154551000"; // 서울특별시 금천구 가산동 날씨
		} else if(location.contains("독산1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154561000"; // 서울특별시 금천구 독산1동 날씨
		} else if(location.contains("독산2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154562000"; // 서울특별시 금천구 독산2동 날씨
		} else if(location.contains("독산3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154563000"; // 서울특별시 금천구 독산3동 날씨
		} else if(location.contains("독산4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154564000"; // 서울특별시 금천구 독산4동 날씨
		} else if(location.contains("독산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154561000"; // 서울특별시 금천구 독산1동 날씨
		} else if(location.contains("시흥1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154567000"; // 서울특별시 금천구 시흥1동 날씨
		} else if(location.contains("시흥2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154568000"; // 서울특별시 금천구 시흥2동 날씨
		} else if(location.contains("시흥3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154569000"; // 서울특별시 금천구 시흥3동 날씨
		} else if(location.contains("시흥4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154570000"; // 서울특별시 금천구 시흥4동 날씨
		} else if(location.contains("시흥5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154571000"; // 서울특별시 금천구 시흥5동 날씨
		} else if(location.contains("시흥")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1154567000"; // 서울특별시 금천구 시흥1동 날씨
		// ========================= //
			
		// ========== 노원구 ========== //
		} else if(location.contains("노원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135059500"; // 서울특별시 노원구 공릉1동 날씨
		} else if(location.contains("공릉1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135059500"; // 서울특별시 노원구 공릉1동 날씨
		} else if(location.contains("공릉2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135060000"; // 서울특별시 노원구 공릉2동 날씨
		} else if(location.contains("공릉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135059500"; // 서울특별시 노원구 공릉1동 날씨
		} else if(location.contains("상계10")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135072000"; // 서울특별시 노원구 상계10동 날씨
		} else if(location.contains("상계1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135063000"; // 서울특별시 노원구 상계1동 날씨
		} else if(location.contains("상계2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135064000"; // 서울특별시 노원구 상계2동 날씨
		} else if(location.contains("상계3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135066500"; // 서울특별시 노원구 상계3동 날씨
		} else if(location.contains("상계4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135066500"; // 서울특별시 노원구 상계4동 날씨
		} else if(location.contains("상계5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135067000"; // 서울특별시 노원구 상계5동 날씨
		} else if(location.contains("상계6")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135069500"; // 서울특별시 노원구 상계6동 날씨
		} else if(location.contains("상계7")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135069500"; // 서울특별시 노원구 상계7동 날씨
		} else if(location.contains("상계8")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135070000"; // 서울특별시 노원구 상계8동 날씨
		} else if(location.contains("상계9")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135071000"; // 서울특별시 노원구 상계9동 날씨
		} else if(location.contains("상계")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135063000"; // 서울특별시 노원구 상계1동 날씨
		} else if(location.contains("월계1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135056000"; // 서울특별시 노원구 월계1동 날씨
		} else if(location.contains("월계2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135057000"; // 서울특별시 노원구 월계2동 날씨
		} else if(location.contains("월계3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135058000"; // 서울특별시 노원구 월계3동 날씨
		} else if(location.contains("월계")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135056000"; // 서울특별시 노원구 월계1동 날씨
		} else if(location.contains("중계1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135062100"; // 서울특별시 노원구 중계1동 날씨
		} else if(location.contains("중계2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135062500"; // 서울특별시 노원구 중계2동 날씨
		} else if(location.contains("중계3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135062500"; // 서울특별시 노원구 중계3동 날씨
		} else if(location.contains("중계")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135062100"; // 서울특별시 노원구 중계1동 날씨
		} else if(location.contains("중계본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135061900"; // 서울특별시 노원구 중계본동 날씨
		} else if(location.contains("하계1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135061100"; // 서울특별시 노원구 하계1동 날씨
		} else if(location.contains("하계2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135061200"; // 서울특별시 노원구 하계2동 날씨
		} else if(location.contains("하계")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1135061100"; // 서울특별시 노원구 하계1동 날씨
		// ========================= //
			

		// ========== 도봉구 ========== //	
		} else if(location.contains("도봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132052100"; // 서울특별시 도봉구 도봉1동 날씨
		} else if(location.contains("도봉1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132052100"; // 서울특별시 도봉구 도봉1동 날씨
		} else if(location.contains("도봉2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132052200"; // 서울특별시 도봉구 도봉2동 날씨
		} else if(location.contains("도봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132052100"; // 서울특별시 도봉구 도봉1동 날씨
		} else if(location.contains("방학1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132069000"; // 서울특별시 도봉구 방학1동 날씨
		} else if(location.contains("방학2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132070000"; // 서울특별시 도봉구 방학2동 날씨
		} else if(location.contains("방학3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132071000"; // 서울특별시 도봉구 방학3동 날씨
		} else if(location.contains("방학")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132069000"; // 서울특별시 도봉구 방학1동 날씨
		} else if(location.contains("쌍문1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132066000"; // 서울특별시 도봉구 쌍문1동 날씨
		} else if(location.contains("쌍문2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132067000"; // 서울특별시 도봉구 쌍문2동 날씨
		} else if(location.contains("쌍문3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132068000"; // 서울특별시 도봉구 쌍문3동 날씨
		} else if(location.contains("쌍문4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132068100"; // 서울특별시 도봉구 쌍문4동 날씨
		} else if(location.contains("쌍문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132066000"; // 서울특별시 도봉구 쌍문1동 날씨
		} else if(location.contains("창제1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051100"; // 서울특별시 도봉구 창제1동 날씨
		} else if(location.contains("창제2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051200"; // 서울특별시 도봉구 창제2동 날씨
		} else if(location.contains("창제3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051200"; // 서울특별시 도봉구 창제3동 날씨
		} else if(location.contains("창제4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051400"; // 서울특별시 도봉구 창제4동 날씨
		} else if(location.contains("창제5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051500"; // 서울특별시 도봉구 창제5동 날씨
		} else if(location.contains("창제")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1132051100"; // 서울특별시 도봉구 창제1동 날씨
		// ========================= //

		// ========== 동대문구 ========== //
		} else if(location.contains("동대문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123060000"; // 서울특별시 동대문구 답십리1동 날씨
		} else if(location.contains("답십리1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123060000"; // 서울특별시 동대문구 답십리1동 날씨
		} else if(location.contains("답십리2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123061000"; // 서울특별시 동대문구 답십리2동 날씨
		} else if(location.contains("답십리")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123060000"; // 서울특별시 동대문구 답십리1동 날씨
		} else if(location.contains("용신")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123053600"; // 서울특별시 동대문구 용신동 날씨
		} else if(location.contains("이문1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123074000"; // 서울특별시 동대문구 이문1동 날씨
		} else if(location.contains("이문2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123075000"; // 서울특별시 동대문구 이문2동 날씨
		} else if(location.contains("이문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123074000"; // 서울특별시 동대문구 이문1동 날씨
		} else if(location.contains("장안1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123065000"; // 서울특별시 동대문구 장안1동 날씨
		} else if(location.contains("장안2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123066000"; // 서울특별시 동대문구 장안2동 날씨
		} else if(location.contains("장안")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123065000"; // 서울특별시 동대문구 장안1동 날씨
		} else if(location.contains("전농1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123056000"; // 서울특별시 동대문구 천농1동 날씨
		} else if(location.contains("전농2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123057000"; // 서울특별시 동대문구 천농2동 날씨
		} else if(location.contains("전농")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123056000"; // 서울특별시 동대문구 천농1동 날씨
		} else if(location.contains("제기")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123054500"; // 서울특별시 동대문구 제기동 날씨
		} else if(location.contains("청량리")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123070500"; // 서울특별시 동대문구 청량리동 날씨
		} else if(location.contains("회기")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123071000"; // 서울특별시 동대문구 회기동 날씨
		} else if(location.contains("휘경1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123072000"; // 서울특별시 동대문구 휘경1동 날씨
		} else if(location.contains("휘경2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123073000"; // 서울특별시 동대문구 휘경2동 날씨
		} else if(location.contains("휘경")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1123072000"; // 서울특별시 동대문구 휘경1동 날씨
		// ========================= //
			
		// ========== 동작구 ========== //
		} else if(location.contains("동작")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159051000"; // 서울특별시 동작구 노량진1동 날씨
		} else if(location.contains("노량진1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159051000"; // 서울특별시 동작구 노량진1동 날씨
		} else if(location.contains("노량진2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159052000"; // 서울특별시 동작구 노량진2동 날씨
		} else if(location.contains("노량진")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159051000"; // 서울특별시 동작구 노량진1동 날씨
		} else if(location.contains("대방")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159066000"; // 서울특별시 동작구 대방동 날씨
		} else if(location.contains("사당1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159062000"; // 서울특별시 동작구 사당1동 날씨
		} else if(location.contains("사당2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159063000"; // 서울특별시 동작구 사당2동 날씨
		} else if(location.contains("사당3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159064000"; // 서울특별시 동작구 사당3동 날씨
		} else if(location.contains("사당4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159065000"; // 서울특별시 동작구 사당4동 날씨
		} else if(location.contains("사당5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159065100"; // 서울특별시 동작구 사당5동 날씨
		} else if(location.contains("사당")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159062000"; // 서울특별시 동작구 사당1동 날씨
		} else if(location.contains("상도1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159053000"; // 서울특별시 동작구 상도1동 날씨
		} else if(location.contains("상도2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159054000"; // 서울특별시 동작구 상도2동 날씨
		} else if(location.contains("상도3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159055000"; // 서울특별시 동작구 상도3동 날씨
		} else if(location.contains("상도4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159056000"; // 서울특별시 동작구 상도4동 날씨
		} else if(location.contains("상도")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159053000"; // 서울특별시 동작구 상도1동 날씨
		} else if(location.contains("신대방1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159067000"; // 서울특별시 동작구 신대방1동 날씨
		} else if(location.contains("신대방2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159068000"; // 서울특별시 동작구 신대방2동 날씨
		} else if(location.contains("신대방")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159067000"; // 서울특별시 동작구 신대방1동 날씨
		} else if(location.contains("흑석")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1159060500"; // 서울특별시 동작구 흑석동 날씨
		// ========================= //
			
		// ========== 마포구 ========== //
		} else if(location.contains("마포")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144056500"; // 서울특별시 마포구 공덕동 날씨
		} else if(location.contains("공덕")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144056500"; // 서울특별시 마포구 공덕동 날씨
		} else if(location.contains("대흥")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144060000"; // 서울특별시 마포구 대흥동 날씨
		} else if(location.contains("도화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144058500"; // 서울특별시 마포구 도화동 날씨
		} else if(location.contains("망원1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144069000"; // 서울특별시 마포구 망원1동 날씨
		} else if(location.contains("망원2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144070000"; // 서울특별시 마포구 망원2동 날씨
		} else if(location.contains("망원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144069000"; // 서울특별시 마포구 망원1동 날씨
		} else if(location.contains("상암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144074000"; // 서울특별시 마포구 상암동 날씨
		} else if(location.contains("서강")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144065500"; // 서울특별시 마포구 서강동 날씨
		} else if(location.contains("서교")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144066000"; // 서울특별시 마포구 서교동 날씨
		} else if(location.contains("성산1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144072000"; // 서울특별시 마포구 성산1동 날씨
		} else if(location.contains("성산2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144073000"; // 서울특별시 마포구 성산2동 날씨
		} else if(location.contains("성산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144072000"; // 서울특별시 마포구 성산동 날씨
		} else if(location.contains("신수")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144063000"; // 서울특별시 마포구 신수동 날씨
		} else if(location.contains("아현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144055500"; // 서울특별시 마포구 아현동 날씨
		} else if(location.contains("연남")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144071000"; // 서울특별시 마포구 연남동 날씨
		} else if(location.contains("염리")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144061000"; // 서울특별시 마포구 염리동 날씨
		} else if(location.contains("용강")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144059000"; // 서울특별시 마포구 용강동 날씨
		} else if(location.contains("합정")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1144068000"; // 서울특별시 마포구 합정동 날씨
		// ========================= //
			
		// ========== 서대문구 ========== //
		} else if(location.contains("서대문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141069000"; // 서울특별시 서대문구 남가좌1동 날씨
		} else if(location.contains("남가좌1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141069000"; // 서울특별시 서대문구 남가좌1동 날씨
		} else if(location.contains("남가좌2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141070000"; // 서울특별시 서대문구 남가좌2동 날씨
		} else if(location.contains("남가좌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141069000"; // 서울특별시 서대문구 남가좌1동 날씨
		} else if(location.contains("북가좌1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141071000"; // 서울특별시 서대문구 북가좌1동 날씨
		} else if(location.contains("북가좌2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141072000"; // 서울특별시 서대문구 북가좌2동 날씨
		} else if(location.contains("북가좌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141071000"; // 서울특별시 서대문구 북가좌1동 날씨
		} else if(location.contains("북아현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141055500"; // 서울특별시 서대문구 북아현동 날씨
		} else if(location.contains("신촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141058500"; // 서울특별시 서대문구 신촌동 날씨
		} else if(location.contains("연희")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141061500"; // 서울특별시 서대문구 연희동 날씨
		} else if(location.contains("천연")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141052000"; // 서울특별시 서대문구 천연동 날씨
		} else if(location.contains("충현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141056500"; // 서울특별시 서대문구 충현동 날씨
		} else if(location.contains("홍은1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141066000"; // 서울특별시 서대문구 홍은1동 날씨
		} else if(location.contains("홍은2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141068500"; // 서울특별시 서대문구 홍은2동 날씨
		} else if(location.contains("홍은")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141066000"; // 서울특별시 서대문구 홍은1동 날씨
		} else if(location.contains("홍제1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141062000"; // 서울특별시 서대문구 홍제1동 날씨
		} else if(location.contains("홍제2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141065500"; // 서울특별시 서대문구 홍제2동 날씨
		} else if(location.contains("홍제3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141064000"; // 서울특별시 서대문구 홍제3동 날씨
		} else if(location.contains("홍제")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1141062000"; // 서울특별시 서대문구 홍제4동 날씨
		// ========================= //
			
		// ========== 서초구 ========== //
		} else if(location.contains("서초")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165066000"; // 서울특별시 서초구 내곡동 날씨
		} else if(location.contains("내곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165066000"; // 서울특별시 서초구 내곡동 날씨
		} else if(location.contains("반포1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165056000"; // 서울특별시 서초구 반포1동 날씨
		} else if(location.contains("반포2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165057000"; // 서울특별시 서초구 반포2동 날씨
		} else if(location.contains("반포3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165058000"; // 서울특별시 서초구 반포3동 날씨
		} else if(location.contains("반포4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165058100"; // 서울특별시 서초구 반포4동 날씨
		} else if(location.contains("반포")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165056000"; // 서울특별시 서초구 반포1동 날씨
		} else if(location.contains("반포본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165055000"; // 서울특별시 서초구 반포본동 날씨
		} else if(location.contains("방배1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165060000"; // 서울특별시 서초구 방배1동 날씨
		} else if(location.contains("방배2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165061000"; // 서울특별시 서초구 방배2동 날씨
		} else if(location.contains("방배3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165062000"; // 서울특별시 서초구 방배3동 날씨
		} else if(location.contains("방배")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165060000"; // 서울특별시 서초구 방배1동 날씨
		} else if(location.contains("방배본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165059000"; // 서울특별시 서초구 방배본동 날씨
		} else if(location.contains("서초1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165051000"; // 서울특별시 서초구 서초1동 날씨
		} else if(location.contains("서초2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165052000"; // 서울특별시 서초구 서초2동 날씨
		} else if(location.contains("서초3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165053000"; // 서울특별시 서초구 서초3동 날씨
		} else if(location.contains("서초4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165053100"; // 서울특별시 서초구 서초4동 날씨
		} else if(location.contains("서초")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165051000"; // 서울특별시 서초구 서초1동 날씨
		} else if(location.contains("양재1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165065100"; // 서울특별시 서초구 양재1동 날씨
		} else if(location.contains("양재2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165065200"; // 서울특별시 서초구 양재2동 날씨
		} else if(location.contains("양재")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165065100"; // 서울특별시 서초구 양재1동 날씨
		} else if(location.contains("잠원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1165054000"; // 서울특별시 서초구 잠원동 날씨
		// ========================= //
			
		// ========== 성동구 ========== //
		} else if(location.contains("성동")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120059000"; // 서울특별시 성동구 금호1동 날씨
		} else if(location.contains("금호1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120059000"; // 서울특별시 성동구 금호1동 날씨
		} else if(location.contains("금호2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120061500"; // 서울특별시 성동구 금호2동 날씨
		} else if(location.contains("금호3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120061500"; // 서울특별시 성동구 금호3동 날씨
		} else if(location.contains("금호4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120062000"; // 서울특별시 성동구 금호4동 날씨
		} else if(location.contains("금호")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120059000"; // 서울특별시 성동구 금호1동 날씨
		} else if(location.contains("마장")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120054000"; // 서울특별시 성동구 마장동 날씨
		} else if(location.contains("사근")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120055000"; // 서울특별시 성동구 사근동 날씨
		} else if(location.contains("성수1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120055000"; // 서울특별시 성동구 성수1동 날씨
		} else if(location.contains("성수2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120067000"; // 서울특별시 성동구 성수2동 날씨
		} else if(location.contains("성수")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120055000"; // 서울특별시 성동구 성수11동 날씨
		} else if(location.contains("송정")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120072000"; // 서울특별시 성동구 송정1동 날씨
		} else if(location.contains("옥수")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120064500"; // 서울특별시 성동구 옥수동 날씨
		} else if(location.contains("왕십리도선")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120053500"; // 서울특별시 성동구 왕십리도선동 날씨
		} else if(location.contains("왕십리2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120052000"; // 서울특별시 성동구 왕십리2동 날씨
		} else if(location.contains("왕십리")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120052000"; // 서울특별시 성동구 왕십리2동 날씨
		} else if(location.contains("용답")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120079000"; // 서울특별시 성동구 용답동 날씨
		} else if(location.contains("용봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120058000"; // 서울특별시 성동구 응봉동 날씨
		} else if(location.contains("행당1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120056000"; // 서울특별시 성동구 행당1동 날씨
		} else if(location.contains("행당2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120057000"; // 서울특별시 성동구 행당2동 날씨
		} else if(location.contains("행당")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120056000"; // 서울특별시 성동구 행당1동 날씨
		// ========================= //
			
		// ========== 성북구 ========== //
		} else if(location.contains("성북")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120057000"; // 서울특별시 성북구 길음1동 날씨
		} else if(location.contains("길음1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120057000"; // 서울특별시 성북구 길음1동 날씨
		} else if(location.contains("길음2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129068500"; // 서울특별시 성북구 길음2동 날씨
		} else if(location.contains("길음")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1120057000"; // 서울특별시 성북구 길음1동 날씨
		} else if(location.contains("돈암1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129058000"; // 서울특별시 성북구 돈암1동 날씨
		} else if(location.contains("돈암2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129059000"; // 서울특별시 성북구 돈암2동 날씨
		} else if(location.contains("돈암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129058000"; // 서울특별시 성북구 돈암1동 날씨
		} else if(location.contains("동선")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129057500"; // 서울특별시 성북구 동선동 날씨
		} else if(location.contains("보문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129061000"; // 서울특별시 성북구 보문동 날씨
		} else if(location.contains("삼선")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129055500"; // 서울특별시 성북구 삼선동 날씨
		} else if(location.contains("석관")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129081000"; // 서울특별시 성북구 석관동 날씨
		} else if(location.contains("성북")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129052500"; // 서울특별시 성북구 성북동 날씨
		} else if(location.contains("안암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129060000"; // 서울특별시 성북구 안암동 날씨
		} else if(location.contains("월곡1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129071500"; // 서울특별시 성북구 월곡1동 날씨
		} else if(location.contains("월곡2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129072500"; // 서울특별시 성북구 월곡2동 날씨
		} else if(location.contains("월곡")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129071500"; // 서울특별시 성북구 월곡1동 날씨
		} else if(location.contains("장위1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129076000"; // 서울특별시 성북구 장위1동 날씨
		} else if(location.contains("장위2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129076000"; // 서울특별시 성북구 장위2동 날씨
		} else if(location.contains("장위3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129077000"; // 서울특별시 성북구 장위3동 날씨
		} else if(location.contains("장위")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129076000"; // 서울특별시 성북구 장위1동 날씨
		} else if(location.contains("정릉1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129062000"; // 서울특별시 성북구 정릉1동 날씨
		} else if(location.contains("정릉2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129063000"; // 서울특별시 성북구 정릉2동 날씨
		} else if(location.contains("정릉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1129062000"; // 서울특별시 성북구 정릉1동 날씨
		// ========================= //
			
		// ========== 송파구 ========== //
		} else if(location.contains("송파")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171063100"; // 서울특별시 송파구 가락1동 날씨
		} else if(location.contains("가락1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171063100"; // 서울특별시 송파구 가락1동 날씨
		} else if(location.contains("가락2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171063200"; // 서울특별시 송파구 가락2동 날씨
		} else if(location.contains("가락")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171063100"; // 서울특별시 송파구 가락1동 날씨
		} else if(location.contains("가락본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171062000"; // 서울특별시 송파구 가락본동 날씨
		} else if(location.contains("거여1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171053100"; // 서울특별시 송파구 거여1동 날씨
		} else if(location.contains("거여2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171053200"; // 서울특별시 송파구 거여2동 날씨
		} else if(location.contains("거여")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171053100"; // 서울특별시 송파구 거여1동 날씨
		} else if(location.contains("마천1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171054000"; // 서울특별시 송파구 마천1동 날씨
		} else if(location.contains("마천2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171055000"; // 서울특별시 송파구 마천2동 날씨
		} else if(location.contains("마천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171054000"; // 서울특별시 송파구 마천1동 날씨
		} else if(location.contains("문정")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171064100"; // 서울특별시 송파구 문정동 날씨
		} else if(location.contains("방이")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171056100"; // 서울특별시 송파구 방이동 날씨
		} else if(location.contains("삼천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171061000"; // 서울특별시 송파구 삼천동 날씨
		} else if(location.contains("석촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171060000"; // 서울특별시 송파구 석촌동 날씨
		} else if(location.contains("송파")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171058000"; // 서울특별시 송파구 송파동 날씨
		} else if(location.contains("오금")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171057000"; // 서울특별시 송파구 오금동 날씨
		} else if(location.contains("오륜")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171056600"; // 서울특별시 송파구 오륜동 날씨
		} else if(location.contains("위례")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171064700"; // 서울특별시 송파구 위례동 날씨
		} else if(location.contains("잠실2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171067000"; // 서울특별시 송파구 잠실2동 날씨
		} else if(location.contains("잠실3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171067000"; // 서울특별시 송파구 잠실3동 날씨
		} else if(location.contains("잠실")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171067000"; // 서울특별시 송파구 잠실2동 날씨
		} else if(location.contains("잠실본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171065000"; // 서울특별시 송파구 잠실본동 날씨
		} else if(location.contains("장지")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171064600"; // 서울특별시 송파구 장지동 날씨
		} else if(location.contains("풍납")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1171051000"; // 서울특별시 송파구 풍납동 날씨
		// ========================= //
			
		// ========== 양천구 ========== //
		} else if(location.contains("양천")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147051000"; // 서울특별시 양천구 목1동 날씨
		} else if(location.contains("목1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147051000"; // 서울특별시 양천구 목1동 날씨
		} else if(location.contains("목2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147052000"; // 서울특별시 양천구 목2동 날씨
		} else if(location.contains("목3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147053000"; // 서울특별시 양천구 목3동 날씨
		} else if(location.contains("목4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147054000"; // 서울특별시 양천구 목4동 날씨
		} else if(location.contains("목5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147055000"; // 서울특별시 양천구 목5동 날씨
		} else if(location.contains("목")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147051000"; // 서울특별시 양천구 목1동 날씨
		} else if(location.contains("신월1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147056000"; // 서울특별시 양천구 신월1동 날씨
		} else if(location.contains("신월2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147057000"; // 서울특별시 양천구 신월2동 날씨
		} else if(location.contains("신월3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147058000"; // 서울특별시 양천구 신월3동 날씨
		} else if(location.contains("신월4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147059000"; // 서울특별시 양천구 신월4동 날씨
		} else if(location.contains("신월5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147060000"; // 서울특별시 양천구 신월5동 날씨
		} else if(location.contains("신월6")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147061000"; // 서울특별시 양천구 신월6동 날씨
		} else if(location.contains("신월7")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147061100"; // 서울특별시 양천구 신월7동 날씨
		} else if(location.contains("신월")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147056000"; // 서울특별시 양천구 신월1동 날씨
		} else if(location.contains("신정1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147062000"; // 서울특별시 양천구 신정1동 날씨
		} else if(location.contains("신정2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147063000"; // 서울특별시 양천구 신정2동 날씨
		} else if(location.contains("신정3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147064000"; // 서울특별시 양천구 신정3동 날씨
		} else if(location.contains("신정4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147065000"; // 서울특별시 양천구 신정4동 날씨
		} else if(location.contains("신정6")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147067000"; // 서울특별시 양천구 신정6동 날씨
		} else if(location.contains("신정7")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147068000"; // 서울특별시 양천구 신정7동 날씨
		} else if(location.contains("신정")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1147062000"; // 서울특별시 양천구 신정1동 날씨
		// ========================= //
			
		// ========== 영등포구 ========== //
		} else if(location.contains("영등포")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156055000"; // 서울특별시 영등포구 당산1동 날씨
		} else if(location.contains("당산1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156055000"; // 서울특별시 영등포구 당산1동 날씨
		} else if(location.contains("당산2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156056000"; // 서울특별시 영등포구 당산2동 날씨
		} else if(location.contains("당산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156055000"; // 서울특별시 영등포구 당산1동 날씨
		} else if(location.contains("대림1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156070000"; // 서울특별시 영등포구 대림1동 날씨
		} else if(location.contains("대림2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156072000"; // 서울특별시 영등포구 대림2동 날씨
		} else if(location.contains("대림3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156070000"; // 서울특별시 영등포구 대림3동 날씨
		} else if(location.contains("대림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156071000"; // 서울특별시 영등포구 대림1동 날씨
		} else if(location.contains("도림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156058500"; // 서울특별시 영등포구 도림동 날씨
		} else if(location.contains("문래")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156060500"; // 서울특별시 영등포구 문래동 날씨
		} else if(location.contains("신길1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156063000"; // 서울특별시 영등포구 신길1동 날씨
		} else if(location.contains("신길3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156065000"; // 서울특별시 영등포구 신길3동 날씨
		} else if(location.contains("신길4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156066000"; // 서울특별시 영등포구 신길4동 날씨
		} else if(location.contains("신길5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156067000"; // 서울특별시 영등포구 신길5동 날씨
		} else if(location.contains("신길6")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156068000"; // 서울특별시 영등포구 신길6동 날씨
		} else if(location.contains("신길7")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156069000"; // 서울특별시 영등포구 신길7동 날씨
		} else if(location.contains("신길")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156063000"; // 서울특별시 영등포구 신길1동 날씨
		} else if(location.contains("양평1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156061000"; // 서울특별시 영등포구 양평1동 날씨
		} else if(location.contains("양평2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156062000"; // 서울특별시 영등포구 양평2동 날씨
		} else if(location.contains("양평")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156061000"; // 서울특별시 영등포구 양평1동 날씨
		} else if(location.contains("여의")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156054000"; // 서울특별시 영등포구 여의동 날씨
		} else if(location.contains("영등포본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1156051500"; // 서울특별시 영등포구 영등포본동 날씨
		// ========================= //
			
		// ========== 용산구 ========== //
		} else if(location.contains("용산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117053000"; // 서울특별시 용산구 남영동 날씨
		} else if(location.contains("남영")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117053000"; // 서울특별시 용산구 남영동 날씨
		} else if(location.contains("보광")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117070000"; // 서울특별시 용산구 보광동 날씨
		} else if(location.contains("서빙고")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117069000"; // 서울특별시 용산구 서빙고동 날씨
		} else if(location.contains("용문")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117059000"; // 서울특별시 용산구 용문동 날씨
		} else if(location.contains("용산2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117052000"; // 서울특별시 용산구 용산2동 날씨
		} else if(location.contains("원효로1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117056000"; // 서울특별시 용산구 원효로1동 날씨
		} else if(location.contains("원효로2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117057000"; // 서울특별시 용산구 원효로1동 날씨
		} else if(location.contains("원효로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117056000"; // 서울특별시 용산구 원효로1동 날씨
		} else if(location.contains("이촌1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117063000"; // 서울특별시 용산구 이촌1동 날씨
		} else if(location.contains("이촌2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117064000"; // 서울특별시 용산구 이촌2동 날씨
		} else if(location.contains("이촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117063000"; // 서울특별시 용산구 이촌1동 날씨
		} else if(location.contains("이태원1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117065000"; // 서울특별시 용산구 이태원1동 날씨
		} else if(location.contains("이태원2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117066000"; // 서울특별시 용산구 이태원2동 날씨
		} else if(location.contains("이태원")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117065000"; // 서울특별시 용산구 이태원1동 날씨
		} else if(location.contains("청파")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117055500"; // 서울특별시 용산구 청파동 날씨
		} else if(location.contains("한강로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117062500"; // 서울특별시 용산구 한강로동 날씨
		} else if(location.contains("한남")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117068500"; // 서울특별시 용산구 한남동 날씨
		} else if(location.contains("효창")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117058000"; // 서울특별시 용산구 효창동 날씨
		} else if(location.contains("후암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1117051000"; // 서울특별시 용산구 후암동 날씨
		// ========================= //
			
		// ========== 은평구 ========== //	
		} else if(location.contains("은평")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138055100"; // 서울특별시 은평구 갈현1동 날씨
		} else if(location.contains("갈현1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138055100"; // 서울특별시 은평구 갈현1동 날씨
		} else if(location.contains("갈현2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138055200"; // 서울특별시 은평구 갈현2동 날씨
		} else if(location.contains("갈현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138055100"; // 서울특별시 은평구 갈현1동 날씨
		} else if(location.contains("구산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138056000"; // 서울특별시 은평구 구산동 날씨
		} else if(location.contains("녹번")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138051000"; // 서울특별시 은평구 녹번동 날씨
		} else if(location.contains("대조")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138057000"; // 서울특별시 은평구 대조동 날씨
		} else if(location.contains("불광1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138052000"; // 서울특별시 은평구 불광1동 날씨
		} else if(location.contains("불광2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138053000"; // 서울특별시 은평구 불광2동 날씨
		} else if(location.contains("불광")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138052000"; // 서울특별시 은평구 불광1동 날씨
		} else if(location.contains("수색")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138065000"; // 서울특별시 은평구 수색동 날씨
		} else if(location.contains("신사1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138063100"; // 서울특별시 은평구 신사1동 날씨
		} else if(location.contains("신사2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138063200"; // 서울특별시 은평구 신사2동 날씨
		} else if(location.contains("신사")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138063100"; // 서울특별시 은평구 신사1동 날씨
		} else if(location.contains("역촌")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138062500"; // 서울특별시 은평구 역촌1동 날씨
		} else if(location.contains("응암1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138058000"; // 서울특별시 은평구 응암1동 날씨
		} else if(location.contains("응암2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138059000"; // 서울특별시 은평구 응암2동 날씨
		} else if(location.contains("응암3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138060000"; // 서울특별시 은평구 응암3동 날씨
		} else if(location.contains("응암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138058000"; // 서울특별시 은평구 응암1동 날씨
		} else if(location.contains("증산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138064000"; // 서울특별시 은평구 증산동 날씨
		} else if(location.contains("진관")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1138069000"; // 서울특별시 은평구 진관동 날씨
		// ========================= //
			
		// ========== 종로구 ========== //
		} else if(location.contains("종로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111060000"; // 서울특별시 종로구 가회동 날씨
		} else if(location.contains("가회")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111060000"; // 서울특별시 종로구 가회동 날씨
		} else if(location.contains("교남")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111058000"; // 서울특별시 종로구 교남동 날씨
		} else if(location.contains("무악")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111057000"; // 서울특별시 종로구 무악동 날씨
		} else if(location.contains("부암")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111055000"; // 서울특별시 종로구 부암동 날씨
		} else if(location.contains("사직")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111053000"; // 서울특별시 종로구 사직동 날씨
		} else if(location.contains("삼청")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111054000"; // 서울특별시 종로구 삼청동 날씨
		} else if(location.contains("숭인1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111070000"; // 서울특별시 종로구 숭인1동 날씨
		} else if(location.contains("숭인2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111071000"; // 서울특별시 종로구 숭인2동 날씨
		} else if(location.contains("숭인")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111070000"; // 서울특별시 종로구 숭인1동 날씨
		} else if(location.contains("이화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111064000"; // 서울특별시 종로구 이화동 날씨
		} else if(location.contains("창신")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111067000"; // 서울특별시 종로구 창신동 날씨
		} else if(location.contains("청운")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111051500"; // 서울특별시 종로구 청운동 날씨
		} else if(location.contains("효자")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111051500"; // 서울특별시 종로구 효자동 날씨
		} else if(location.contains("평창")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111056000"; // 서울특별시 종로구 평창동 날씨
		} else if(location.contains("혜화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1111065000"; // 서울특별시 종로구 혜화동 날씨
		// ========================= //
			
		// ========== 중구 ========== //
		} else if(location.contains("중")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114059000"; // 서울특별시 중구 광희동 날씨
		} else if(location.contains("광희")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114059000"; // 서울특별시 중구 광희동 날씨
		} else if(location.contains("다산")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114062500"; // 서울특별시 중구 다산동 날씨
		} else if(location.contains("동화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114066500"; // 서울특별시 중구 동화동 날씨
		} else if(location.contains("명")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114055000"; // 서울특별시 중구 명동 날씨
		} else if(location.contains("소공")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114052000"; // 서울특별시 중구 소공동 날씨
		} else if(location.contains("신당")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114061500"; // 서울특별시 중구 신당동 날씨
		} else if(location.contains("신당5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114065000"; // 서울특별시 중구 신당5동 날씨
		} else if(location.contains("약수")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114063500"; // 서울특별시 중구 약수동 날씨
		} else if(location.contains("을지로")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114060500"; // 서울특별시 중구 을지로동 날씨
		} else if(location.contains("장충")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114058000"; // 서울특별시 중구 장충동 날씨
		} else if(location.contains("중림")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114068000"; // 서울특별시 중구 중림동 날씨
		} else if(location.contains("청구")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114064500"; // 서울특별시 중구 청구동 날씨
		} else if(location.contains("필")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114057000"; // 서울특별시 중구 필동 날씨
		} else if(location.contains("황학")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114067000"; // 서울특별시 중구 황학동 날씨
		} else if(location.contains("회현")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1114054000"; // 서울특별시 중구 회현동 날씨
		// ========================= //
			
		// ========== 중랑구 ========== //
		} else if(location.contains("중랑")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126065500"; // 서울특별시 중랑구 망우본동 날씨
		} else if(location.contains("망우본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126065500"; // 서울특별시 중랑구 망우본동 날씨
		} else if(location.contains("망우3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126066000"; // 서울특별시 중랑구 망우3동 날씨
		} else if(location.contains("망우")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126066000"; // 서울특별시 중랑구 망우3동 날씨
		} else if(location.contains("면목본")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126056500"; // 서울특별시 중랑구 면목본동 날씨
		} else if(location.contains("면목")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126056500"; // 서울특별시 중랑구 면목본동 날씨
		} else if(location.contains("면목2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126052000"; // 서울특별시 중랑구 면목2동 날씨
		} else if(location.contains("면목3")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126057500"; // 서울특별시 중랑구 면목3동 날씨
		} else if(location.contains("면목8")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126057500"; // 서울특별시 중랑구 면목8동 날씨
		} else if(location.contains("면목4")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126054000"; // 서울특별시 중랑구 면목4동 날씨
		} else if(location.contains("면목5")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126055000"; // 서울특별시 중랑구 면목5동 날씨
		} else if(location.contains("면목7")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126057000"; // 서울특별시 중랑구 면목7동 날씨
		} else if(location.contains("묵1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126062000"; // 서울특별시 중랑구 묵1동 날씨
		} else if(location.contains("묵2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126063000"; // 서울특별시 중랑구 묵2동 날씨
		} else if(location.contains("묵")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126062000"; // 서울특별시 중랑구 묵1동 날씨
		} else if(location.contains("상봉1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126058000"; // 서울특별시 중랑구 상봉1동 날씨
		} else if(location.contains("상봉2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126059000"; // 서울특별시 중랑구 상봉2동 날씨
		} else if(location.contains("상봉")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126058000"; // 서울특별시 중랑구 상봉1동 날씨
		} else if(location.contains("신내1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126068000"; // 서울특별시 중랑구 신내1동 날씨
		} else if(location.contains("신내2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126069000"; // 서울특별시 중랑구 신내2동 날씨
		} else if(location.contains("신내")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126068000"; // 서울특별시 중랑구 신내1동 날씨
		} else if(location.contains("중화1")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126060000"; // 서울특별시 중랑구 중화1동 날씨
		} else if(location.contains("중화2")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126061000"; // 서울특별시 중랑구 중화2동 날씨
		} else if(location.contains("중화")) {
			weatherUrl = "http://www.weather.go.kr/wid/queryDFSRSS.jsp?zone=1126060000"; // 서울특별시 중랑구 중화1동 날씨
		// ========================= //
			
		// ========== 일치하는 정보가 없는 경우 ========== //		
		} else {
			weatherInfo += "No Location Error";
			return weatherInfo;
		}
		// ====================================== //

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document xmlDoc = null;
			Element root = null;
			
			dustUrl += "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?";
			dustUrl += "serviceKey=" + KEY + "&";
			dustUrl += "numOfRows=" + "10" + "&";
			dustUrl += "pageNo=" + "1" + "&";
			dustUrl += "startPage=" + "1" + "&";
			dustUrl += "sidoName=" + sidoName + "&";
			dustUrl += "searchCondition=" + "DAILY";
			
			xmlDoc = parser.parse(dustUrl);
			root = xmlDoc.getDocumentElement();
			
			Node xmlNode1items = null;
			Node xmlNode2pm10Value = null;
			Node xmlNode2pm25Value = null;
			
			xmlNode1items = root.getElementsByTagName("items").item(0);
			xmlNode2pm10Value = ((Element) xmlNode1items).getElementsByTagName("pm10Value").item(0); // PM10 미세먼지
			xmlNode2pm25Value = ((Element) xmlNode1items).getElementsByTagName("pm25Value").item(0); // PM2.5 미세먼지
			
			int pm10Value = Integer.parseInt(xmlNode2pm10Value.getTextContent()); // PM10 미세먼지
			int pm25Value = Integer.parseInt(xmlNode2pm25Value.getTextContent()); // PM2.5 미세먼지
			
			xmlDoc = parser.parse(weatherUrl);
			root = xmlDoc.getDocumentElement();

			Node xmlNode1data = null; // 날씨 정보
			Node xmlNode2hour = null; // 시간
			Node xmlNode2day = null; // 날
			Node xmlNode2temp = null; // 온도
			Node xmlNode2wfKor = null; // 기상
			Node xmlNode2pop = null; // 강수 확률
			Node xmlNode2reh = null; // 습도
			
			weatherInfo += "오늘의 " + location + " 날씨 정보를 알려드릴게요♪.\n";
			weatherInfo += "\n";
			
			if(0 <= pm10Value && pm10Value <= 30) {
				weatherInfo += "[미세먼지 : 좋음(" + pm10Value + ")(방긋)]\n";
			} else if(31 <= pm10Value && pm10Value <= 80) {
				weatherInfo += "[미세먼지 : 보통(" + pm10Value + ")(근심)]\n";
			} else if(81 <= pm10Value && pm10Value <= 150) {
				weatherInfo += "[미세먼지 : 나쁨(" + pm10Value + ")(좌절)]\n";
			} else if(151 <= pm10Value) {
				weatherInfo += "[미세먼지 : 매우 나쁨(" + pm10Value + ")(아픔)]\n";
			}
			
			if(0 <= pm25Value && pm25Value <= 15) {
				weatherInfo += "[초미세먼지 : 좋음(" + pm25Value + ")(방긋)]\n";
			} else if(16 <= pm25Value && pm25Value <= 50) {
				weatherInfo += "[초미세먼지 : 보통(" + pm25Value + ")(근심)]\n";
			} else if(51 <= pm25Value && pm25Value <= 100) {
				weatherInfo += "[초미세먼지 : 나쁨(" + pm25Value + ")(좌절)]\n";
			} else if(101 <= pm25Value) {
				weatherInfo += "[초미세먼지 : 매우 나쁨(" + pm25Value + ")(아픔)]\n";
			}
			
			
			weatherInfo += "\n";

			// day값은 0이면 오늘, 1이면 내일로 봐야하지만 예외가 있다.
			// 밤 23시에 첫번째 날씨 정보가 내일의 날씨 정보로 업데이트되기 때문에 실제 시간으로 자정이 지났다고 하더라도 day값은 1이다.
			// 첫벗째 날씨 정보의 day값이 0이면 자정이 지난 후 업데이트된 정보이다.
			// 올바른 날씨 정보를 주려면 day값이 0이면 오늘의 날씨 정보, 1이면 내일의 날씨 정보를 줘야한다.
			// 첫번째 날씨 정보의 day값이 1이면 자정이 지나기 전 23시에 업데이트된 정보이다.
			// 올바른 날씨 정보를 주려면 day값이 1이면 오늘의 날씨 정보, 2이면 내일의 날씨 정보를 줘야한다.
			xmlNode1data = root.getElementsByTagName("data").item(0); // 첫번째 날씨 정보
			xmlNode2day = ((Element) xmlNode1data).getElementsByTagName("day").item(0); // 날

			// day값을 확인하여 자정 이전에 업데이트된 정보인지 이후에 업데이트된 정보인지 확인한다.
			if (xmlNode2day.getTextContent().equals("0")) { // day값이 0이면 자정이 지난 후 업데이트된 정보이다. day값이 0이면 오늘, 1이면 내일이다.
				// ========== 오늘의 날씨 정보 ========== //
				// 첫번째 날씨 정보는 항상 오늘의 날씨 정보이기 때문에 가져온다.
				xmlNode2hour = ((Element) xmlNode1data).getElementsByTagName("hour").item(0); // 현재 ~ 3시간
				xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
				xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
				xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
				xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

				weatherInfo += "<현재 ~ " + xmlNode2hour.getTextContent() + "시>\n";
				weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
				weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
				weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
				weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
				weatherInfo += "\n";

				xmlNode1data = root.getElementsByTagName("data").item(1); // 두번째 날씨 정보
				xmlNode2day = ((Element) xmlNode1data).getElementsByTagName("day").item(0);

				// 20시 이전에 업데이트된 정보인 경우 두번째 날씨 정보는 오늘의 날씨 정보이기 때문에 가져온다.
				// 20시에 업데이트된 정보인 경우 두번째 날씨 정보는 내일의 날씨 정보이기 때문에 가져오지 않는다.
				if (xmlNode2day.getTextContent().equals("0")) { // day값이 0이면 20시 이전에 업데이트된 정보이다.
					// 시간을 표시하기 위해 다시 첫번째 날씨 정보를 가져옴
					xmlNode1data = root.getElementsByTagName("data").item(0); // 첫번째 날씨 정보
					xmlNode2hour = ((Element) xmlNode1data).getElementsByTagName("hour").item(0); // 현재 ~ 3시간

					weatherInfo += "<" + xmlNode2hour.getTextContent() + "시 ~ ";

					xmlNode1data = root.getElementsByTagName("data").item(1); // 두번째 날씨 정보
					xmlNode2hour = ((Element) xmlNode1data).getElementsByTagName("hour").item(0); // 3시간 후 ~ 6시간
					xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
					xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
					xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
					xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

					weatherInfo += xmlNode2hour.getTextContent() + "시>\n";
					weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
					weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
					weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
					weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
					weatherInfo += "\n";
				}
				// =============================== //

				// ========== 내일의 날씨 정보 ========== //
				for (int i = 0; i < 16; i++) { // 첫번째 날씨 정보부터 시작하여 내일의 첫번째 날씨 정보를 찾을때까지 반복
					xmlNode1data = root.getElementsByTagName("data").item(i); // i번째 날씨 정보
					xmlNode2day = ((Element) xmlNode1data).getElementsByTagName("day").item(0);

					if (xmlNode2day.getTextContent().equals("1")) { // i번째 날씨 정보가 내일에 해당하는 정보인 경우
						xmlNode1data = root.getElementsByTagName("data").item(i + 2); // 오전 6시 ~ 9시에 해당하는 날씨 정보
						xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
						xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
						xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
						xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

						weatherInfo += "<내일 오전의 날씨>\n";
						weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
						weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
						weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
						weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
						weatherInfo += "\n";

						xmlNode1data = root.getElementsByTagName("data").item(i + 5); // 오후 3시 ~ 6시에 해당하는 날씨 정보
						xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
						xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
						xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
						xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

						weatherInfo += "<내일 오후의 날씨>\n";
						weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
						weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
						weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
						weatherInfo += "습도: " + xmlNode2reh.getTextContent();
						break; // 내일의 날씨 정보를 가져오게 되면 반복을 중단한다.
					}
				}
				// =============================== //
			} else if ((xmlNode2day.getTextContent().equals("1"))) {  // day값이 1이면 자정이 지나기 전 23시에 업데이트된 정보이다.  day값이 1이면 오늘, 2이면 내일이다.
				// ========== 오늘의 날씨 정보 ========== //
				// 첫번째 날씨 정보는 항상 오늘의 날씨 정보이기 때문에 가져온다.
				xmlNode2hour = ((Element) xmlNode1data).getElementsByTagName("hour").item(0); // 현재 ~ 3시간
				xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
				xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
				xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
				xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

				weatherInfo += "<현재 ~ " + xmlNode2hour.getTextContent() + "시>\n";
				weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
				weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
				weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
				weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
				weatherInfo += "\n";
				weatherInfo += "<" + xmlNode2hour.getTextContent() + "시 ~ ";

				// 두번째 날씨 정보는 항상 오늘의 날씨 정보이기 때문에 가져온다.
				xmlNode1data = root.getElementsByTagName("data").item(1); // 두번째 날씨 정보
				xmlNode2hour = ((Element) xmlNode1data).getElementsByTagName("hour").item(0); // 3시간 후 ~ 6시간
				xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
				xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
				xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
				xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

				weatherInfo += xmlNode2hour.getTextContent() + "시>\n";
				weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
				weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
				weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
				weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
				weatherInfo += "\n";
				// =============================== //

				// ========== 내일의 날씨 정보 ========== //
				for (int i = 0; i < 16; i++) { // 첫번째 날씨 정보부터 시작하여 내일의 첫번째 날씨 정보를 찾을때까지 반복
					xmlNode1data = root.getElementsByTagName("data").item(i); // i번째 날씨 정보
					xmlNode2day = ((Element) xmlNode1data).getElementsByTagName("day").item(0);

					if (xmlNode2day.getTextContent().equals("2")) { // i번째 날씨 정보가 내일에 해당하는 정보인 경우
						xmlNode1data = root.getElementsByTagName("data").item(i + 2); // 오전 6시 ~ 9시에 해당하는 날씨 정보
						xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
						xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
						xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
						xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

						weatherInfo += "<내일 오전의 날씨>\n";
						weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
						weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
						weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
						weatherInfo += "습도: " + xmlNode2reh.getTextContent() + "\n";
						weatherInfo += "\n";

						xmlNode1data = root.getElementsByTagName("data").item(i + 5); // 오후 3시 ~ 6시에 해당하는 날씨 정보
						xmlNode2temp = ((Element) xmlNode1data).getElementsByTagName("temp").item(0); // 온도
						xmlNode2wfKor = ((Element) xmlNode1data).getElementsByTagName("wfKor").item(0); // 날씨
						xmlNode2pop = ((Element) xmlNode1data).getElementsByTagName("pop").item(0); // 강수 확률
						xmlNode2reh = ((Element) xmlNode1data).getElementsByTagName("reh").item(0); // 습도

						weatherInfo += "<내일 오후의 날씨>\n";
						weatherInfo += "온도: " + Math.round(Double.parseDouble(xmlNode2temp.getTextContent())) + "도 | "; // 소수점은 반올림
						weatherInfo += "날씨: " + xmlNode2wfKor.getTextContent() + "\n";
						weatherInfo += "강수 확률: " + xmlNode2pop.getTextContent() + "% | ";
						weatherInfo += "습도: " + xmlNode2reh.getTextContent();
						break; // 내일의 날씨 정보를 가져오게 되면 반복을 중단한다.
					}
				}
				// =============================== //
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		return weatherInfo;
	}
}