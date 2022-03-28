package project.apicapstone.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.LinkedList;
import java.util.List;

public class ErrorUtils {
	public static List<String> getErrorMessages(BindingResult errors){
		List<String> messages = new LinkedList<>();
		for(ObjectError err : errors.getAllErrors())
			messages.add(err.getDefaultMessage());
		
		return messages;
	}
}
