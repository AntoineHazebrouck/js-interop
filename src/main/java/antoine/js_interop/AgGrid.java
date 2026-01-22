package antoine.js_interop;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("ag-grid-wrapper")
@NpmPackage(value = "ag-grid-enterprise", version = "35.0.0")
@JsModule("src/ag-grid-wrapper.ts")
public class AgGrid extends Component implements HasSize {

    public <T> void setRowData(
        List<T> data,
        Function<T, Map<String, Object>> properties
    ) {
        getElement().setPropertyList(
            "rowData",
            data.stream().map(properties).toList()
        );
    }

    public void setColumnDefs(ColDef... cols) {
        var asMaps = Stream.of(cols)
            .map(def ->
                Map.of(
                    "headerName",
                    def.getHeaderName(),
                    "field",
                    def.getField(),
                    "enablePivot",
                    def.getEnablePivot(),
                    "enableRowGroup",
                    def.getEnableRowGroup(),
                    "enableValue",
                    def.getEnableValue()
                )
            )
            .toList();

        getElement().setPropertyList("columnDefs", asMaps);
    }
}
