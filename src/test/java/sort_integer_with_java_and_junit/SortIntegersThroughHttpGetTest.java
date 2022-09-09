package sort_integer_with_java_and_junit;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class SortIntegersThroughHttpGetTest {

	@Test
	public void testSort() {
		String intsToSort = "3,1,2";
		String expectedIntSorted = "[1,2,3]";
		try {
			String actualIntSorted = httpGetToServlet(intsToSort);
			assertEquals(expectedIntSorted, actualIntSorted);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	private String httpGetToServlet(String intsToSort) throws Exception{
		String comaSeparatedIntegersToSort = intsToSort;
		String paramName = "intsToSort";
		String urlServletSort = "http://localhost:8080/sort_integer_with_java_and_servlet_and_webxml/sortIntegers";
		String urlConnection = urlServletSort + "?" + paramName + "=" + comaSeparatedIntegersToSort;
		HttpURLConnection con = null;
		URL url = new URL(urlConnection);
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(true);
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		int status = con.getResponseCode();
		if(status != 200) {
			System.out.println("Problem, response code : "+status);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		in.close();
		return content.toString();
	}

}
