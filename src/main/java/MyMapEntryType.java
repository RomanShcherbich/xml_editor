import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlAttribute;

public class MyMapEntryType {

    @XmlAttribute
    public Integer key;

    @XmlValue
    public String value;

}