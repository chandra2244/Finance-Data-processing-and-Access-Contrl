package finance.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finance.dashboard.entity.FinancialRecord;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {}
