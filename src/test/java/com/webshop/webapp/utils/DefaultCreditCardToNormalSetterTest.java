package com.webshop.webapp.utils;

import static org.mockito.Mockito.never;
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
import com.webshop.webapp.entity.CreditCard;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.service.CreditCardService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.DefaultCreditCardToNormalSetter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class DefaultCreditCardToNormalSetterTest {

	@InjectMocks
	private DefaultCreditCardToNormalSetter defaultCreditCardToNormalSetter;
	
	@Mock
	private HttpSession sessionMock;
	
	@Mock
	private CreditCardService creditCardServiceMock;
	
	@Mock
	private UserService userServiceMock;
	
	@Mock
	private CreditCard creditCardMock;
	
	@Mock
	private User userMock;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void setTrueTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(creditCardServiceMock.getDefaultCreditCardByUserId(1)).thenReturn(creditCardMock);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		
		defaultCreditCardToNormalSetter.set();
		
		verify(userServiceMock).getUserById(1);
		verify(creditCardServiceMock).getDefaultCreditCardByUserId(1);
		
		verify(creditCardMock).setUser(userMock);
		verify(creditCardMock).setItDefault(false);
		
		verify(creditCardServiceMock).save(creditCardMock);
		
	}
	
	@Test
	public void setFalseTest() {
		
		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(creditCardServiceMock.getDefaultCreditCardByUserId(1)).thenReturn(null);
		
		defaultCreditCardToNormalSetter.set();
		
		verify(creditCardServiceMock).getDefaultCreditCardByUserId(1);
		
		verify(creditCardMock,never()).setUser(userMock);
		verify(creditCardMock,never()).setItDefault(false);
		verify(creditCardServiceMock,never()).save(creditCardMock);
		
	}
	
	
}
