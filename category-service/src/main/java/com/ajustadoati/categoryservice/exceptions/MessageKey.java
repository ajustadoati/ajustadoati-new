package com.ajustadoati.categoryservice.exceptions;

import java.io.Serializable;

/**
 * Enumeration of common business errors with a describing message.
 */
public interface MessageKey extends Serializable {

    String getKey();

}
