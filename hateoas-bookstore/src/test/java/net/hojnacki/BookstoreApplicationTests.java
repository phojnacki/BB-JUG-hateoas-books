package net.hojnacki;

import net.hojnacki.bookstore.BookstoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookstoreApplication.class)
public class BookstoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
