package chat.custom;

import java.lang.annotation.*;

/**
 * This annotation is here to demonstrate how simple it is to write custom annotation in Atmosphere.
 * @author Jeanfrancois Arcand
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Config {
}
