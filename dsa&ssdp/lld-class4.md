





```java
	
	class Rectangle {
		int l;
		int b;
	}

	class Square extends Rectangle{
		setH(int h) {
			this.l = h;
			this.h = h;
		}
		setL(int l) {
			this.l = l;
			this.h = l;
		}
	}



	method(Rectangle r);


	method(new Square());




	method(Rectangle r) {
		r.setH(4);
		r.setL(5);
		print(r.area());
	}


	method(new Square());


==============================================

// Bad bad

	interface Shape {
		void draw();
		void rotate();
	}

	class Circle implements Shape {
		draw() {

		}
		rotate() {
			throws new Exception("");
		}
 	}

	class Rectangle implements Shape {
		draw() {

		}
		rotate() {
			
		}
	}

	/// FiX

	interface Shape {

	}

	interface Drawable {
		void draw();
	}

	interface Rotatable {
		void rotate();
	}

	class Circle implements Drawable {
		draw() {

		}
 	}

	class Rectangle implements Drawable, Rotatable {
		draw() {

		}
		rotate() {
			
		}
	}

--------------------------------------------------

	drawAllShapes(List<Drawable> shapes) {
		for(Shape shape: shapes) {
			shape.draw();
		}
	}


	rotateAll(List<Rotatable> shapes) {
		for(Shape shape: shapes) {
			shape.draw();
		}
	}

=================================================


```

```javascript

myfilter(arr, filterFunc) {
	return arr.filter(filterFunc);
}


function oddFilter(num) {
	return num % 2 == 1;
}

function EvenFilter(num) {
	return num % 2 == 0;
}

function MultipleOf5Filter(num) {
	return num % 5 == 0;
}

myfilter([1,2,3,4,5,6,7,8,9,10], EvenFilter);
myfilter([1,2,3,4,5,6,7,8,9,10], MultipleOf5Filter);
```


SOL

I: Interface segregation principle.


Client specific interfaces are better then one general purpose interface.

```java
class PrintReq {
	create();
	delete();
	work();
}

interface PrintModifier {
	create();
	delete();
}
interface PrintWorker {
	work();
}
interface PrintTest() {

}

class PrintReq implements PrintModifier, PrintWorker, PrintTest {

}



// only needs to know create and delete
client1.usePrintReq(PrintModifier modifier) {

}

// only needs to know work
client2.usePrintReq(PrintWorker printWorker) {

}

// only needs to know create, delete and work
client3.usePrintReq(PrintReq printWorker) {

}

```


D dependency inversion principle.


Depend upon abstraction not concretion.


function1
|
function2
|
function3



How to invert dependencies.

Using Interfaces.


Higher level modules should not depend on lower level modules both sould depend on abstraction.

```java

// Bad design
class Logger {
	void info(String message, String where) {
		if(where.equals("standard output")) {
			System.out.print(message);
		} else if(where.equals("file")) {
			FileWriter.write(message);
		} else if(where.equals("s3")) {
			S3.write(message);
		}
	}
	void warn() {

	}
	void error() {

	}
}

void doSomething(Logger logger) {
	logger.info("some message", "file");
}

// Fix 

interface Logger {
	public void info(String message);
}

class S3Logger implements Logger {
	public S3Logger(String awsUserId, String awsKey) {

	}
	public void info(String message) {
		/// some changes.
	}
}

class StdOutputLogger implements Logger {
	public void info(String message) {
		
	}
}

class FileLogger implements Logger {
	public FileLogger(String filePath) {

	}
	public void info(String message) {
		
	}
}

class HDFSLogger implements Logger {

}



void doSomething(Logger logger) {
	logger.info("some message");
}


doSomething -> ConcreteLogger


doSomething
                 -> Abstract Logger
ConcreteLogger 

```