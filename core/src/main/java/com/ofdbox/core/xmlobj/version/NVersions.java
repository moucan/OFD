package com.ofdbox.core.xmlobj.version;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(value = XmlAccessType.FIELD)
public class NVersions {

    @XmlElement(name = "ofd:Version")
    private List<NVersion> list;
}
