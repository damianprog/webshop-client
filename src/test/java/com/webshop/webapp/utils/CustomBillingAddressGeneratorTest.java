package com.webshop.webapp.utils;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.factories.AddressFactory;
import com.webshop.webapp.utils.CustomBillingAddressGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CustomBillingAddressGeneratorTest {

	@InjectMocks
	private CustomBillingAddressGenerator customBillingAddressGenerator;
	
	@Mock
	private HttpSession sessionMock;

	@Mock
	private UserService userServiceMock;
	
	@Mock
	private User userMock;
	
	@Mock
	private UserDetails userDetailsMock;
	
	@Mock
	private AddressFactory addressFactoryMock;
	
	@Mock
	private Address billingAddressMock;
	
	@Mock
	private Address addressMock;
	
	@Mock
	private Map<String, String> paramsMock;
	
	@Test
	public void generateTest() {
	
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(userMock.getUserDetails()).thenReturn(userDetailsMock);
		when(addressFactoryMock.createInstance()).thenReturn(billingAddressMock);
		when(userDetailsMock.getAddress()).thenReturn(addressMock);
		
		customBillingAddressGenerator.generate(paramsMock);
		
		verify(sessionMock).getAttribute("userId");
		verify(userServiceMock).getUserById(1);
		verify(userMock).getUserDetails();
		verify(addressFactoryMock).createInstance();
		verify(userDetailsMock,times(3)).getAddress();
	
		verify(addressMock).getFirstName();
		verify(addressMock).getLastName();
		verify(addressMock).getPhone();

		verify(paramsMock).get("street");
		verify(paramsMock).get("city");
		verify(paramsMock).get("country");
		verify(paramsMock).get("postCode");
		
		
	}	
}
