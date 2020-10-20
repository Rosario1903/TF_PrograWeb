package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entity.Opinion;
@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {

}


