package cl.inacap.ZcapApp.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.ZcapModel.dao.RegistroDAOLocal;
import cl.inacp.ZcapModel.dto.Registro;

/**
 * Servlet implementation class AgregarSolicitudController
 */
@WebServlet("/AgregarSolicitudController.do")
public class AgregarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private RegistroDAOLocal registroDAO ;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarSolicitudController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/vistas/AgregarSolicitud.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<String> errores = new ArrayList<>();	
		
	  
		
		String ruttxt = request.getParameter("rut-txt").trim();
		int rut = 0;
		try {			
			rut = Integer.parseInt(ruttxt);
			
		} catch (Exception ex) {
			errores.add("rut debe ser numerico");
		}
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("ingrese nombre");
		}
		String tipoSolicitud = request.getParameter("tipoSolicitud-select").trim();
		if (tipoSolicitud.isEmpty()) {
			errores.add("debe seleccionar un tipo de solicitud");
		}
		if (errores.isEmpty()) {	
			Registro registro = new Registro() ;
			AtomicInteger num =new AtomicInteger(1);
			
			if(num != null) {

				
			}
			
			
			
			registro.setRut(rut);
			registro.setNombre(nombre);
			registro.setTipoSolicitud(tipoSolicitud);
			
			registroDAO.save(registro);	
			
			request.setAttribute("mensaje", "Registro exitoso, su numero  " + num);
			
		} else {
			request.setAttribute("errores", errores);
		}
		doGet(request, response);
	}

}
