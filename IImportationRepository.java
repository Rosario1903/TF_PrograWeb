package pe.edu.upc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Importation;
@Repository
public interface IImportationRepository extends JpaRepository<Importation, Long> {

	@Query("select i from Importation i join fetch i.importDetails ide join fetch ide.product where i.idImportation=?1")
	Optional<Importation> fetchByImportIdWhithImportDetailsWithProduct(Long id);

}
