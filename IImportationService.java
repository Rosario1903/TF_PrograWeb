package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Importation;

public interface IImportationService {

	public boolean insert(Importation importation);

	Importation listarId(Long idImport);

	List<Importation> listar();

	Optional<Importation> fetchByImportIdWhithImportDetailsWithProduct(Long id);

}
