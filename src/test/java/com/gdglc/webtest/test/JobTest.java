package com.gdglc.webtest.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-job.xml"})
public class JobTest {
	@Test
	public void job(){
		try {
			int read = System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
