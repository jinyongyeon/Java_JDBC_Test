import java.sql.*;
import java.util.Scanner;


public class JDBC_String {

//    public static void main(String[] args) {
//        JDBC_String str = new JDBC_String();
//        str.JDBC_patient();
//        str.JDBC_reception_reservation();
//
//    }
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버;
    String Host = "jdbc:mysql://stg-recv3.cluster-chpa27ji6cru.ap-northeast-2.rds.amazonaws.com:3306/stg_reception_v3?characterEncoding=utf8&characterSetResults=utf8&serverTimezone=UTC&useSSL=false"; //접속할 DB 서버

    String Username = "goodoc_reception_app"; //DB에 접속할 사용자 이름
    String Password = "BX_3^)-7_vCbx$x~)Ek-jm2;G]zwtRlZ"; //사용자의 비밀번호
    String[] patient;
//    String pid = patient[0];
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    int i = 0 ;


    public void JDBC_reception_reservation() {

        try { //Reflection 방식

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(Host, Username, Password); //db 내의 데이터를 저장
//            state = conn.createStatement(); //sql 문을 실행하기 위해 conn 연결 정보를 state로 생성

            String sql;
            sql = "SELECT * FROM reception_reservation WHERE patnt_id = ? ;";

//            ResultSet rs = state.executeQuery(sql); // sql 실행결과를 rs에 저장
            pstmt = conn.prepareStatement(sql);


            for(int i = 0; i < patient.length; i++) {


                pstmt.setString(1, patient[i]);



                rs = pstmt.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("> 컬럼 개수 : " + rsmd.getColumnCount());

                System.out.println("--------------------------------------------------------------------------------------------");
                for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                    System.out.printf("%s\t", rsmd.getColumnName(j));
                }
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------");

                while (rs.next()) {

                    for (int k = 1; k <= rsmd.getColumnCount(); k++) {

                        System.out.print(rs.getString(k) + " | ");

                    }//for


                    System.out.println();





                } //while


                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------");

            }



            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null)
                    pstmt.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null)
                    conn.close();
            }catch (SQLException e){

            }
        }

    }

    public void JDBC_patient() {


        try { //Reflection 방식

            String phone;
            String hospital_no;

            Scanner sc = new Scanner(System.in);
            System.out.println("hospital_no 입력하세요");
            hospital_no = sc.next();
            System.out.println("핸드폰 번호를 입력하세요");
            phone = sc.next();


            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(Host, Username, Password); //db 내의 데이터를 저장
//            state = conn.createStatement(); //sql 문을 실행하기 위해 conn 연결 정보를 state로 생성

            String sql;
            sql = "SELECT p.id FROM patient p WHERE p.hospital_no = ? and p.phone = ? ;";

//            ResultSet rs = state.executeQuery(sql); // sql 실행결과를 rs에 저장
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,hospital_no);
            pstmt.setString(2,phone); //b656ed7fb9c5d1e918721a89ac69f5e8


            patient = new String[100];

            rs = pstmt.executeQuery();

            int cnt = 0;

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("> 컬럼 개수 : "+rsmd.getColumnCount());

            System.out.println("--------------------------------------------------------------------------------------------");
            for (int i =1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%s\t", rsmd.getColumnName(i));
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------");


            while (rs.next()) {
                patient[cnt] = rs.getString("id");
                cnt++;

                for(int i = 1; i <= rsmd.getColumnCount(); i++) {

                    System.out.print(rs.getString(i)+" | ");


                }//for
//
                System.out.println();



            } //while

            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------");



            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(pstmt != null)
                    pstmt.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null)
                    conn.close();
            }catch (SQLException e){

            }
        }
    }

}