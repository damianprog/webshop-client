package com.webshop.webapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshop.webapp.entity.CreditCardOperationsParameters;
import com.webshop.webapp.entity.service.AddressService;

@Component
public class OldBillingAddressRemover {

	@Autowired
	private IsItDefaultAccountAddressChecker isItDefaultAccountAddressChecker;
	
	@Autowired
	private AddressService addressService;
	
	public void removeOrNotOldBillingAddress(CreditCardOperationsParameters cdOperationsParams) {
		
		int addressId = cdOperationsParams.getAddressId();
		
		boolean isNewAddressSetAsDefault = cdOperationsParams.isSetDefaultAddress();
		boolean isItDefaultAccountAddress = isItDefaultAccountAddressChecker.check(addressId);
		
		if(!isNewAddressSetAsDefault && !isItDefaultAccountAddress)
			addressService.deleteAddressById(addressId);
		
	}
	
}
