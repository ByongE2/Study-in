//package DatabaseTest;
//import org.jsoup.Jsoup;
//
////웹페이지에서 DB 크롤링. > DB 어디에 저장? > 저장한것 mysql 연동하기. > 출력까지.
//
//public class DbTest01 {
//
//	public static void main(String[] args) {
//		int pages = 2;
////		for(int i=1; i<pages;i++ ) {
//
//
//			String url = "https://news.naver.com/main/list.naver?mode=LS2D&sid2=249&sid1=102&mid=shm&date=20220502&page=";//+i;
//
//			Document doc = Jsoup.connect(url).get();
//					System.out.println(doc);
////
////			Elements elements = doc.getElementsByAttributeValue("class", "list_body newsflash_body");
////			//		System.out.println(elements.get(0));
////			Element element = elements.get(0);
////			//		System.out.println(elements);
////
////			Elements photoElements = element.getElementsByAttributeValue("class","photo");
////			//		System.out.println(photoElements);
////
////			for(int j=0; j < photoElements.size(); j++) {
////				Element articleElement = photoElements.get(j);
////				//			System.out.println(articleElement);
////
////				Elements aElements = articleElement.select("a");
////				Element aElement = aElements.get(0);
////				//			System.out.println(aElement);
////
////				String newsUrl = aElement.attr("href"); // 기사 링크
////				//			System.out.println(newsUrl);
////
////				Element imgElement = aElement.select("img").get(0);
////				//			System.out.println(imgElement);
////				String imgUrl = imgElement.attr("src");			// 이미지 주소 링크 
////				//			System.out.println(imgUrl);
////				String altUrl = imgElement.attr("alt");			
////				//			System.out.println(altUrl);
////
////				Document detatilDoc = Jsoup.connect(newsUrl).get();
////				Element contentElement = detatilDoc.getElementById("dic_area");
////				String content = contentElement.text();
////
//////							System.out.println(alrUrl);
////							System.out.println(content);
////				//			System.out.println();
////			}// for j
////		}// for i
//	}
//
//}
