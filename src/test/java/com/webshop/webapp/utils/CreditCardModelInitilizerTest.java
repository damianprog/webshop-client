package com.webshop.webapp.utils;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.Address;
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.factories.CreditCardFactory;
import com.webshop.webapp.factories.ModelMapFactory;
import com.webshop.webapp.utils.CreditCardModelInitializer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CreditCardModelInitilizerTest {

	@InjectMocks
	private CreditCardModelInitializer creditCardModelInitilizer;
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private CreditCardService creditCardServiceMock;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private ModelMapFactory modelMapFactoryMock;
	
	@Mock
	private User userMock;
	
	@Mock
	private CreditCard creditCardMock;
	
	@Mock
	private ModelMap modelMapMock;
	
	@Mock
	private Address addressMock;
	
	@Mock
	private CreditCardFactory creditCardFactoryMock;
	
	@Mock
	private UserDetails userDetailsMock;
	
	@Test
	public void prepareTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(creditCardServiceMock.getDefaultCreditCardByUserId(1)).thenReturn(creditCardMock);
		when(modelMapFactoryMock.createInstance()).thenReturn(modelMapMock);
		when(creditCardMock.getAddress()).thenReturn(addressMock);
		
		creditCardModelInitilizer.prepareOrCreate();
		
		verify(modelMapMock).addAttribute("creditCard",creditCardMock);
		verify(modelMapMock).addAttribute("address",creditCardMock.getAddress());
		
	}

	@Test
	public void createTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(creditCardServiceMock.getDefaultCreditCardByUserId(1)).thenReturn(null);
		when(modelMapFactoryMock.createInstance()).thenReturn(modelMapMock);
		when(creditCardFactoryMock.createInstance()).thenReturn(creditCardMock);
		when(userMock.getUserDetails()).thenReturn(userDetailsMock);
		when(userDetailsMock.getAddress()).thenReturn(addressMock);
		
		creditCardModelInitilizer.prepareOrCreate();
		
		verify(creditCardFactoryMock).createInstance();
		verify(modelMapMock).addAttribute("creditCard",creditCardMock);
		verify(modelMapMock).addAttribute("address",addressMock);
		
	}
	
}
