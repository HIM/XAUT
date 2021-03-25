package medicines.dao.impl;

import medicines.dao.MedicineDao;
import medicines.domain.Medicine;
import medicines.domain.Storage;
import medicines.domain.details.*;
import medicines.utils.JDBCUtiles;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

//    private static SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void showMedicineInfo(HttpServletRequest request, HttpServletResponse response) {
        List<Medicine> list = new ArrayList<Medicine>();

        try{
            String sql = "select * from medicine_info";
            String medSearch = request.getParameter("med-search");
            if(medSearch!=null&&!medSearch.equals("")){
                sql = sql + " where med_name like '%"
                        + medSearch + "%' or med_id like '%"
                        + medSearch + "%' or class like '%"
                        + medSearch + "%' or factor like '%"
                        + medSearch + "%'";
            }

            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int pur_price, sale_price, validity;double discount;
            while (rs.next()){
                Medicine medicine = new Medicine();
                medicine.setMed_name(rs.getString("med_name"));
                medicine.setMed_id(rs.getString("med_id"));
                medicine.setMde_class(rs.getString("class"));
                medicine.setFactor(rs.getString("factor"));
                pur_price = Integer.parseInt(rs.getString("purchase_price"));
                medicine.setPurchase_price(pur_price);
                sale_price = Integer.parseInt(rs.getString("sale_price"));
                medicine.setSale_price(sale_price);
                validity = Integer.parseInt(rs.getString("validity"));
                medicine.setValidity(validity);
                discount = Double.parseDouble(rs.getString("discount"));
                medicine.setDiscount(discount);
                medicine.setImg_url(rs.getString("img_url"));
                list.add(medicine);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/medicinesM.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void showResposity(HttpServletRequest request, HttpServletResponse response) {
        List<Storage> list = new ArrayList<Storage>();
        try{
            String sql = "select s.med_id,m.med_name,stock_num,production_date FROM medicine_info m JOIN storage s on m.med_id = s.med_id";
            String medSearch = request.getParameter("med-search");
            if(medSearch!=null&&!medSearch.equals("")){
                sql = sql + " where s.med_id like '%"
                        +medSearch+"%' or m.med_name like '%"
                        +medSearch+"%' ";
            }
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int stock_num;

            while (rs.next()){
                Storage storage = new Storage();
                storage.setMed_name(rs.getString("med_name"));  //获取名称
                storage.setMed_id(rs.getString("med_id"));
                stock_num = Integer.parseInt(rs.getString("stock_num"));
                storage.setStock_num(stock_num);
                storage.setProduction_date(rs.getString("production_date"));
                list.add(storage);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/resposityM.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showFactory(HttpServletRequest request, HttpServletResponse response) {
        List<Factory> list = new ArrayList<Factory>();
        try{
            String sqll = "SELECT f.fac_name,f.med_identify,m.purchase_price,m.med_name,f.production_date FROM factor f JOIN medicine_info m on m.med_id = f.med_identify order by med_identify";
            String sql = "select * from factor";
            System.out.println(sqll);
            ResultSet rs = JDBCUtiles.query(sqll);
            int stock_num;
            while (rs.next()){
                Factory factory = new Factory();
                factory.setFac_name(rs.getString("fac_name"));
                factory.setMed_identify(rs.getString("med_identify"));
                factory.setPurchase_price(Integer.parseInt(rs.getString("purchase_price")));
                factory.setMed_name(rs.getString("med_name"));
//                String identity = rs.getString("med_identify");
//                String sql2 = "select purchase_price from medicine_info where med_id ='"+identity+"'";
//                ResultSet rss = JDBCUtiles.queryTwo(sql2);
//                while (rss.next()){
//                    factory.setPurchase_price(Integer.parseInt(rss.getString("purchase_price")));
//                }
                factory.setProduction_date(rs.getString("production_date"));
                list.add(factory);

            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/factoryM.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showIn(HttpServletRequest request, HttpServletResponse response) {
        List<in> list = new ArrayList<in>();
        try{
            String sql = "select DISTINCT purchase_id, purchase_date from purchase_details";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                in in = new in();
                in.setPurchase_id(rs.getString("purchase_id"));
                in.setPurchase_date(rs.getString("purchase_date"));
                list.add(in);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/inResposity.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showOut(HttpServletRequest request, HttpServletResponse response) {
        List<out> list = new ArrayList<out>();
        List<outMore> listMore = new ArrayList<outMore>();
        try{
            String sql = "select DISTINCT sale_id,sale_date from sale_details";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                out ou = new out();
                ou.setSale_id(rs.getString("sale_id"));
                ou.setSale_date(rs.getString("sale_date"));
                list.add(ou);
            }




            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/outResposity.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showInMore(HttpServletRequest request, HttpServletResponse response) {
        List<inMore> list = new ArrayList<inMore>();
        try{
            String sql = "select * from purchase_details";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            int purchase_price, purchase_date;
            while (rs.next()){
                inMore inM = new inMore();
                inM.setPurchase_id(rs.getString("purchase_id"));
                inM.setFactor_name(rs.getString("factor_name"));
                inM.setMed_id(rs.getString("med_id"));
                inM.setPurchase_price(Integer.parseInt(rs.getString("purchase_price")));
                inM.setPurchase_num(Integer.parseInt(rs.getString("purchase_num")));
                inM.setPurchase_date(rs.getString("purchase_date"));
                list.add(inM);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/inResposityMore.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showOutMore(HttpServletRequest request, HttpServletResponse response) {
        List<outMore> list = new ArrayList<outMore>();
        try{
            String sql = "select * from sale_details s JOIN medicine_info m WHERE s.med_id = m.med_id";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                outMore outm = new outMore();
                outm.setSale_id(rs.getString("sale_id"));
                outm.setUser_id(rs.getString("user_id"));
                outm.setMed_id(rs.getString("med_id"));
                outm.setMed_name(rs.getString("med_name"));
                outm.setTrue_price(Double.parseDouble(rs.getString("true_price")));
                outm.setSale_discount(Double.parseDouble(rs.getString("sale_discount")));
                outm.setSale_num(Integer.parseInt(rs.getString("sale_num")));
                outm.setSale_date(rs.getString("sale_date"));
                list.add(outm);
            }

            String sqlB = "select DISTINCT sale_id from sale_details";
            rs = JDBCUtiles.query(sqlB);
            List<String> str = new ArrayList<>();       //放id
            while (rs.next()){
                str.add(rs.getString("sale_id"));
            }
            double[] sumD = new double[str.size()];         //放总价

            int[] str_num = new int[str.size()];    //不同id的个数
            for(int i=0;i<str.size();i++){ sumD[i] = 0; }
            rs = JDBCUtiles.query(sql);

            for(int i=0;i<str.size();i++){
                for(int k =0;k<list.size();k++){
                    if(list.get(k).getSale_id().equals(str.get(i))){
                        sumD[i] += list.get(k).getTrue_price()*list.get(k).getSale_discount()*list.get(k).getSale_num();
                        str_num[i]++;
                    }
                }
            }

            for(int i=0;i<str.size();i++){
                for(int k =0;k<list.size();k++){
                    if(list.get(k).getSale_id().equals(str.get(i))){
                        list.get(k).setSum_price(sumD[i]);
                    }
                }
            }


            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/outResposityMore.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showClient(HttpServletRequest request, HttpServletResponse response) {
        List<Client> list = new ArrayList<Client>();
        try{
            String sql = "select * from user";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                Client client = new Client();
                client.setUser_id(rs.getString("user_id"));
                client.setUser_tel(rs.getString("user_tel"));
                list.add(client);
            }
            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/Client.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void putIn(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = new String[21];
        String[] nums = new String[21];

        String idStr, numStr;int n = 0;
        for(int i = 0;i<=20;i++){
            if(i<10){
                numStr = "10" + i + "_num";
            }else {
                numStr ="1" + i + "_num";
            }
            if(Integer.parseInt(request.getParameter(numStr)) != 0){
                n++;
                if(i<10){
                    idStr = "10" + i +"_id";
                }else {
                    idStr ="1" + i +"_id";
                }
                ids[i] = request.getParameter(idStr);
                nums[i] = request.getParameter(numStr);
            }
        }
        String[] idss = new String[n];
        int[] numss = new int[n];
        int j = 0;
        for(int i = 0;i<=20;i++){
            if(nums[i]!=null){
                idss[j] = ids[i];
                numss[j] = Integer.parseInt(nums[i]);
                j++;
            }
        }

//        for(int i=0;i<n;i++){
//            System.out.println("idss["+i+"]: "+idss[i]);
//            System.out.println("numss["+i+"]: "+numss[i]);
//        }

        List<Medicine> list = new ArrayList<Medicine>();
        for(int i=0;i<n;i++){
            try{
                String sql = "select * from medicine_info where med_id='"+ idss[i] +"'";
                System.out.println(sql);
                ResultSet rs = JDBCUtiles.query(sql);
                int pur_price, sale_price, validity;double discount;
                while (rs.next()){
                    Medicine medicine = new Medicine();
                    medicine.setMed_name(rs.getString("med_name"));
                    medicine.setMed_id(rs.getString("med_id"));
                    medicine.setFactor(rs.getString("factor"));
                    pur_price = Integer.parseInt(rs.getString("purchase_price"));
                    medicine.setPurchase_price(pur_price);
                    list.add(medicine);
                }
                rs.close();
                JDBCUtiles.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Date date = new Date();
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        String day = String.format("%td", date);
        String m = String.format("%tm", date);
        String s = String.format("%ts", date);
        String datee = year+"-"+month+"-"+day;
        String dateStr = year + month + day +m+s;
        System.out.println("dateStr: "+dateStr);

        inMore[] inms = new inMore[n];
        List<inMore> inmores = new ArrayList<inMore>();
        for(int i=0;i<n;i++){
            inMore inm = new inMore();
            inm.setPurchase_id(dateStr);
            inm.setFactor_name(list.get(i).getFactor());
            inm.setMed_id(list.get(i).getMed_id());
            inm.setMed_name(list.get(i).getMed_name());
            inm.setPurchase_price(list.get(i).getPurchase_price());
            inm.setPurchase_num(numss[i]);
            inm.setPurchase_date(datee);
            inmores.add(inm);
        }

        for(int i=0;i<n;i++){
            String sql = "insert into purchase_details values ('"
                    +inmores.get(i).getPurchase_id() +"','"
                    +inmores.get(i).getFactor_name()+"','"
                    +inmores.get(i).getMed_id()+"',"
                    +inmores.get(i).getPurchase_price()+","
                    +inmores.get(i).getPurchase_num()+",'"
                    +inmores.get(i).getPurchase_date() +"')";
            System.out.println(sql);
            JDBCUtiles.add(sql);

        }


        List<Storage> listSto = new ArrayList<Storage>();
        List<Factory> listFac = new ArrayList<Factory>();
        for(int i=0;i<n;i++){
            try{
                String sqll = "select production_date,med_id FROM storage  where med_id = '"+inmores.get(i).getMed_id()+"'";
                String sql4 = "select production_date,med_identify FROM factor  where med_identify = '"+inmores.get(i).getMed_id()+"'";
                ResultSet rs = JDBCUtiles.query(sqll);
                ResultSet rss = JDBCUtiles.query(sql4);
                //存储仓库时间
                while (rs.next()){
                    Storage storage = new Storage();
                    storage.setMed_id(rs.getString("med_id"));
                    storage.setProduction_date(rs.getString("production_date"));
                    listSto.add(storage);
                }
                //工厂日期
                while (rss.next()){
                    Factory factory = new Factory();
                    factory.setProduction_date(rss.getString("production_date"));
                    factory.setMed_identify(rss.getString("med_identify"));

                    String med_id = factory.getMed_identify();
                    String production_date = factory.getProduction_date();

                    System.out.println("厂家药品ID:"+rss.getString("med_identify"));
                    listFac.add(factory);
                    String tempdate = listFac.get(0).getProduction_date();
                    System.out.println("tempdate: "+tempdate+"  ***   仓库日期："+listSto.get(0).getProduction_date()+" ***   工厂日期listFac："+listFac.get(0).getProduction_date());
                    //遍历仓库记录
                    String sql5 = "SELECT s.production_date FROM storage s JOIN storage t WHERE s.production_date = t.production_date";
                    ResultSet bools = JDBCUtiles.query(sql5);
                    for(int z = 0;z<listSto.size();z++) {
                        //判断药品id是否相等
                        if (listSto.get(z).getMed_id().equals(listFac.get(0).getMed_identify())) {
                            System.out.println(listSto.get(z).getProduction_date().equals(tempdate) + "   " + listSto.get(z).getProduction_date() + "    " + tempdate);
                            //判断生产日期是否相等
                            if (listSto.get(z).getProduction_date().equals(tempdate)) {
                                String sql2 = "update storage set stock_num = (stock_num +" + inmores.get(i).getPurchase_num() + ") where med_id = " + med_id + " AND production_date = '" + production_date + "'";
                                System.out.println(sql2);
                                JDBCUtiles.update(sql2);
                                break;
                            } else if (bools != null) {
                                String sql6 = "update storage set stock_num = (stock_num +" + inmores.get(i).getPurchase_num() + ") where med_id = " + med_id + " AND production_date = '" + production_date + "'";
                                System.out.println(sql6);
                                JDBCUtiles.update(sql6);
                                break;
                            } else {
                                String sql3 = "insert into storage values('"
                                        + inmores.get(i).getMed_id() + "',"
                                        + inmores.get(i).getPurchase_num() + ",'"
                                        + listFac.get(i).getProduction_date() + "')";
                                System.out.println("sql3: " + sql3);
                                JDBCUtiles.add(sql3);
                                break;
                            }
                        }
                    }
                }rs.close();
                JDBCUtiles.close();
                rs.close();
                JDBCUtiles.close();
//                request.getRequestDispatcher("/resposityServlet").forward(request,response);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void userBuy(HttpServletRequest request, HttpServletResponse response) {
        List<UserBuyInfo> list = new ArrayList<UserBuyInfo>();
        try{
            String sql = "select m.med_id, m.img_url, m.med_name, m.factor, s.production_date, m.sale_price, s.stock_num from medicine_info m join storage s where s.med_id = m.med_id";
            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                UserBuyInfo userBuyInfo = new UserBuyInfo();

                userBuyInfo.setMed_id(rs.getString("med_id"));
                userBuyInfo.setImg_url(rs.getString("img_url"));
                userBuyInfo.setMed_name(rs.getString("med_name"));
                userBuyInfo.setFac_name(rs.getString("factor"));
                userBuyInfo.setProduction_date(rs.getString("production_date"));
                userBuyInfo.setSale_price(Integer.parseInt(rs.getString("sale_price")));
                userBuyInfo.setStock_num(Integer.parseInt(rs.getString("stock_num")));

                list.add(userBuyInfo);

            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtiles.close();
            request.getRequestDispatcher("/userBuy.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void userClick(HttpServletRequest request, HttpServletResponse response) {

        Date date = new Date();
        String year = String.format("%tY", date);
        String month = String.format("%tm", date);
        String day = String.format("%td", date);
        String m = String.format("%tm", date);
        String s = String.format("%ts", date);
        String datee = year+"-"+month+"-"+day;
        String dateStr = year + month + day +m+s;

        String user_id = request.getParameter("user_id");
        List<Num> num = new ArrayList<Num>();
        try{
            String sql = "select count(*) s from storage";

            System.out.println(sql);
            ResultSet rs = JDBCUtiles.query(sql);
            while (rs.next()){
                Num nu = new Num();
                nu.setNumber(Integer.parseInt(rs.getString("s")));
                num.add(nu);
            }

            int n = num.get(0).getNumber();
            //记录总数
            System.out.println("n: "+n);

            String getIdsql = "select med_id , production_date from storage";
            System.out.println("getIdsql"+getIdsql);
            rs = JDBCUtiles.query(getIdsql);
//            String[] med_list = new String[n];
            //保存从数据库中查询的记录
            ArrayList<String> med_list = new ArrayList<>();
            ArrayList<String> data_list = new ArrayList<>();
            while(rs.next()){
                med_list.add(rs.getString("med_id"));
                data_list.add(rs.getString("production_date"));
            }
            //保存需要修改的最终结果
            ArrayList<String> tempId = new ArrayList<>();
            ArrayList<String> tempDate = new ArrayList<>();
            ArrayList<Integer> tempNum = new ArrayList<>();

            for(int i = 0;i<n; i ++){
                String trueId = med_list.get(i)+"_"+data_list.get(i)+"_id";
                String trueNum = med_list.get(i)+"_"+data_list.get(i)+"_num";
                String trueDate = med_list.get(i)+"_"+data_list.get(i)+"_date";
                String tempTojudgeid = request.getParameter(trueId);
                String tempTojudgedate = request.getParameter(trueDate);
                String tempTojudgenum = request.getParameter(trueNum);

//                String tempTojudgedate = request.getParameter(trueDate);
                if(trueId.equals(tempTojudgeid+"_"+tempTojudgedate+"_id")){
//                    System.out.println(trueId+"\t"+trueNum+"\t"+trueDate+"\t"+tempTojudgeid);
                    if(Integer.parseInt(request.getParameter(trueNum)) != 0){
                        tempNum.add(Integer.parseInt(request.getParameter(trueNum)));
                        tempId.add(tempTojudgeid);
                        tempDate.add(request.getParameter(trueDate));

                    }
                }
            }
            ArrayList<Double> sale_price = new ArrayList<>();
            ArrayList<Double> discount = new ArrayList<>();
            String sqlM = "select sale_price,discount from medicine_info";
            rs = JDBCUtiles.query(sqlM);
            while(rs.next()){
                sale_price.add(Double.parseDouble(rs.getString("sale_price")));
                discount.add(Double.parseDouble(rs.getString("discount")));
            }
            for(int i=0;i<tempDate.size();i++){
                System.out.println(tempId.get(i)+"-----"+tempDate.get(i)+"-----"+tempNum.get(i));
                String insertSql = "insert into sale_details values('"+dateStr+
                        "','"+user_id+
                        "','"+tempId.get(i)+
                        "','"+tempDate.get(i)+
                        "',"+sale_price.get(i)+
                        ","+discount.get(i)+
                        ","+tempNum.get(i)+
                        ",'"+datee+
                        "')";
                System.out.println(insertSql);
                JDBCUtiles.add(insertSql);

            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
