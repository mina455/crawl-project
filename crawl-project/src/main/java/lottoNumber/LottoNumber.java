package lottoNumber;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LottoNumber {	
	private String img_id;
	
	public LottoNumber(){
		try {
			GetNumber();
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}
	
	public void GetNumber() throws Exception{
		Document doc = Jsoup.connect("http://www.nlotto.co.kr/common.do?method=main").get();
		Elements contents;
		
		System.out.println("제 " + doc.select("#lottoDrwNo").text() + "회 당첨번호");
		System.out.print("로또번호 :");
		for(int i=1; i<=6; i++){
			img_id = "#drwtNo"+i;
			contents = doc.select(img_id);
			System.out.print(" "+contents.attr("alt"));
		}
		
		contents = doc.select("#bnusNo");
		System.out.println("\n + 보너스 번호 : "+contents.attr("alt"));
	}
}
