package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Opinion;

public interface IOpinionService {
	public void insert(Opinion opi);

	List<Opinion> list();
}
