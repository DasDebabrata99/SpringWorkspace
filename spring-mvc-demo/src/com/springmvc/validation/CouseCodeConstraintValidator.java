package com.springmvc.validation;

import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CouseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {

		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		
		boolean result = theCode.startsWith(coursePrefix);
		return result;
	}	
}
