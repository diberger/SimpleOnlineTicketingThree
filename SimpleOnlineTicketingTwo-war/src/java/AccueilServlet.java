/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.AddEventFormBean;
import beans.CustomerBean;
import beans.EventBean;
import beans.SessionUtils;
import data.StubBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import metier.Event;

/**
 *
 * @author diberger
 */
@WebServlet(urlPatterns = {"/"})
public class AccueilServlet extends HttpServlet {
    
    @EJB
    private CustomerBean customerBean;     
    @EJB
    private EventBean eventBean; 
    @EJB
    private StubBean stubBean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccueilServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccueilServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Stub temporaire
        //stubBean.loadCategories();
        //stubBean.loadEvents();
        //stubBean.loadCustomer();
        try (PrintWriter out = response.getWriter()) {
        if(request.getParameter("id") != null){
            try{
            request.setAttribute("event", eventBean.findOneById(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher( "event.jsp" ).forward( request, response );
            }catch(Exception e){
                out.println(e.getMessage());
            }
        }
        else {
            String user = "visiteur";
            try{
            HttpSession session = request.getSession();
            
            request.setAttribute("events", eventBean.findAll());
            
            if(session != null && session.getAttribute("username") != null){
            user = session.getAttribute("username").toString();
            }
            request.setAttribute("user", user);
            request.getRequestDispatcher( "homeJsp.jsp" ).forward( request, response );
            }catch(Exception e){
                out.println(SessionUtils.getSession());
                out.println(e.getMessage());
                out.println(user);
            }
        }
        }catch(Exception e) {
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
