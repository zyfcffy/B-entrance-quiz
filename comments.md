### 完成度：
__Details:__
- \- StudentController.java:20 缺少一个专门查看team的接口

### 测试：
* 仅有controller测试
* controller测试，了解下@WebMvcTest

### 知识点：
__Details:__
+ \+ StudentService.java:17 使用了构造器注入
- \- StudentRepository.java:27 这种自增id的方式，线程不安全，试试AtomicInteger
- \- StudentController.java:28 按照restful实践，资源名一般是复数
- \- StudentController.java:31 最好使用Object接@RequestBody

### 工程实践：
__Details:__
+ \+ StudentService.java:14 有抽取Magic number的意识
- \- StudentController.java:36 team相关的接口，单独抽取一个controller来做，与students不是操作的一个资源
- \- StudentService.java:30 长方法，需要按模块抽取方法进行重构



