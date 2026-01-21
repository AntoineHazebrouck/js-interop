package antoine.js_interop;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {

    private final String firstname;
    private final String lastname;
}
