package com.lan.tools.javac.resources;

public final class launcher extends java.util.ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
                { "launcher.err.cant.access.main.method", "can''t access main method in class: {0}" },
                { "launcher.err.cant.find.class", "can''t find class: {0}" },
                { "launcher.err.cant.find.main.method", "can''t find main(String[]) method in class: {0}" },
                { "launcher.err.cant.read.file", "error reading source file {0}: {1}" },
                { "launcher.err.compilation.failed", "compilation failed" },
                { "launcher.err.enable.preview.requires.source", "--enable-preview must be used with --source" },
                { "launcher.err.file.not.found", "source file not found: {0}" },
                { "launcher.err.invalid.filename", "invalid path for source file: {0}" },
                { "launcher.err.invalid.value.for.source", "invalid value for --source option: {0}" },
                { "launcher.err.main.not.public.static", "''main'' method is not declared ''public static''" },
                { "launcher.err.main.not.void", "''main'' method is not declared with a return type of ''void''" },
                { "launcher.err.no.args", "no path for source file" },
                { "launcher.err.no.class", "no class declared in source file" },
                { "launcher.err.no.value.for.option", "no value given for option: {0}" },
                { "launcher.error", "error: " },
        };
    }
}
