public class TestRunner {

    public static void main(String[] args) {


        // dan이 작성한 String 배열코드
        dna_JDBC_String dna_jdbc_string = new dna_JDBC_String();
        dna_jdbc_string.JDBC_patient();
        dna_jdbc_string.JDBC_reception_reservation();


        // caley가 작성한 arraylist 코드
        JDBC_arraylist al = new JDBC_arraylist();
        al.JDBC_patient();
        al.JDBC_reception_reservation();



        // caley가 작성한 String 배열 코드
        JDBC_String str = new JDBC_String();
        str.JDBC_patient();
        str.JDBC_reception_reservation();
    }
}
