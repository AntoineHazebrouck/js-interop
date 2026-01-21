import { html, LitElement } from "lit";
import { customElement, property } from "lit/decorators.js";

@customElement("my-test-element")
class MyTestElement extends LitElement {
    @property({ type: String })
    name: string = "";

    render() {
        return html` <h2>Hello ${(this as any)["name"]}</h2> `;
    }
}
