package appsuite.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appsuite.domain.AuditLog;
import appsuite.domain.User;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {


}