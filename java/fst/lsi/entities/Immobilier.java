package fst.lsi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "immobilier")
public class Immobilier {
@Id
private int id;
private String address;
private double surface;

}
