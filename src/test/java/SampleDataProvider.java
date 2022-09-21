//package com.mindtickle.test.api.sample;
import org.testng.annotations.DataProvider;
public class SampleDataProvider
{
    @DataProvider(name = "username-data-provider")
    public static Object[] userData()
    {
        return new Object[] {  "UserName1" , "UserName2" };
    }

    @DataProvider(name = "username-update-data-provider")
    public static Object[] updateUserData()
    {
        return new Object[] {  "UserName1Updated" , "UserName2Updated" };
    }

    @DataProvider(name = "username-both-data-provider")
    public static Object[] bothUserData()
    {
        return new Object[] {  "UserName1" , "UserName2", "UserName1Updated" , "UserName2Updated" };
    }
}
