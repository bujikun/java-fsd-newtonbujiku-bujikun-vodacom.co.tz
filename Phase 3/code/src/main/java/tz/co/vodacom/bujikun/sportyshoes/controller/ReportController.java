package tz.co.vodacom.bujikun.sportyshoes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tz.co.vodacom.bujikun.sportyshoes.dao.ReportDAO;
import tz.co.vodacom.bujikun.sportyshoes.dto.ReportDTO;
import tz.co.vodacom.bujikun.sportyshoes.service.CategoryService;
import tz.co.vodacom.bujikun.sportyshoes.service.OrderService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    private final CategoryService categoryService;
    private final ReportDAO reportDAO;
    @GetMapping
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).REPORT_VIEW.value)")
    public String index(Model model){
        model.addAttribute("orders",reportDAO.getAll());
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("searched",false);
        return "report/index";
    }

    @PostMapping("/search")
    @PreAuthorize("hasAuthority(T(tz.co.vodacom.bujikun.sportyshoes.enumeration.PermissionName).REPORT_VIEW.value)")
    public String filterReports(
            @RequestParam(required = false, name = "startDate") String startDate,
            @RequestParam(required = false, name = "endDate") String endDate,
            @RequestParam(required = false, name = "categoryId") Integer categoryId,
            Model model
    ){
        List<ReportDTO> reports;
        var categories = categoryService.findAll();
        String categoryName;
        if(categoryId == -1){
            reports = reportDAO.queryAll(startDate,endDate);
            categoryName="All Categories";
        }else{
            reports = reportDAO.queryPerCriteria(categoryId,startDate,endDate);
            categoryName=categories.stream().filter(c->c.getId()==categoryId).findFirst().get().getName();

        }
        var message = "Showing "+reports.size()+" results for query: from "+startDate+" to "+endDate +" in "+
                categoryName;
        model.addAttribute("orders",reports);
        model.addAttribute("categories",categories);
        model.addAttribute("searched",true);
        model.addAttribute("message",message);
        return "report/index";
    }
}
