package com.example.PaymentSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.PaymentSystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	@Query(value = "SELECT * FROM bill b WHERE b.user_id = :id", nativeQuery = true)
	public List<Bill> findAllBillById(@Param("id") long id);
	
	@Query(value = "SELECT * FROM bill b WHERE b.status = :param", nativeQuery = true)
	public List<Bill> getBillByStatus(String param);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE bill b SET b.amount = b.amount - :amount WHERE b.id = :id", nativeQuery = true)
	public void payBill(long id, double amount);
}
