package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
public class SWPeople {
    private int count;
    private String next;
    private String previous;
    private List<SWPerson> results;
}
