package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.ImportDetails;
import pe.edu.upc.repository.IImportDetailRepository;
import pe.edu.upc.serviceinterface.IImportDetailService;

@Service
public class ImportDetailServiceImpl implements IImportDetailService {

	@Autowired
	private IImportDetailRepository ideR;

	@Override
	public void delete(Long idImportDetail) {
		ideR.deleteById(idImportDetail);
	}

	@Override
	public Integer insert(ImportDetails impd) {
		ImportDetails impde = ideR.save(impd);
		if (impde == null) {
			return 0;
		} else {
			return 1;
		}
	}

}
