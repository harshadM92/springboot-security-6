package org.my.hakuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MyApplication {

	public static void main(String[] args) {
//		System.out.println(generateSafeToken()); 
		SpringApplication.run(MyApplication.class, args);
	}
	
//	private static String generateSafeToken() {
//	    SecureRandom random = new SecureRandom();
//	    byte[] bytes = new byte[36]; // 36 bytes * 8 = 288 bits, a little bit more than
//	                                 // the 256 required bits 
//	    random.nextBytes(bytes);
//	    var encoder = Base64.getUrlEncoder().withoutPadding();
//	    return encoder.encodeToString(bytes);
//	}
}
