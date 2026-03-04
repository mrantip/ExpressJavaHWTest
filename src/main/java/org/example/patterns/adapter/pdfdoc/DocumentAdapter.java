package org.example.patterns.adapter.pdfdoc;

public class DocumentAdapter {
    private DocProcessor docProcessor;
    private PdfProcessor pdfProcessor;

    public DocumentAdapter() {
        this.docProcessor = new DocProcessor();
        this.pdfProcessor = new PdfProcessor();
    }

    public String convert(String fileName) {
        String convetedFile;
        if (fileName.endsWith(".doc")) {
            convetedFile = docProcessor.process(fileName);
        } else {
            convetedFile = pdfProcessor.process(fileName);
        }
        return convetedFile;
    }
}