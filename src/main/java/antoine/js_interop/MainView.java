package antoine.js_interop;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Route("")
public class MainView extends Composite<VerticalLayout> {

    private List<Person> data = new ArrayList<>();

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

        Function<Person, Map<String, Object>> mapper = person ->
            Map.of(
                "firstname",
                person.getFirstname(),
                "lastname",
                person.getLastname()
            );

        pivotTable.setRowData(data, person ->
            Map.of(
                "firstname",
                person.getFirstname(),
                "lastname",
                person.getLastname()
            )
        );

        var col = new VerticalLayout(
            new H1("Hello world"),
            new Button("Add someone", event -> {
                data.add(someone());
                pivotTable.setRowData(data, mapper);
            }),
            pivotTable
        );
        col.setWidthFull();
        return col;
    }

    private Person someone() {
        return Person.builder()
            .firstname("Antoine")
            .lastname("HAZEBROUCK")
            .build();
    }
}
