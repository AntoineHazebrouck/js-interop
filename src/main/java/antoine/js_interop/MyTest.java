package antoine.js_interop;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("my-test-element")
@JsModule("./src/my-test-element.ts")
public class MyTest extends Component {

    public MyTest(String msg) {
        getElement().setProperty("name", msg);
    }
}
