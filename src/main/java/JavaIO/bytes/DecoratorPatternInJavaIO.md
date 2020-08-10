### JAVA I/O中的装饰者模式
Java I/O使用了装饰者模式来实现。以InputStream为例
- InputStream 是抽象组件
- FileInputStream 是InputStream的子类，属于，具体组件，提供了字节流的输入操作
- FilterStream 属于抽象装饰者，装饰着用于装饰组件，为组件提供额外的功能。例如BufferedInputStream是FilterInputStream的具体组件，为FileInputStream提供缓存功能。
- 实例化一个具有缓存功能的字节流对象时，只需要在 FileInputStream 对象上再套一层 BuweredInputStream 对象即
  可。
    ````
    FileInputStream in = nwe FileInputStream(filePath);
    BufferedInputStream bin = new BufferedInputStream(in);
    ````
- DataInputStream 装饰者提供了对更多数据类型进行输入的操作，比如 int、double 等基本类型。