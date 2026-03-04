package org.example.patterns.adapter.pdfdoc;

public class DocProcessor implements DocumentProcessor {
    @Override
    public String process(String filename) {
        return filename.replace(".doc", ".pdf");
    }
}