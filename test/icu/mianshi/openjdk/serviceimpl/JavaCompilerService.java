package icu.mianshi.openjdk.serviceimpl;

import icu.mianshi.openjdk.service.ICompilerService;

public class JavaCompilerService implements ICompilerService {
    @Override
    public String getServiceAddressUrl() {
        return "https://www.mianshi.icu/compiler/javac";
    }
}
