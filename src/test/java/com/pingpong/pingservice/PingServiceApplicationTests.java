package com.pingpong.pingservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"pong.host=localhost", "vcap.application.uris[0]=test"})
public class PingServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
