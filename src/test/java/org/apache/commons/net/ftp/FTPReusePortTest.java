package org.apache.commons.net.ftp;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.junit.Test;

import junit.framework.TestCase;

public class FTPReusePortTest extends TestCase {

	@Test
	public void test() {
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("127.0.0.1");
			//ftp.setActivePortRange(27000, 27001);
			ftp.login("mizhka","...");
			Thread.sleep(10000);
			InputStream is = ftp.retrieveFileStream("/usr/home/mizhka/pmc.graph");
			while(is.read() != -1) {}; is.close();
			is = ftp.retrieveFileStream("/usr/home/mizhka/pmc.graph");
			while(is.read() != -1) {}; is.close();
			is = ftp.retrieveFileStream("/usr/home/mizhka/pmc.graph");
			while(is.read() != -1) {}; is.close();
			is = ftp.retrieveFileStream("/usr/home/mizhka/pmc.graph");
			while(is.read() != -1) {}; is.close();
			ftp.disconnect();
		} catch (SocketException e) {
			e.printStackTrace();
			fail();
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
