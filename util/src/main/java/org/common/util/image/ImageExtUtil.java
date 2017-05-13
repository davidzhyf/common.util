package org.common.util.image;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageExtUtil {

	public static void unloading(String readUrl, String outUrl)
			throws FileNotFoundException {
		Image image = new Image(readUrl);
		image.saveAs(outUrl);
	}

	public static void unloading(InputStream in, String fName, String outUrl)
			throws IOException {
		Image image = new Image(in, fName);
		image.saveAs(outUrl);
	}

}
