package com.openclassrooms.watchlist.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<Rating, String> {

	@Override
	public void initialize(Rating constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Double number;
		try {
			number = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		}

		if (number > 10 || number < 1) {
			return false;
		}
		return true;
	}

}
