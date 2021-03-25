package medicines.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MedicineDao {
    void showMedicineInfo(HttpServletRequest request, HttpServletResponse response);

    void showResposity(HttpServletRequest request, HttpServletResponse response);

    void showFactory(HttpServletRequest request, HttpServletResponse response);

    void showIn(HttpServletRequest request, HttpServletResponse response);

    void showOut(HttpServletRequest request, HttpServletResponse response);

    void showInMore(HttpServletRequest request, HttpServletResponse response);

    void showOutMore(HttpServletRequest request, HttpServletResponse response);

    void showClient(HttpServletRequest request, HttpServletResponse response);

    void putIn(HttpServletRequest request, HttpServletResponse response);

    void userBuy(HttpServletRequest request, HttpServletResponse response);

    void userClick(HttpServletRequest request, HttpServletResponse response);

//    void searchMedInfo(HttpServletRequest request, HttpServletResponse response);
}
