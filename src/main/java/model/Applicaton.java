package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applicaton {
    private int id;
    private String name;
    private String author;
    private String version;

}
