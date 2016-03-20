import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class Connection {

	public static boolean isOnline() {
	    boolean b = true;
	    try{
	    	Connection http = new Connection();

			System.out.println("Testing 1 - Send Http GET request");
			http.sendGet();
	    }catch(Exception e) {
	    	e.printStackTrace();
	        b = false;
	    }
	    return b;
	   
	}
	private final String USER_AGENT = "Mozilla/5.0";	
	// HTTP GET request
		private void sendGet() throws Exception {

			String url = "http://10.1.2.44/Raspfin.php";
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
		}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     boolean  a;
		a=Connection.isOnline();
		System.out.println(a);
		
		

	}

}
