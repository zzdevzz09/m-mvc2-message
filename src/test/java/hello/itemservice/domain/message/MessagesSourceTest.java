package hello.itemservice.domain.message;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessagesSourceTest {
	@Autowired
	MessageSource ms;
	
	@Test
	void helloMessage() {
		String result = ms.getMessage("hello", null, null);
		assertThat(result).isEqualTo("안녕");
	}
	
	@Test
	void notFoundMessageCode() {
		assertThatThrownBy(()->ms.getMessage("no_code", null, null)).isInstanceOf(NoSuchMessageException.class);
	}
}
