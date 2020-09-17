package OneBread;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NaturalLanguageProcessor {
	public NaturalLanguageProcessor() {
		// null
	}

	public ArrayList<String> getWord(String strInput) {
		ArrayList<String> strInputArrList = new ArrayList<String>();
		ArrayList<String> strRefinementArrList = new ArrayList<String>();
		ArrayList<String> strOutputArrList = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(strInput); // StringTokenizer를 이용하여 공백을 기준으로 문자열을 분리함

		while (st.hasMoreTokens()) { // 다음 스트링이 없을때까지 반복
			strInputArrList.add(st.nextToken()); // strInputArrayList에 스트링을 저장한다.
		}

		// 사용자가 입력한 문자열에서 키워드를 확인한다.
		// 중요한 키워드는 strRefinementArrList 배열의 맨 앞에 추가한다.
		// 일반 키워드는 차례대로 strRefinementArrList 배열의 뒤에 추가한다.
		for (String word : strInputArrList) { // strInputArrayList에 있는 스트링을 차례로 한개씩 꺼낸다.
			if (word.equals("날씨")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("ㄴㅆ")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("버스")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("정류장")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("지하철")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("1호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("2호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("3호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("4호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("5호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("6호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("7호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("8호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("9호선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("경춘선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("경의중앙선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("분당선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else if (word.equals("신분당선")) { // 중요한 키워드는 맨 앞에 추가한다.
				strRefinementArrList.add(0, word);
			} else { // 일반 키워드는 차례대로 strRefinementArrList위 뒤에 추가한다.
				strRefinementArrList.add(word);
			}
		}

		if (strRefinementArrList.get(0).equals("날씨")) { // "날씨" 키워드가 있는 경우
			strOutputArrList.add(0, "날씨");
			strOutputArrList.add(1, strRefinementArrList.get(1));
		} else if (strRefinementArrList.get(0).equals("ㄴㅆ")) { // "ㄴㅆ" 키워드가 있는 경우
			strOutputArrList.add(0, "날씨");
			strOutputArrList.add(1, strRefinementArrList.get(1));
		} else if (strRefinementArrList.get(0).equals("버스")) { // "버스" 키워드가 있는 경우
			strOutputArrList.add(0, "버스");
			strOutputArrList.add(1, strRefinementArrList.get(1));
		} else if (strRefinementArrList.get(0).equals("정류장")) { // "정류장" 키워드가 있는 경우
			strOutputArrList.add(0, "정류장");
			strOutputArrList.add(1, strRefinementArrList.get(strRefinementArrList.size() - 1)); // 정류장 번호가 있는 부분을 가져온다.

			if (strOutputArrList.get(1).contains("(")) { // 특수문자 "("를 포함하고 있는 경우
				strOutputArrList.set(1, strOutputArrList.get(1).replaceAll("\\(", "")); // 특수문자 "(" 제거
			}

			if (strOutputArrList.get(1).contains(")")) { // 특수문자 ")"를 포함하고 있는 경우
				strOutputArrList.set(1, strOutputArrList.get(1).replaceAll("\\)", "")); // 특수문자 ")" 제거
			}
			
			if (strOutputArrList.get(1).contains("-")) { // 특수문자 "-"를 포함하고 있는 경우
				strOutputArrList.set(1, strOutputArrList.get(1).replaceAll("-", "")); // 특수문자 "-" 제거
			}

			// 정류장 번호는 정수이므로 정류장 번호를 제대로 입력받았는지 확인한다.
			if (!isInteger(strOutputArrList.get(1))) { // 정류장 번호가 올바르지 않은 경우
				strOutputArrList.clear();
				strOutputArrList.add(0, "No Bus Station Code Error");
			}
		} else if (strRefinementArrList.get(0).equals("지하철")) { // "지하철" 키워드가 있는 경우
			strOutputArrList.add(0, "지하철");
			strOutputArrList.add(1, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(1).charAt(strOutputArrList.get(1).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(1, strOutputArrList.get(1).substring(0, strOutputArrList.get(1).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("1호선")) { // "1호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("2호선")) { // "2호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("3호선")) { // "3호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("4호선")) { // "4호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("5호선")) { // "5호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("6호선")) { // "6호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("7호선")) { // "7호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("8호선")) { // "8호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("9호선")) { // "9호선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("경춘선")) { // "경춘선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("경의중앙선")) { // "경의중앙선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("분당선")) { // "분당선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else if (strRefinementArrList.get(0).equals("신분당선")) { // "신분당선" 키워드가 있는 경우
			strOutputArrList.add(0, "노선");
			strOutputArrList.add(1, strRefinementArrList.get(0));
			strOutputArrList.add(2, strRefinementArrList.get(1));

			// 맨 뒤에 있는 글자가 "역"인지 확인한다.
			if (strOutputArrList.get(2).charAt(strOutputArrList.get(2).length() - 1) == '역') { // 맨 뒤에 있는 글자가 "역"인 경우
				// 글자 "역"을 빼버린다.
				strOutputArrList.set(2, strOutputArrList.get(2).substring(0, strOutputArrList.get(2).length() - 1));
			}
		} else { // 중요한 키워드가 1개도 없는 경우
			strOutputArrList.clear();
			strOutputArrList.add(0, "No Keyword Error");
		}

		return strOutputArrList;
	}

	public boolean isInteger(String str) { // 입력받은 스트링이 정수로 변환될 수 있는지 확인한다.
		try {
			Integer.parseInt(str); // 정수로 변환이 불가능하다면 Exception을 발생시킨다.
			return true; // 입력받은 스트링이 정수로 변환될 수 있었기 때문에 예외가 발생하지 않았다.
		} catch (NumberFormatException nfe) {
			return false; // 입력받은 스트링이 정수로 변환될 수 없었기 때문에 예외가 발생하였다.
		}
	}
}