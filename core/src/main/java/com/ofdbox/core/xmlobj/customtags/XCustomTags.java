package com.ofdbox.core.xmlobj.customtags;

import lombok.Data;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "ofd:CustomTags")
public class XCustomTags {

    @Valid
    @XmlElement(name = "ofd:CustomTag")
    private List<NCustomTag> tags;

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("w");
        s.add("e");
        s.add("c");
        s.add(1,"s");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }
}
