package cl.inacap.ZcapModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacp.ZcapModel.dto.Registro;

@Local
public interface RegistroDAOLocal {
	

	void save(Registro registro);

	List<Registro> getAll();

	void delete(Registro registro);

	List<Registro> filterByTipoRegistro(String tipoSolicitud);
	

	List<Registro> filterByNombre(String nombre);
	

   
}
