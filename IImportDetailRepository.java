package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.ImportDetails;

@Repository
public interface IImportDetailRepository extends JpaRepository<ImportDetails, Long> {

}
