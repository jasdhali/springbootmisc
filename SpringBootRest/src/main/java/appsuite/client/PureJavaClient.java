package appsuite.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import appsuite.domain.Item;

public class PureJavaClient {

	public static void some(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/RESTfulDemoApplication/user-management/users/10");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String apiOutput = br.readLine();
			System.out.println(apiOutput);
			conn.disconnect();

			JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Item item = (Item) jaxbUnmarshaller.unmarshal(new StringReader(apiOutput));

			System.out.println(item.getId());
			System.out.println(item.getSku());
			System.out.println(item.getReorderQuantity());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}