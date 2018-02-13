package webtoon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NaverWebtoon {
	
	private String img_id;
		
	public NaverWebtoon(){
		try {
			GetWebtoon();
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}
	
	public void GetWebtoon() throws Exception{
		Document doc = Jsoup.connect("http://comic.naver.com/webtoon/detail.nhn?titleId=697685&no=1&weekday=thu").get();
		Elements contents;
		Elements imgs = doc.select(".wt_viewer img");
//		System.out.println("이미지 url(jpg) : " + doc.select("#content_image_0").attr("src"));
		
		System.out.println(imgs.size());
		
		for(int i=0; i<imgs.size(); i++){
			img_id = "#content_image_"+i;
			System.out.println("이미지 html <img> id : " +img_id);
			
			contents = doc.select(img_id);
			System.out.println("이미지 url(jpg) : " + contents.attr("src"));
		}		
		
	}
}
