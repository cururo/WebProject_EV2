package cl.inacap.ZcapApp.Controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.ZcapModel.dao.RegistroDAOLocal;
import cl.inacp.ZcapModel.dto.Registro;

/**
 * Servlet implementation class VerSolicitudController
 */
@WebServlet("/VerSolicitudController.do")
public class VerSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private  RegistroDAOLocal RegistroDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		if(request.getParameter("nombreEliminar") != null) {
			
			
			String nombre = request.getParameter("nombreEliminar").trim();
			List<Registro> busqueda = RegistroDAO.filterByNombre(nombre);
			Registro registroEliminar = busqueda.isEmpty()? null:busqueda.get(0);
			
			
			if(registroEliminar != null) {
				RegistroDAO.delete(registroEliminar);
				
			}
			
		}
		List<Registro> regitros = RegistroDAO.getAll();
		
		request.setAttribute("registros", regitros);
		
		request.getRequestDispatcher("WEB-INF/vistas/verRegistro.jsp").forward(request, response);
		
		
	}				 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		
		
		
		
		
		
		doGet(request, response);
		
		
		
		
		
		
	}

}
