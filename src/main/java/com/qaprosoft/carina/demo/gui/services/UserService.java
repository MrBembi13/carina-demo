package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.services.components.Constants;
import com.qaprosoft.carina.demo.gui.services.components.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static Logger LOGGER = Logger.getLogger(User.class);
    private static List<User> userList = new ArrayList<>();

    public static User getUserForLogin() {
        User user = new User();
        user.setNickname(R.TESTDATA.get("user001.nickname"));
        user.setEmail(R.TESTDATA.get("user001.email"));
        user.setPassword(R.TESTDATA.get("user001.password"));
        LOGGER.info("User parameters for Login:");
        LOGGER.info(user);
        return user;
    }

    public static User getRandomUserForSignUp() {
        User user = new User();
        user.setNickname(RandomStringUtils.randomAlphabetic(8));
        user.setEmail(RandomStringUtils.randomAlphabetic(5, 8) + Constants.getEmailBoxGmail());
        user.setPassword(RandomStringUtils.randomAlphanumeric(10));
        LOGGER.info("User parameters for Sign up");
        LOGGER.info(user);
        return user;
    }


    // DON'T WORK
    // Method get List users from properties
    /*
     *   public static List<User> getUserList() {
     *       User user = new User();
     *       while () {
     *           user.setNickname(R.TESTDATA.get("user001.nickname"));
     *           userList.add(user);
     *       }
     *       return userList;
     *   }
     * */
}
