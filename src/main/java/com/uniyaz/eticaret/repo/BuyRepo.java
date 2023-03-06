package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepo extends JpaRepository<Buy,Long> {


}
