package test.developmentaid.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ApiResponseDto {
    private List<UserResponseDto> items;
    @JsonAlias(value = "has_more")
    private boolean hasMore;
    @JsonAlias(value = "quota_max")
    private int quotaMax;
    @JsonAlias(value = "quota_remaining")
    private int quotaRemaining;
}
