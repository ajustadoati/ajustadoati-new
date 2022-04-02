package com.ajustadoati.categoryservice.exceptions;

import lombok.Getter;
import lombok.NonNull;

public class CategoryException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
    private final Reason reason;

    public CategoryException(@NonNull String message, @NonNull Reason reason){
        super(message);
        this.reason = reason;
    }

    public enum Reason {
        CATEGORY_FAILED_BLANK_DESCRIPTION,
        CATEGORY_FAILED_BLANK_NAME,
        CATEGORY_FAILED_GOOGLE_TYPE
    }

}
