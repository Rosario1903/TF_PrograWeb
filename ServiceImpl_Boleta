package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upc.entity.Boleta;
import pe.edu.upc.repository.BoletaRepository;
import pe.edu.upc.serviceinterface.IBoletaService;

public class BoletaServiceImpl implements IBoletaService {
	@Autowired
	private BoletaRepository bR;

	@Override
	public void insert(Boleta bol) {
		try {
			bR.save(bol);

		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Boleta");
		}
	}

	@Override
	public List<Boleta> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

}
