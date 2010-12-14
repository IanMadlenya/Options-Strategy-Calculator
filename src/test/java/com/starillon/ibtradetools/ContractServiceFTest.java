package com.starillon.ibtradetools;

import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.contract.ASXOption;
import com.starillon.ibtradetools.contract.ASXStock;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 14/12/10
 * Time: 12:50 PM
 */
@Test(groups = "functional")
public class ContractServiceFTest extends BaseFTest {
    @Test
    public void testGetOptionContracts() {
        ASXOption asxOption = new ASXOption("CBA");
        List<ContractDetails> optionDetails = contractService.listOptionsForUnderlying(asxOption);
        assert (!optionDetails.isEmpty());
    }

    @Test
    public void testGetStockContractDetails() {
        List<ContractDetails> optionDetails = contractService.listOptionsForUnderlying(new ASXStock("CBA"));
        assert (optionDetails.size() == 1);
    }


    @Test(expectedExceptions = NullPointerException.class)
    public void testGetContractsInvalid() {
        contractService.listOptionsForUnderlying(null);
    }
}
