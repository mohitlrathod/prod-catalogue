package com.sapient.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sapient.pojo.Error;

public abstract class BaseExceptionHandler {
	private static final ExceptionMapping DEFAULT_ERROR = new ExceptionMapping("Internal server error",
			INTERNAL_SERVER_ERROR);

	private final Map<Class, ExceptionMapping> exceptionMappings = new HashMap<>();

	public BaseExceptionHandler() {
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	protected Error handleThrowable(final Throwable ex, final HttpServletResponse response) {
		ExceptionMapping mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);
		response.setStatus(mapping.status.value());
		return construct(mapping, ex.getMessage());
	}

	protected void registerMapping(final Class<?> clazz, final String message,
			final HttpStatus status) {
		exceptionMappings.put(clazz, new ExceptionMapping(message, status));
	}

	protected Error construct(ExceptionMapping mapping, String message) {
		Error error;
		if (message == null || message == "") {
			error = new Error(mapping.message, mapping.status);
		} else {
			error = new Error(message, mapping.status);
		}
		return error;
	}

	private static class ExceptionMapping {
		private final String message;
		private final HttpStatus status;

		public ExceptionMapping(final String message, final HttpStatus status) {
			this.message = message;
			this.status = status;
		}
	}
}