package finance.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.dashboard.entity.FinancialRecord;
import finance.dashboard.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        if(record.getAmount() <= 0){
            throw new RuntimeException("Invalid amount");
        }
        return repo.save(record);
    }
    
    public FinancialRecord update(Long id, FinancialRecord newRecord) {

        FinancialRecord old = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        old.setAmount(newRecord.getAmount());
        old.setType(newRecord.getType());
        old.setCategory(newRecord.getCategory());
        old.setDate(newRecord.getDate());
        old.setNote(newRecord.getNote());

        return repo.save(old);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}