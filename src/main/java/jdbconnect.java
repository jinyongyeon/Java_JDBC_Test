import java.sql.*;
import java.util.Scanner;


public class jdbconnect {

    public static void main(String[] args) {
        new jdbconnect();

    }
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //드라이버;
    String Host = "jdbc:mysql://stg-recv3.cluster-chpa27ji6cru.ap-northeast-2.rds.amazonaws.com:3306/stg_reception_v3?characterEncoding=utf8&characterSetResults=utf8&serverTimezone=UTC&useSSL=false"; //접속할 DB 서버

    String Username = "goodoc_reception_app"; //DB에 접속할 사용자 이름
    String Password = "BX_3^)-7_vCbx$x~)Ek-jm2;G]zwtRlZ"; //사용자의 비밀번호

    public jdbconnect() {

        Connection conn = null;
//        Statement state = null;
        PreparedStatement pstmt = null;
//        PreparedStatement pstmt2 = null;

        ResultSet rs = null;

        try { //Reflection 방식

            String name;
            String phone;
            String hospital_no;

            Scanner sc = new Scanner(System.in);
            System.out.println("이름을 입력하세요");
            name = sc.next();
            System.out.println("hospital_no 입력하세요");
            hospital_no = sc.next();
            System.out.println("핸드폰 번호를 입력하세요");
            phone = sc.next();


            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(Host, Username, Password); //db 내의 데이터를 저장
//            state = conn.createStatement(); //sql 문을 실행하기 위해 conn 연결 정보를 state로 생성



            String sql;
//            sql = "select name, hospital_no, phone from patient where name = ? ; ";
            sql = "SELECT * FROM reception_reservation WHERE patnt_id in (SELECT p.id FROM patient p WHERE p.name = ? and p.hospital_no = ? and p.phone = ? );";
//            sql = "SELECT p.id FROM patient p WHERE p.hospital_no = ? and p.phone = ? ;";
//            String sql2;
//            sql2 = "SELECT * FROM reception_reservation WHERE patnt_id = ? ;";

//            ResultSet rs = state.executeQuery(sql); // sql 실행결과를 rs에 저장
            pstmt = conn.prepareStatement(sql);
//            pstmt2 = conn.prepareStatement(sql2);


            pstmt.setString(1,name); //32a506a4b633917e66096b581884522c
            pstmt.setString(2,hospital_no); //20000091
            pstmt.setString(3,phone); //b656ed7fb9c5d1e918721a89ac69f5e8


            rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("> 컬럼 개수 : "+rsmd.getColumnCount());

            System.out.println("--------------------------------------------------------------------------------------------");
            for (int i =1; i <= rsmd.getColumnCount(); i++) {
                System.out.printf("%s\t", rsmd.getColumnName(i));
            }
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------");



            while (rs.next()) {
                for(int i = 1; i <= rsmd.getColumnCount(); i++) {

//                    int scale = rsmd.getScale(i); // Number(7,2) 뒤에 2가 scale임
//                    int columnType = rsmd.getColumnType(i);
//
//                    if (columnType == Types.NUMERIC && scale ==0) { //정수란 소리
//                        System.out.printf("%d\t",rs.getInt(i));
//
//                    }else if(columnType == Types.NUMERIC && scale !=0) {//실수란 소리
//                        System.out.printf("%.2f\t", rs.getDouble(i));
//
//                    }else if(columnType == Types.VARCHAR|| columnType == Types.CLOB) {//문자
//                        System.out.printf("%s\t", rs.getString(i));
//
//                    }else if(columnType == Types.DATE|| columnType == Types.TIMESTAMP) {//날짜
//                        System.out.printf("%tF\t",  rs.getDate(i));
//                        //날짜는 %f , %tF, %s 상관 없음
//
//                    }
                    System.out.print(rs.getString(i)+" | ");


                }//for

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
