//package com.mindtickle.test.api.sample;
import org.testng.annotations.DataProvider;
public class SampleDataProviderClass {
        @DataProvider(name = "username-data-provider")
        public static Object[] dataProviderMethod()
        {
            return new Object[] {  "UserName1" , "UserName2" };
        }
    }
