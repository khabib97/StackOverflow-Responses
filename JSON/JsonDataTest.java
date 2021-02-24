public class JsonDataTest {
	public static void main(String[] args) { 
    
		List<Integer> data = new ArrayList<Integer>();
		data.add(10);
		data.add(20);
    //create json data using java
    org.json.JSONObject jsonObject = new org.json.JSONObject();
    jsonObject.put("name", "max");
    jsonObject.put("age", 10);
    jsonObject.put("data", data);
    //convert it to java string
    String payload = jsonObject.toString();
        
    System.out.println(payload); //{"data":[10,20],"name":"max","age":10}
     
    //convert string to json 
    org.json.JSONObject newJsonObject = new org.json.JSONObject(payload);
    //get value using key
    System.out.println(newJsonObject.get("data"));
	}
}
