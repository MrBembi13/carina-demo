package com.qaprosoft.carina.demo.myApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostUser extends AbstractApiMethodV2 {
    public PostUser() {
        super("myApi/_post/rq.json", "myApi/_post/rs.json", "myApi/_post/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
