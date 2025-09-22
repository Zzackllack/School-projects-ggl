/**
 * Despite the errors that the IDE may show, this code compiles and runs correctly.
 * To compile and run the code you need java 25 (JDK 25) or later with preview features enabled.
 * You need the following commands:
 * javac --enable-preview --release 25 -d out java25.java
 * java --enable-preview -cp out java25
 */

void main() {
    var nums = List.of(1, 2, 3);
    IO.println(nums.stream().map(n -> n * n).toList());
}