package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Importation;
import pe.edu.upc.repository.IImportationRepository;
import pe.edu.upc.serviceinterface.IImportationService;

@Service
public class ImportationServiceImpl implements IImportationService {

	@Autowired
	private IImportationRepository iR;

	@Override
	public boolean insert(Importation importation) {
		Importation imp = iR.save(importation);
		if (imp == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public Importation listarId(Long idImport) {
		Optional<Importation> op = iR.findById(idImport);
		return op.isPresent() ? op.get() : new Importation();
	}

	@Override
	public List<Importation> listar() {
		return iR.findAll();
	}

	@Override
	public Optional<Importation> fetchByImportIdWhithImportDetailsWithProduct(Long id) {
		return iR.fetchByImportIdWhithImportDetailsWithProduct(id);
	}

}
