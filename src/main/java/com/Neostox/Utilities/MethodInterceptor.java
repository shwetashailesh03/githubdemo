package com.Neostox.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.Neostox.Base.BasePage;


public class MethodInterceptor extends BasePage implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List <Map<String,String>> list =ExcelUtils.getTestDetails("RUN_MANAGER");
		List<IMethodInstance> result = new ArrayList<>();
		
		for(int i=0; i<methods.size(); i++) {
			for (int j = 0; j <list.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Test Name")) ) {
					if( list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("Test Description"));
					try {
						if(list.get(j).get("Group").equalsIgnoreCase(PropertiesReader.getValue("Group")) ) {    
							result.add(methods.get(i));}
						else if (list.get(j).get("Group") != null){
							result.add(methods.get(i));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				 
				}}
				
			  }
		   }
		
		return result;
		
	}

}