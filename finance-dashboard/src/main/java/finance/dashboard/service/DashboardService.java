package finance.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.dashboard.entity.FinancialRecord;
import finance.dashboard.repository.RecordRepository;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private RecordRepository repo;

    public double totalIncome() {
        return repo.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("income"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double totalExpense() {
        return repo.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("expense"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double netBalance() {
        return totalIncome() - totalExpense();
    }
}