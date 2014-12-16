// Copyright 2014 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awreporting.util;

import com.google.api.ads.adwords.jaxws.factory.AdWordsServices;
import com.google.api.ads.adwords.jaxws.v201409.mcm.ApiException;
import com.google.api.ads.adwords.jaxws.v201409.mcm.Customer;
import com.google.api.ads.adwords.jaxws.v201409.mcm.CustomerServiceInterface;
import com.google.api.ads.adwords.lib.client.AdWordsSession;

/**
 * {@code CustomerDelegate} encapsulates the {@code CustomerServiceInterface}.
 *
 * This service is used to get info about a customer
 *
 * @author jtoledo@google.com (Julian Toledo)
 */
public class CustomerDelegate {

  private CustomerServiceInterface customerService;

  /**
   * Default Constructor.
   *
   * @param adWordsSession the {@code adWordsSession} to use with the delegate/service
   */
  public CustomerDelegate(AdWordsSession adWordsSession) {
    this.customerService =
        new AdWordsServices().get(adWordsSession, CustomerServiceInterface.class);
  }

  /**
   * Constructor with a CustomerServiceInterface.
   *
   * @param customerService the costumer service available for the session
   */
  public CustomerDelegate(CustomerServiceInterface customerService) {
    this.customerService = customerService;
  }

  /**
   * Access basic details about any customer.
   * 
   * @return Customer with the  details about the customer.
   * @throws ApiException error retrieving the accounts page
   */
  public Customer getCustomer() throws ApiException {
      return customerService.get();
  }
}