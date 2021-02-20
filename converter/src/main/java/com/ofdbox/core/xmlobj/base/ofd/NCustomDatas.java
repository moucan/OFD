package com.ofdbox.core.xmlobj.base.ofd;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class NCustomDatas {

    @NotNull
    @XmlElement(name = "ofd:CustomData")
    private List<NCustomData> customDatas;
}
