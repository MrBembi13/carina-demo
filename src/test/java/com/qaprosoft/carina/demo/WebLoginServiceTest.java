package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.services.LoginService;
import com.qaprosoft.carina.demo.gui.services.UserService;
import org.testng.annotations.Test;

/**
 * Test log in on website https://www.gsmarena.com
 *
 * @author Vasyl Rudyk
 */
public class WebLoginServiceTest extends AbstractTest {

    @Test(description = "Test login with LoginService")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testLoginService() {

        System.out.println(UserService.getUserList());

        LoginService.login(getDriver());
    }
}
