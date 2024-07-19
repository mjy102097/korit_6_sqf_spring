package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DvdController {

    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();
        model.addAttribute(dvd);    //객체
        model.addAttribute("names", List.of("문주영", "문주일", "문주이")); //리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3)); //리스트
        model.addAttribute("title", "테스트 제목"); //리터럴
        return "views/dvd_list";
    }

//    @GetMapping("/dvds")
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("views/dvd_list");
//        return mav;
//    }

    @ResponseBody
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

//    @ResponseBody
//    @GetMapping("/dvd")
//    public Dvd getDvd() {
//        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작사").publisher("텍스트 발행사").build();
//        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("텍스트 발행사2").build();
//        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("텍스트 발행사3").build();
//        return List.of(dvd, dvd2, dvd3);
//    }
}
