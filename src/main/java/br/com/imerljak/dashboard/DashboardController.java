package br.com.imerljak.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {this.dashboardService = dashboardService;}

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("denunciasNoMes", dashboardService.countDenunciasAt(LocalDate.now().getMonth()));
        model.addAttribute("processosNoMes", dashboardService.countProcessosAt(LocalDate.now().getMonth()));
        return "index";
    }

}
