package antoine.js_interop;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ColDef {

    private final String field;
    private final String headerName;
    private final Boolean enablePivot;
    private final Boolean enableRowGroup;
    private final Boolean enableValue;
}
