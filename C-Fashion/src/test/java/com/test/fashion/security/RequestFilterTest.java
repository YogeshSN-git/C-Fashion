package com.test.fashion.security;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fashion.Feign.AuthFeign;
import com.fashion.Model.AuthResponse;
import com.fashion.Security.JwtRequestFilter;

import lombok.SneakyThrows;

public class RequestFilterTest {

	@InjectMocks
	JwtRequestFilter jwtRequestFilter;

	@Mock
	AuthFeign authFeign;

	@Before
	public void before() {
		SecurityContextHolder.clearContext();
	}

	@After
	public void after() {
		SecurityContextHolder.clearContext();
	}

	@Test
	@SneakyThrows
	public void doFilterInternal_shouldPopulateSecurityContext_whenTokenIsValid() {

		String token = issueTokenForUser("john.doe");
		MockHttpServletRequest request = new MockHttpServletRequest("GET", "/foo");
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);

		MockHttpServletResponse response = new MockHttpServletResponse();
		FilterChain filterChain = new MockFilterChain();
		FilterConfig filterConfig = new MockFilterConfig();

		JwtRequestFilter filter = new JwtRequestFilter();
		filter.init(filterConfig);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setValid(true);

//	        Mockito.when()

//	        when().thenReturn(authResponse);

//	        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
//	        Mockito.when(securityContext.).thenReturn(true);
//	        SecurityContextHolder.setContext(securityContext);

		filter.doFilter(request, response, filterChain);
		filter.destroy();

//	        assertThat();
	}

	private String issueTokenForUser(String username) {
		return "xxxxx.yyyyy.zzzzz"; // Implement as per your needs
	}
}
