module helloworld {
/**
 * 表示这个模块依赖哪些模块，其实java.base不需要明确requires,
 * 因为默认会增加，就像java.lang不用明确import一样的。
 */
	requires java.base;
	requires java.compiler;

	/**
	 * 表示这个模块向外暴露哪些包，这个是在编译时可以引用的包。
	 */
	exports icu.mianshi.openjdk.compiler;

	/**
	 * 这个也表示这个模块的暴露哪些包，只不过是运行时可用，
	 * 就是编译时不能引用，但是可以用反射的方法调用。
	 */
	opens icu.mainshi.oepnjdk.ref;

	/**
	 * 表示这个模块提供的接口或是虚类的实现，可以通过java.util.ServiceLoader来加载实现的。
	 */
	provides icu.mianshi.openjdk.service.ICompilerService
			with icu.mianshi.openjdk.serviceimpl.JavaCompilerService;

	/**
	 * 表示这个模块要用到的另人申明的接口或是虚类。
	 */
	uses javax.annotation.processing.Processor;
}