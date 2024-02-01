package com.dev.ed;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MsMasterTableApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(new MsMasterTableApplication());
	}

}
