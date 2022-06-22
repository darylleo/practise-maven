package com.daryl.util.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author Lvgm
 * date 2019-11-21
 */

@Component
public class HtmlCodeToPdf {

    private static final Logger logger = LoggerFactory.getLogger(HtmlCodeToPdf.class);

    //@Value("${system.file.fontOpen}")
    private boolean fontOpen = true;

   // @Value("${system.file.fontPath}")
    private String fontPath  = "D:\\test\\simsun.ttc";

    /**
     * 将htmlCode转换为pdf文件
     *
     * @param htmlCode 其中body体必须包含字体样式设置，否则无法识别汉字。
     *                 字体样式设置举例：style='font-family:SimSun'
     * @param pdfPath  实际存在的全路径pdf文件
     */

    public void htmlCodeToPdf(String htmlCode, String pdfPath, boolean hasImg) throws DocumentException {
        try (OutputStream os = new FileOutputStream(pdfPath)) {
            ITextRenderer renderer = new ITextRenderer();
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont(getFontPath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            if (hasImg) {
                // 如果携带图片则加上以下代码,将图片标签转换为Itext自己的图片对象
                renderer.getSharedContext().setReplacedElementFactory(new Base64ImgReplacedElementFactory());
                renderer.getSharedContext().getTextRenderer().setSmoothingThreshold(0);
            }
            renderer.setDocumentFromString(htmlCode);
            renderer.layout();
            renderer.createPDF(os);
        } catch (IOException e) {
            logger.error("html error", e);
        }
    }

    private String getFontPath() {
        String filePath = null;
        if (fontOpen) {
            return fontPath;
        }
        try {
            URL url = HtmlCodeToPdf.class.getClassLoader().getResource("simsun.ttc");
            if (url != null) {
                filePath = url.getPath();
            }
        } catch (Exception e) {
            logger.error("filePath error", e);
        }
        if (StringUtils.isBlank(filePath)) {
            logger.error("fontPath can not find");
        }
        return filePath;
    }
}




