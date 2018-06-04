package com.webshop.webapp.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.IsItDefaultAccountAddressChecker;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class IsItDefaultAccountAddressCheckerTest {

	@InjectMocks
	private IsItDefaultAccountAddressChecker isItDefaultAccountAddressChecker;
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private User userMock;
	
	@Mock
	private Address addressMock;
	
	@Mock
	private UserDetails userDetailsMock;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void checkTrueTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(userMock.getUserDetails()).thenReturn(userDetailsMock);
		when(userMock.getUserDetails().getAddress()).thenReturn(addressMock);
		when(addressMock.getId()).thenReturn(1);
		
		assertEquals(true,isItDefaultAccountAddressChecker.check(1));
		
		verify(sessionMock).getAttribute("userId");
		verify(userServiceMock).getUserById(1);
		verify(userMock,times(2)).getUserDetails();
		verify(userDetailsMock).getAddress();
		verify(addressMock).getId();
		
	}
	
	@Test
	public void checkFalseTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(userMock.getUserDetails()).thenReturn(userDetailsMock);
		when(userMock.getUserDetails().getAddress()).thenReturn(addressMock);
		when(addressMock.getId()).thenReturn(2);
		
		assertEquals(false,isItDefaultAccountAddressChecker.check(1));
		
	}
	
}
