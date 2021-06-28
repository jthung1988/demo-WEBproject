package tai.spring.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class SpringTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		BCryptPasswordEncoder bcEncoder = new BCryptPasswordEncoder();
		StandardPasswordEncoder standardEncoder = new StandardPasswordEncoder();
		String test = "9983";
//		System.out.println(bcEncoder.encode(test));
//		System.out.println(bcEncoder.encode(test));
//		System.out.println(standardEncoder.encode(test));
//		System.out.println(standardEncoder.encode(test));
		
//		$2a$10$jq8wNyEJEe4.r2rQFRUjv.xcTadlPqomnRyTRXuiUJa0HBwyHhgJe
//		$2a$10$cnD.l7xm7NEWbAj7nDl.s.l7aDFFatQH.IfvsMuo4C/bTORaLA8se
//		810290ed58634c8bc9741d442ec320c0b3587958bd372b181c656fa592b03decc2913349f04ee668
//		d93a03a2f1318727ad182f55b09fa5f64bcf6a7633b968d23f500fee5de024e5452858218ce3c9f9
		
//		System.out.println(bcEncoder.matches(test, "$2a$10$cnD.l7xm7NEWbAj7nDl.s.l7aDFFatQH.IfvsMuo4C/bTORaLA8se"));
//		System.out.println(bcEncoder.matches(test, "$2a$10$jq8wNyEJEe4.r2rQFRUjv.xcTadlPqomnRyTRXuiUJa0HBwyHhgJe"));
//		System.out.println(standardEncoder.matches(test, "810290ed58634c8bc9741d442ec320c0b3587958bd372b181c656fa592b03decc2913349f04ee668"));
//		System.out.println(standardEncoder.matches(test, "d93a03a2f1318727ad182f55b09fa5f64bcf6a7633b968d23f500fee5de024e5452858218ce3c9f9"));
		System.out.println(bcEncoder.matches("andy", "$2a$10$6YFhP2mQr6eCT13Kbqhryen5nAul5FCk.JR9uIMnR28sX1KsEez1m"));
	}

}
