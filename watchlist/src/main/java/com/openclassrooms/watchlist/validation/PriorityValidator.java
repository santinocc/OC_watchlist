package com.openclassrooms.watchlist.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityValidator implements ConstraintValidator<Priority, String> {

	@Override
	public void initialize(Priority constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return value.trim().length() == 1 && "LMH".contains(value.trim().toUpperCase());
	}

}
