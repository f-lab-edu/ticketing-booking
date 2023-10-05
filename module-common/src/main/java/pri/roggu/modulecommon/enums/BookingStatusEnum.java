package pri.roggu.modulecommon.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookingStatusEnum implements EnumMapperType{

    READY("READY")
    , BOOKING("BOOKING");

    private final String title;

    @Override
    public String getCode() {
        return name();
    }
}
