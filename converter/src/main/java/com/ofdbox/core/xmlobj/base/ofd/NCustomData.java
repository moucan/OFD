package com.ofdbox.core.xmlobj.base.ofd;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class NCustomData {


    @XmlValue
    private String value;

    @XmlAttribute(name = "Name")
    private String name;
}
