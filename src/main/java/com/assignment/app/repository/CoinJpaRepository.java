package com.assignment.app.repository;


import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.assignment.app.model.CoinDTO;

@Repository
public interface CoinJpaRepository extends CrudRepository<CoinDTO, Long>  {

	CoinDTO save(CoinDTO coinData);

	CoinDTO findById(long id);

	List<CoinDTO> findBySymbol(String symbol);

	@Query(value = "select * from coin_price_history;" , nativeQuery = true)
	List<CoinDTO> getAll();
}
