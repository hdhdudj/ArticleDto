package sbs.demo.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int lastIndex = -1;
	ArticleDto[] arr = new ArticleDto[100];
	
	@RequestMapping(value="/setArticle" , produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String addArticle(long id, String title, String body) {
		ArticleDto art = new ArticleDto();
		lastIndex++;
		art.setArticle(id, title, body);
		arr[lastIndex] = art;
		return art.toString()+" 배열이 저장되었습니다.";
	}
	
	@RequestMapping(value="/getArticles", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String getArticle() {
		if(lastIndex > -1) {
			String asdf = "[";
			for(int i = 0 ; i <= lastIndex ; i++) {
				asdf += arr[i].toString();
				if(i != lastIndex) {
					asdf += " , ";
				}
			}
			asdf += "]";
			return asdf;
		}
		return "저장된 배열이 없습니다.";
	}
}
