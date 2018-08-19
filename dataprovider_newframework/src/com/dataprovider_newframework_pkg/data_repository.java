package com.dataprovider_newframework_pkg;

//import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class data_repository {
  

  @DataProvider(name="login_data")
  public static Object[][] loginsheet() {
	  Object[][] arrayObject = excel_utility.getExcelData("G:\\mobile app testing\\---------------------excel property file\\login.xls","Sheet1");
		return arrayObject;
  }
}
