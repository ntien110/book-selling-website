/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.DauSach;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import services.DauSachService;
import sessionBean.DauSachDAO;
import taskHandling.fileUploadHandler;

/**
 *
 * @author 1920
 */
public class addBook extends HttpServlet {

    
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
        request.getRequestDispatcher("/addBook.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
              
        String tenSach = request.getParameter("tenSach");
        short namXuatBan = Short.parseShort((String)request.getParameter("namXuatBan"));
        String theLoai = request.getParameter("theLoai");
        String anhBia = request.getParameter("tenSach");
        String moTa = request.getParameter("description");
        DauSach dauSach = new DauSach();
        
        dauSach.setTenSach(tenSach);
        dauSach.setNamSuatBan(namXuatBan);
        dauSach.setTheLoai(theLoai);
        dauSach.setUrlAnh("/image/" + anhBia + ".jpg");
        dauSach.setMoTa(moTa);
        new DauSachService().create(dauSach);
        request.setAttribute("tenSach", tenSach);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //request.setAttribute("fileName", anhBia);
        request.getRequestDispatcher("/addBookImage.jsp").forward(request, response);
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
