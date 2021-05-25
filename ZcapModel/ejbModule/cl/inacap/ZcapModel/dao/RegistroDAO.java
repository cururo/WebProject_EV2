package cl.inacap.ZcapModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacp.ZcapModel.dto.Registro;

/**
 * Session Bean implementation class RegistroDAO
 */
@Stateless
@LocalBean
public class RegistroDAO implements RegistroDAOLocal {
	
	
 private static List<Registro> registros = new ArrayList<>();

@Override
public void save(Registro registro) {
	// TODO Auto-generated method stub
	registros.add(registro);
}

@Override
public List<Registro> getAll() {
	// TODO Auto-generated method stub
	return registros;
}

@Override
public void delete(Registro registro) {
	// TODO Auto-generated method stub
	registros.remove(registro);
}

@Override
public List<Registro> filterByTipoRegistro(String tipoSolicitud) {
	// TODO Auto-generated method stub
	return registros.stream().filter(r->r.getTipoSolicitud().contains(tipoSolicitud)).collect(Collectors.toList());
}

public List<Registro> filterByNombre(String nombre) {
	// TODO Auto-generated method stub
	return registros.stream().filter(n->n.getNombre().contains(nombre)).collect(Collectors.toList());
}





}
