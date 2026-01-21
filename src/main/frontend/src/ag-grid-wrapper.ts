import {
    AllEnterpriseModule,
    ColDef,
    createGrid,
    GridApi,
    GridOptions,
    ModuleRegistry,
} from "ag-grid-enterprise";
import { html, LitElement, PropertyValues } from "lit";
import { customElement, property } from "lit/decorators.js";

@customElement("ag-grid-wrapper")
class AgGridWrapper extends LitElement {
    private gridApi?: GridApi;

    @property({ type: Array })
    rowData: any[] = [];

    @property({ type: Array<ColDef> })
    columnDefs: any[] = [];

    protected firstUpdated(_changedProperties: PropertyValues): void {
        ModuleRegistry.registerModules([AllEnterpriseModule]);

        const gridOptions: GridOptions = {
            columnDefs: this.columnDefs,
            rowData: this.rowData,
            sideBar: true,
        };
        const eGui = this.shadowRoot?.querySelector("#myGrid") as HTMLElement;
        this.gridApi = createGrid(eGui, gridOptions);

        console.log(eGui);
        console.log(this.gridApi);
    }

    protected updated(_changedProperties: PropertyValues): void {
        if (this.gridApi && _changedProperties.has("rowData")) {
            this.gridApi.setGridOption("rowData", this.rowData);

            console.log("updated data");
        }
    }

    protected render() {
        return html`
            <div id="myGrid" style="height: 500px; width: 100%;"></div>
        `;
    }
}
