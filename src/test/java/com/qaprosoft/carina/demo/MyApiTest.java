package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.myApi.DeleteUser;
import com.qaprosoft.carina.demo.myApi.GetUser;
import com.qaprosoft.carina.demo.myApi.PostUser;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

/**
 * Test api on https://gorest.co.in/
 *
 * @author Vasyl Rudyk
 */
public class MyApiTest extends APISampleTest {

    @Test(description = "get request")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testGetUsers() {
        GetUser getUser = new GetUser();
        getUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        getUser.callAPI();
        getUser.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUser.validateResponseAgainstJSONSchema("myApi/_get/rs.schema");
    }

    @Test(description = "post request")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testCreateUser() {
        PostUser api = new PostUser();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        api.callAPI();
        api.validateResponse();
    }

    @Test(description = "delete request")
    @MethodOwner(owner = "Vasyl Rudyk")
    public void testDeleteUsers() {
        DeleteUser deleteUserMethod = new DeleteUser();
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
        deleteUserMethod.validateResponse();
    }
}
