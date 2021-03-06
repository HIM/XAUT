package medicines.service.impl;

import medicines.dao.MedicineDao;
import medicines.dao.impl.MedicineDaoImpl;
import medicines.service.MedicineService;
import medicines.utils.JDBCUtiles;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class MedicineServiceImpl implements MedicineService {
    private MedicineDao dao = new MedicineDaoImpl();


    @Override
    public void showMedicineInfo(HttpServletRequest request, HttpServletResponse response) {
        dao.showMedicineInfo(request,response);
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try{
            String sql = "select * from role where name ='"+username+"' and pwd='"+password+"'";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            if(rs.next()){
                rs.close();
                JDBCUtiles.close();
                request.getRequestDispatcher("/overView.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showResposity(HttpServletRequest request, HttpServletResponse response) {
        dao.showResposity(request,response);
    }

    @Override
    public void showFactory(HttpServletRequest request, HttpServletResponse response) {
        dao.showFactory(request,response);
    }

    @Override
    public void showIn(HttpServletRequest request, HttpServletResponse response) {
        dao.showIn(request,response);
    }

    @Override
    public void showOut(HttpServletRequest request, HttpServletResponse response) {
        dao.showOut(request,response);
    }

    @Override
    public void showInMore(HttpServletRequest request, HttpServletResponse response) {
        dao.showInMore(request,response);
    }

    @Override
    public void showOutMore(HttpServletRequest request, HttpServletResponse response) {
        dao.showOutMore(request,response);
    }

    @Override
    public void showClient(HttpServletRequest request, HttpServletResponse response) {
        dao.showClient(request,response);
    }

    @Override
    public void putIn(HttpServletRequest request, HttpServletResponse response) {
        dao.putIn(request,response);
    }

    @Override
    public void userBuy(HttpServletRequest request, HttpServletResponse response) {
        dao.userBuy(request,response);
    }

    @Override
    public void userClick(HttpServletRequest request, HttpServletResponse response) {
        dao.userClick(request,response);
    }

//    @Override
//    public void searchMedInfo(HttpServletRequest request, HttpServletResponse response) {
////        dao.searchMedInfo(request,response);
//    }
}
