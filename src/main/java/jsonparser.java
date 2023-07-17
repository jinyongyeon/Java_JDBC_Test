import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonparser {

    public static void main(String[] args) {

        String jsonObjectString = "{\"addr\":\"서울특별시 관악구 쑥고개로 101-6(봉천동)\",\"addrDetail\":\"럭스빌602호\",\"brthdy\":\"19820216\",\"cellphone\":\"01088586220\",\"code\":\"200\",\"comPurposeList\":[{\"purpose1\":\"임신 가능성 있음\",\"purpose2\":\"임신 여부 확인\"}],\"deptCode\":\"15\",\"deptNm\":\"산부인과\",\"doctrCode\":\"68666\",\"doctrNm\":\"이희\",\"endpoint\":\"T\",\"etcPurpose\":\"\",\"eventId\":\"100\",\"gdid\":\"VDL3jzsQrUghJvCpoOKCiYA8C/JY3heQkHGu3uF35cx1rShZ5Rexxfp7TpwJHsGcSH1xMsXbYsuTq9YpCbY96Q==\",\"hospitalNo\":\"12390992\",\"jobId\":\"ba487854-07b2-4176-be83-ba6873a6d08a\",\"message\":\"null\",\"name\":\"황지민\",\"path\":\"집/직장 근처\",\"patntChartId\":\"\",\"receptnDttm\":\"2021-10-29T23:44:22.040Z\",\"regNum\":\"8202162783318\",\"roomCode\":\"022\",\"roomNm\":\"2산부인과\",\"serverName\":\"ws-stack2\",\"sessionId\":\"ddde51b1-9bab-8723-433c-eb5fef15292b\",\"sexdstn\":\"2\",\"targetId\":\"617639e525f7ec15fa860497\",\"zip\":\"08786\"}";
        JSONParser parser = new JSONParser();
//        JSONArray jsonArray = null;
        JSONObject jsonObject = null;

        try {


            Object result = parser.parse(jsonObjectString);

            if (result instanceof JSONObject) {
                jsonObject = (JSONObject) parser.parse(jsonObjectString);

                System.out.println(jsonObject);

                System.out.println("addr : " + jsonObject.get("addr"));
                System.out.println("addrDetail : " + jsonObject.get("addrDetail"));
                System.out.println("brthdy : " + jsonObject.get("brthdy"));
                System.out.println("cellphone : " + jsonObject.get("cellphone"));
                System.out.println("code : " + jsonObject.get("code"));
                System.out.println("comPurposeList : " + jsonObject.get("comPurposeList"));
                System.out.println("deptCode : " + jsonObject.get("deptCode"));
                System.out.println("deptNm : " + jsonObject.get("deptNm"));
                System.out.println("doctrCode : " + jsonObject.get("doctrCode"));
                System.out.println("doctrNm : " + jsonObject.get("doctrNm"));
                System.out.println("endpoint : " + jsonObject.get("endpoint"));
                System.out.println("etcPurpose : " + jsonObject.get("etcPurpose"));
                System.out.println("eventId : " + jsonObject.get("eventId"));
                System.out.println("gdid : " + jsonObject.get("gdid"));
                System.out.println("hospitalNo : " + jsonObject.get("hospitalNo"));
                System.out.println("jobId : " + jsonObject.get("jobId"));
                System.out.println("message : " + jsonObject.get("message"));
                System.out.println("name : " + jsonObject.get("name"));
                System.out.println("path : " + jsonObject.get("path"));
                System.out.println("patntChartId : " + jsonObject.get("patntChartId"));
                System.out.println("receptnDttm : " + jsonObject.get("receptnDttm"));
                System.out.println("regNum : " + jsonObject.get("regNum"));
                System.out.println("roomCode : " + jsonObject.get("roomCode"));
                System.out.println("roomNm : " + jsonObject.get("roomNm"));
                System.out.println("serverName : " + jsonObject.get("serverName"));
                System.out.println("sessionId : " + jsonObject.get("sessionId"));
                System.out.println("sexdstn : " + jsonObject.get("sexdstn"));
                System.out.println("targetId : " + jsonObject.get("targetId"));
                System.out.println("zip : " + jsonObject.get("zip"));

            } else;
//                if (result instanceof JSONArray) {
//                jsonArray = (JSONArray) parser.parse(jsonObjectString);

//                System.out.println(jsonArray.size());
//
//
//                System.out.println("addr : " + jsonObject.get("addr"));
//                System.out.println("addrDetail : " + jsonObject.get("addrDetail"));
//                System.out.println("brthdy : " + jsonObject.get("brthdy"));
//                System.out.println("cellphone : " + jsonObject.get("cellphone"));
//                System.out.println("code : " + jsonObject.get("code"));
//                System.out.println("comPurposeList : " + jsonObject.get("comPurposeList"));
//                System.out.println("deptCode : " + jsonObject.get("deptCode"));
//                System.out.println("deptNm : " + jsonObject.get("deptNm"));
//                System.out.println("doctrCode : " + jsonObject.get("doctrCode"));
//                System.out.println("doctrNm : " + jsonObject.get("doctrNm"));
//                System.out.println("endpoint : " + jsonObject.get("endpoint"));
//                System.out.println("etcPurpose : " + jsonObject.get("etcPurpose"));
//                System.out.println("eventId : " + jsonObject.get("eventId"));
//                System.out.println("gdid : " + jsonObject.get("gdid"));
//                System.out.println("hospitalNo : " + jsonObject.get("hospitalNo"));
//                System.out.println("jobId : " + jsonObject.get("jobId"));
//                System.out.println("message : " + jsonObject.get("message"));
//                System.out.println("name : " + jsonObject.get("name"));
//                System.out.println("path : " + jsonObject.get("path"));
//                System.out.println("patntChartId : " + jsonObject.get("patntChartId"));
//                System.out.println("receptnDttm : " + jsonObject.get("receptnDttm"));
//                System.out.println("regNum : " + jsonObject.get("regNum"));
//                System.out.println("roomCode : " + jsonObject.get("roomCode"));
//                System.out.println("roomNm : " + jsonObject.get("roomNm"));
//                System.out.println("serverName : " + jsonObject.get("serverName"));
//                System.out.println("sessionId : " + jsonObject.get("sessionId"));
//                System.out.println("sexdstn : " + jsonObject.get("sexdstn"));
//                System.out.println("targetId : " + jsonObject.get("targetId"));
//                System.out.println("zip : " + jsonObject.get("zip"));

//            }


//            for (int i = 0 ; i < jsonArray.size() ; i++) {
//                jsonObject = (JSONObject) jsonArray.get(i);;
//
//
//            }

        } catch (ParseException | ClassCastException e) {
//            try {
//                jsonObject = (JSONObject) parser.parse(jsonObjectString);
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
//
////            e.printStackTrace();
        } finally {

        }
    }
}