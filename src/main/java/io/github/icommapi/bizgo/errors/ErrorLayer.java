package io.github.icommapi.bizgo.errors;

import java.util.Locale;

/**
 * Which part of Bizgo rejected the request. The same code can mean different things in each layer: {@code A401}
 * is an authentication failure at the gateway but an invalid {@code paymentCode} in the service layer.
 */
public enum ErrorLayer {
    /** API gateway: authentication, permission and request format ({@code common.authCode}). */
    GATEWAY,
    /** Product API processing ({@code data.code}). */
    SERVICE;

    /** Lower-case name ({@code gateway} / {@code service}), as used in error messages. */
    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
