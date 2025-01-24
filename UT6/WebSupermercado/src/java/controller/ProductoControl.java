/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

/**
 *
 * @author Danim2205
 */
public class ProductoControl extends HttpServlet {

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
            out.println("<title>Servlet ProductoControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoControl at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            float precio = Float.parseFloat(request.getParameter("precio"));
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            String proveedor = request.getParameter("proveedor");
            String accion = request.getParameter("accion").toLowerCase();

            Producto prod = new Producto(codigo, nombre, descripcion, cantidad, precio, categoria, proveedor);

            switch (accion) {
                case "registrar":
                    if (ProductoDao.registrarProducto(prod)) {
                        request.setAttribute("mensaje", "Producto registrado");
                    } else {
                        request.setAttribute("mensaje", "Producto NO registrado");
                    }
                    break;
                case "actualizar":
                    if (ProductoDao.actualizarProducto(prod)) {
                        request.setAttribute("mensaje", "Producto actualizado");
                    } else {
                        request.setAttribute("mensaje", "Producto NO actualizado");
                    }
                    break;
                case "eliminar":
                    if (ProductoDao.borrarProducto(prod)) {
                        request.setAttribute("mensaje", "Producto eliminado");
                    } else {
                        request.setAttribute("mensaje", "Producto NO eliminado");
                    }
                    break;
                default:
                    request.setAttribute("mensaje", "Accion desconocida");
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("mensaje", "Ocurrio un error");
        }
        request.getRequestDispatcher("RegistroProducto.jsp").forward(request, response);
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
