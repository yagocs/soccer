package Futbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public abstract class Extractor {

	public abstract ArrayList<? extends Extractor> extract(String xml);

	public static String readURL(String urlRoute) throws IOException {
		BufferedReader in = null;
		String inputLine = "";
		String inputText = "";
		try {
			URL url = new URL(urlRoute);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF8"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			while ((inputLine = in.readLine()) != null) {
				inputText = inputText + inputLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close(); // LE GUSTA PREGUNTAR ESTO A ANGEL!!!
		}
		return inputText;
	}
}
