package com.test.fashion.security;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.Security.WebSecurityConfig;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class WebConfigTest {
	
	@InjectMocks
	WebSecurityConfig webSecurityConfig;
	
	

}
