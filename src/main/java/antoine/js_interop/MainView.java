package antoine.js_interop;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.List;
import java.util.Map;

@Route("")
public class MainView extends Composite<VerticalLayout> {

    @Override
    protected VerticalLayout initContent() {
        AgGrid pivotTable = new AgGrid();
        pivotTable.setWidthFull();

        pivotTable.setColumnDefs(
            ColDef.builder()
                .headerName("firstname")
                .field("firstname")
                .enablePivot(true)
                .enableRowGroup(true)
                .enableValue(true)
                .build(),
            ColDef.builder()
                .headerName("lastname")
                .field("lastname")
                .enablePivot(true)
                .enableRowGroup(true)
                .enableValue(true)
                .build()
        );

        pivotTable.setRowData(
            List.of(
                Person.builder()
                    .firstname("Antoine")
                    .lastname("HAZEBROUCK")
                    .build()
            ),
            person ->
                Map.of(
                    "firstname",
                    person.getFirstname(),
                    "lastname",
                    person.getLastname()
                )
        );

        var col = new VerticalLayout(new H1("Hello world"), pivotTable);
        col.setWidthFull();
        return col;
    }
}
