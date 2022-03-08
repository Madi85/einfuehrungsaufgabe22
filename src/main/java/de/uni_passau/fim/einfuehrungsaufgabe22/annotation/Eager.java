// =============================================================================
//
//   Eager.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Needed, as @Named currently has no eager attribute similar to
 * @ManagedBean(eager = true).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Eager {
}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
