package com.webshop.webapp.utils;

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
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.User;
import com.webshop.webapp.entity.UserDetails;
import com.webshop.webapp.entity.service.AddressService;
import com.webshop.webapp.entity.service.UserService;
import com.webshop.webapp.utils.BillingAddressSetter;
import com.webshop.webapp.utils.CustomBillingAddressGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class BillingAddressSetterTest {

	@InjectMocks
	private BillingAddressSetter billingAddressSetterMock;

	@Mock
	private CustomBillingAddressGenerator customBillingAddressGeneratorMock;

	@Mock
	private AddressService addressServiceMock;

	@Mock
	private UserService userServiceMock;

	@Mock
	private HttpSession sessionMock;

	@Mock
	private CreditCardOperationsParameters cdOperationsParamsMock;

	@Mock
	private User userMock;

	@Mock
	private Map<String, String> paramsMapMock;

	@Mock
	private UserDetails userDetailsMock;

	@Mock
	private Address addressMock;

	@Test
	public void getBillingAddressForSaveOrUpdateNotDefaultAddressTest() {

		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(cdOperationsParamsMock.isSetDefaultAddress()).thenReturn(false);
		when(cdOperationsParamsMock.getParamsMap()).thenReturn(paramsMapMock);

		billingAddressSetterMock.getBillingAddressForSaveOrUpdate(cdOperationsParamsMock);

		verify(sessionMock).getAttribute("userId");
		verify(userServiceMock).getUserById(1);
		verify(customBillingAddressGeneratorMock).generate(paramsMapMock);

	}

	@Test
	public void getBillingAddressForSaveOrUpdateDefaultAddressUpdateTest() {

		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(cdOperationsParamsMock.isSetDefaultAddress()).thenReturn(true);
		when(cdOperationsParamsMock.isUpdateCreditCard()).thenReturn(true);
		when(cdOperationsParamsMock.getAddressId()).thenReturn(2);

		billingAddressSetterMock.getBillingAddressForSaveOrUpdate(cdOperationsParamsMock);

		verify(cdOperationsParamsMock).isUpdateCreditCard();
		verify(addressServiceMock).getAddressById(2);

	}

	@Test
	public void getBillingAddressForSaveOrUpdateDefaultAddressSaveTest() {

		when(sessionMock.getAttribute("userId")).thenReturn(1);
		when(userServiceMock.getUserById(1)).thenReturn(userMock);
		when(cdOperationsParamsMock.isSetDefaultAddress()).thenReturn(true);
		when(cdOperationsParamsMock.isUpdateCreditCard()).thenReturn(false);
		when(cdOperationsParamsMock.getAddressId()).thenReturn(2);
		when(userMock.getUserDetails()).thenReturn(userDetailsMock);
		when(userDetailsMock.getAddress()).thenReturn(addressMock);

		billingAddressSetterMock.getBillingAddressForSaveOrUpdate(cdOperationsParamsMock);

		verify(cdOperationsParamsMock).isUpdateCreditCard();
		verify(userMock).getUserDetails();
		verify(userDetailsMock).getAddress();

	}

}
