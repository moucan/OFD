package com.ofdbox.core.xmlobj.base.page;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ofd:Content")
public class NPageContent {

    @Valid
    @Size(min = 1)
    @XmlElement(name = "ofd:Layer")
    private List<NLayer> layers;
}
