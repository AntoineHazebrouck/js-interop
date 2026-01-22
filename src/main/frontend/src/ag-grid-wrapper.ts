import {
    AllEnterpriseModule,
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

    @property()
    rowData: any[] = [];

    @property()
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
    }

    protected updated(_changedProperties: PropertyValues): void {
        if (this.gridApi && _changedProperties.has("rowData")) {
            this.gridApi.setGridOption("rowData", this.rowData);
        }
    }

    protected render() {
        return html`
            <div id="myGrid" style="height: 500px; width: 100%;"></div>
        `;
    }
}
