package com.webshop.webapp.utils;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webshop.webapp.Application;
import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.service.AddressService;
import com.webshop.webapp.utils.IsItDefaultAccountAddressChecker;
import com.webshop.webapp.utils.OldBillingAddressRemover;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class OldBillingAddressRemoverTest {

	@InjectMocks
	private OldBillingAddressRemover oldBillingAddressRemover;
	
	@Mock
	private IsItDefaultAccountAddressChecker isItDefaultAccountAddressCheckerMock;
	
	@Mock
	private AddressService addressServiceMock;
	
	@Mock
	private CreditCardOperationsParameters cdOperationsParamsMock;
	
	@Test
	public void removeOldBillingAddressTest() {
		
		when(cdOperationsParamsMock.getAddressId()).thenReturn(1);
		
		when(cdOperationsParamsMock.isSetDefaultAddress()).thenReturn(false);
		when(isItDefaultAccountAddressCheckerMock.check(1)).thenReturn(false);
		
		oldBillingAddressRemover.removeOrNotOldBillingAddress(cdOperationsParamsMock);
		
		verify(addressServiceMock).deleteAddressById(1);
		
	}
	
	@Test
	public void dontRemoveOldBillingAddressTest() {
		
		when(cdOperationsParamsMock.getAddressId()).thenReturn(1);
		
		when(cdOperationsParamsMock.isSetDefaultAddress()).thenReturn(true);
		when(isItDefaultAccountAddressCheckerMock.check(1)).thenReturn(true);
		
		oldBillingAddressRemover.removeOrNotOldBillingAddress(cdOperationsParamsMock);
		
		verify(addressServiceMock,never()).deleteAddressById(1);
		
	}
	
}
