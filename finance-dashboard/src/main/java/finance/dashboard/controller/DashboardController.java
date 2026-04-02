package finance.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import finance.dashboard.service.DashboardService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public Map<String, Double> summary() {

        Map<String, Double> map = new HashMap<>();
        map.put("income", service.totalIncome());
        map.put("expense", service.totalExpense());
        map.put("balance", service.netBalance());

        return map;
    }
}