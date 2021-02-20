package com.ofdbox.core.model;

import com.ofdbox.core.xmlobj.annotation.NAnnotationPage;
import com.ofdbox.core.xmlobj.annotation.XAnnotations;
import com.ofdbox.core.xmlobj.annotation.XPageAnnot;
import lombok.Data;

import java.util.List;

/*
* 临时对象
* */
@Data
public class Annotations {
    private XAnnotations xAnnotations;
    private List<AnnotationPage> annotationPages;

    @Data
    public static class AnnotationPage{
        private NAnnotationPage nAnnotationPage;
        private XPageAnnot xPageAnnot;
    }
}
