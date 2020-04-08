package com.qaprosoft.carina.demo.myApi;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteUser extends AbstractApiMethodV2 {

    public DeleteUser() {
        super("myApi/_delete/rq.json", "myApi/_delete/rs.json", "myApi/_delete/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
