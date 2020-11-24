package pe.edu.upc.serviceinterface;

import pe.edu.upc.entity.ImportDetails;

public interface IImportDetailService {
	public Integer insert(ImportDetails impd);

	public void delete(Long idImportDetail);

}
