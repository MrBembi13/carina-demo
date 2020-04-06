package com.qaprosoft.carina.demo.gui.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.Constants;
import com.qaprosoft.carina.demo.gui.components.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    private static Logger LOGGER = Logger.getLogger(User.class);

    public static User getUser() {
        User user = getUserList().get(0);
        LOGGER.info("User parameters for Login:");
        LOGGER.info(user);
        return user;
    }

    public static User getRandomUser() {
        User user = new User();
        user.setNickName(RandomStringUtils.randomAlphabetic(8));
        user.setEmail(RandomStringUtils.randomAlphabetic(5, 8) + Constants.EMAIL_BOX_GMAIL);
        user.setPassword(RandomStringUtils.randomAlphanumeric(10));
        LOGGER.info("User parameters for Sign up");
        LOGGER.info(user);
        return user;
    }

    public static List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        String usersPool = R.TESTDATA.get(Constants.USERS_POOL);
        List<String> usersPoolList = Arrays.asList(usersPool.split(Constants.SPLIT_USERS));
        for (String str: usersPoolList) {
                User user = new User();
                user.setNickName(R.TESTDATA.get(str + ".nickname"));
                user.setEmail(R.TESTDATA.get(str + ".email"));
                user.setPassword(R.TESTDATA.get(str + ".password"));
                userList.add(user);
                LOGGER.info(user + " was added to list.");
        }
        LOGGER.info("List Users: " + userList);
        return userList;
    }
}
