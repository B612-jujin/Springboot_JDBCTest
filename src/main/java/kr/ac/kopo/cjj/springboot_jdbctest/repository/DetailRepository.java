package kr.ac.kopo.cjj.springboot_jdbctest.repository;

import kr.ac.kopo.cjj.springboot_jdbctest.domain.Detail;
import kr.ac.kopo.cjj.springboot_jdbctest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
}
