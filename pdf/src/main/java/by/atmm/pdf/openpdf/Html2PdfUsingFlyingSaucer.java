package by.atmm.pdf.openpdf;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static by.atmm.pdf.Config.INPUT_DIR;
import static by.atmm.pdf.Config.OUTPUT_DIR;

public class Html2PdfUsingFlyingSaucer {

    private static final String HTML_INPUT = INPUT_DIR + "htmlforopenpdf.html";
    private static final String PDF_OUTPUT = OUTPUT_DIR + "html2pdf.pdf";

    public static void main(String[] args) {
        try {
            Html2PdfUsingFlyingSaucer htmlToPdf = new Html2PdfUsingFlyingSaucer();
            htmlToPdf.generateHtmlToPdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateHtmlToPdf() throws Exception {
        File inputHTML = new File(HTML_INPUT);
        Document inputHtml = createWellFormedHtml(inputHTML);
        File outputPdf = new File(PDF_OUTPUT);
        xhtmlToPdf(inputHtml, outputPdf);
    }

    private Document createWellFormedHtml(File inputHTML) throws IOException {
        Document document = Jsoup.parse(inputHTML, "UTF-8");
        document.outputSettings()
            .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

    private void xhtmlToPdf(Document xhtml, File outputPdf) throws Exception {
        try (OutputStream outputStream = new FileOutputStream(outputPdf)) {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            sharedContext.setReplacedElementFactory(new CustomElementFactoryImpl());
            renderer.setDocumentFromString(xhtml.html());
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }
}
