# java14compiler
* 这个工程是从OpenJDK里把jdk.compile的代码提取出来做成独立的工程，可能在Java IDE（Intellij IDEA测试过，Eclipse没有）中单步调试，以便学习使用。

# 依赖项
* OpenJDK 14
* Maven 3.6

# 使用指南
* git clone当前项目，然后用Intellij IDEA打开。
* 在项目的 Module Setting里Project下选择项目的SDK为OpenJDK 14.
* 在Run菜单下选择Edit Configurations...,在Program arguments里填上 HelloWorld.java或是其它你想调试的java文件。
* 打开src/main/java/com/lan/tools/javac/Main.java里的main函数，设置断点开始调试吧。整个工程跑完会生成HelloWorld.class。

# 改动项目
* 把com.sun的包名都改成com.lan，所以你要找原始代码就照这个对应关系去找就可以了。
* 还有一些内部类都用了反射包装了，具体改动见 https://github.com/lanrobin/java14compiler/commit/367c2b9ddfa1517e7226dcc1f8fd7626ae6b19a0
