package org.example.patterns.adapter.pdfdoc;

public class PdfProcessor implements DocumentProcessor {
    @Override
    public String process(String filename) {
        return filename.replace(".pdf", ".doc");
    }
}