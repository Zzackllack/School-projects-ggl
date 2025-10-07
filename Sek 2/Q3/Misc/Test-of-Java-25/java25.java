/**
 * Despite the errors that the IDE may show, this code compiles and runs correctly.
 * To compile and run the code you need java 25 (JDK 25) or later with preview features enabled.
 * You need the following commands:
 * javac --enable-preview --release 25 -d out java25.java
 * java --enable-preview -cp out java25
 * @since 2025-09
 * @see https://openjdk.org/jeps/512
 * @implSpec This code was tested with openjdk 25 2025-09-16; OpenJDK Runtime Environment Homebrew (build 25); OpenJDK 64-Bit Server VM Homebrew (build 25, mixed mode, sharing)
 * @author Zacklack
 */

void main() {
    var nums = List.of(1, 2, 3);
    IO.println(nums.stream().map(n -> n * n).toList());
}