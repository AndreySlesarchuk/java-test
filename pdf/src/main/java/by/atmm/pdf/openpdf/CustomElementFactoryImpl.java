package by.atmm.pdf.openpdf;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Element;
import org.xhtmlrenderer.extend.FSImage;
import org.xhtmlrenderer.extend.ReplacedElement;
import org.xhtmlrenderer.extend.ReplacedElementFactory;
import org.xhtmlrenderer.extend.UserAgentCallback;
import org.xhtmlrenderer.layout.LayoutContext;
import org.xhtmlrenderer.pdf.ITextFSImage;
import org.xhtmlrenderer.pdf.ITextImageElement;
import org.xhtmlrenderer.render.BlockBox;
import org.xhtmlrenderer.simple.extend.FormSubmissionListener;

import com.lowagie.text.Image;

import static by.atmm.pdf.Config.OUTPUT_DIR;

public class CustomElementFactoryImpl implements ReplacedElementFactory {
    @Override
    public ReplacedElement createReplacedElement(LayoutContext lc, BlockBox box, UserAgentCallback uac, int cssWidth, int cssHeight) {
        Element e = box.getElement();
        String nodeName = e.getNodeName();
        if (nodeName.equals("img")) {
            String imagePath = e.getAttribute("src");
            try {
                InputStream input = new FileInputStream(OUTPUT_DIR + "" + imagePath);
                byte[] bytes = IOUtils.toByteArray(input);
                Image image = Image.getInstance(bytes);
                FSImage fsImage = new ITextFSImage(image);
                if (cssWidth != -1 || cssHeight != -1) {
                    fsImage.scale(cssWidth, cssHeight);
                } else {
                    fsImage.scale(2000, 1000);
                }
                return new ITextImageElement(fsImage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void reset() {
    }

    @Override
    public void remove(Element e) {
    }

    @Override
    public void setFormSubmissionListener(FormSubmissionListener listener) {
    }
}