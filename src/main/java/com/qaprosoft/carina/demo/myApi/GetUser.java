package com.qaprosoft.carina.demo.myApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetUser extends AbstractApiMethodV2 {
    public GetUser() {
        super(null, "myApi/_get/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
