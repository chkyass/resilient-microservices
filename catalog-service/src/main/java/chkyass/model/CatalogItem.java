package chkyass.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogItem {
    private String name;
    private String desc;
    private String rating;

    public CatalogItem(String name, String desc, String rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }
}
