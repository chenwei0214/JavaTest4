package com.hand;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import com.hand.api.service.FilmService;
import com.hand.infra.config.CustomCloseSpringListener;
import com.hand.infra.config.CustomStartSpringListener;
import com.hand.infra.dataobject.FilmDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private ClassPathXmlApplicationContext context;

    public Application() {
        String[] resources = new String[]{"applicationContext.xml", "applicationContext-mybatis.xml"};
        this.context = new ClassPathXmlApplicationContext(resources);
        this.context.addApplicationListener(new CustomCloseSpringListener());
        this.context.addApplicationListener(new CustomStartSpringListener());
    }

    public void getEvnAndInsertFilmErr(FilmDO filmDO) {
        FilmService filmService = this.context.getBean(FilmService.class);
        filmService.getEvnAndInsertFilm(filmDO, true);
    }

    public void getEvnAndInsertFilmOk(FilmDO filmDO) {
        FilmService filmService = this.context.getBean(FilmService.class);
        filmService.getEvnAndInsertFilm(filmDO, false);
    }

    public static void main(String[] args) {
        Application application = new Application();
        Map<String, String> map = System.getenv();
        String title = map.get("title");
        String description = map.get("description");
        String languageId = map.get("languageId");
        System.out.println("Film title:");
        System.out.println(title);
        System.out.println("Film description:");
        System.out.println(description);
        System.out.println("Film languageId:");
        System.out.println(languageId);
        FilmDO filmDO = new FilmDO();
        filmDO.setDescription(description);
        filmDO.setTitle(title);
        filmDO.setLanguageId(Integer.parseInt(languageId));
        //不允许为空
        filmDO.setLastUpdate(new Date());
        filmDO.setLength(4);
        filmDO.setReleaseYear(2018);
        filmDO.setRentalRate(BigDecimal.valueOf(2.99));
        filmDO.setRentalDuration(5);
        filmDO.setReplacementCost(BigDecimal.valueOf(15.99));

        application.getEvnAndInsertFilmOk(filmDO);
        //抛出异常
        application.getEvnAndInsertFilmErr(filmDO);
    }
}
